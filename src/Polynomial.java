import java.util.Hashtable;

public class Polynomial {
    Hashtable<Integer, Integer> terms = new Hashtable<>();
    public int highestTerm = 0;

    public void setCoefficient(int exp, int coefficient) {
        if(exp > highestTerm) {
            highestTerm = exp;
        }

        terms.put(exp, coefficient);

    }

    public int getCoefficient(int exp) {
        if(terms.get(exp) != null) {
            return terms.get(exp);
        }
        else return -99999;
    }

    public void print() {
        for(int i = 0; i < highestTerm; i++) {
            if(terms.get(i) != null) {
                if(terms.get(i) < 0) {
                    System.out.print("(" + terms.get(i) + ")" + "x^" + i + " + ");
                }
                else
                    System.out.print(terms.get(i) + "x^" + i + " + ");
            }
        }
        if(terms.get(highestTerm) < 0) {
            System.out.print("(" +terms.get(highestTerm) + ")"+ "x^" + highestTerm );
        }
        else
            System.out.print(terms.get(highestTerm) + "x^" + highestTerm);

    }

    @Override public String toString()
    {
        String poly = "";
        //write the highest term
        if(highestTerm > 1)
        {
            poly = terms.get(highestTerm) + "x^" + highestTerm;
        }


        //write all terms except x^1 and x^0
        for(int i = highestTerm -1; i > 1; i--) {
            if(terms.get(i) != null) {
                if(terms.get(i) > 0) {
                    poly = poly.concat("+ " + terms.get(i) + "x^" + i);
                }
                else {
                    poly = poly.concat(terms.get(i) + "x^" + i);
                }
            }
        }
        //Write remaining terms
        if(terms.get(1) != null)
        {
            if(poly == "")
            {
                if(terms.get(1) > 0) {
                    poly = poly.concat(terms.get(1) + "x");
                }
                else{
                    poly = poly.concat(terms.get(1) + "x");
                }
            }
            else {
                if(terms.get(1) > 0) {
                    poly = poly.concat("+ " + terms.get(1) + "x");
                }
                else{
                    poly = poly.concat(terms.get(1) + "x");
                }
            }


        }
        if(terms.get(0) != null)
        {
            if(poly == ""){
                if(terms.get(0) > 0) {
                    poly = poly.concat(terms.get(0) + "");
                }
                else{
                    poly = poly.concat(terms.get(0) + "");
                }
            }
            else{
                if(terms.get(0) > 0) {
                    poly = poly.concat("+ " + terms.get(0) + "");
                }
                else{
                    poly = poly.concat(terms.get(0) + "");
                }
            }

        }

        return poly;
    }

    public double evaluate(double x) {
        double y = 0;
        for(int i = 0; i <= highestTerm; i++) {
            if(terms.get(i) != null) {
                y += terms.get(i) * Math.pow(x, i);
            }
        }

        return y;
    }

    public Polynomial add(int k, Polynomial g) {
        //scalar multiplication on g
        for(int i = 0; i <= g.highestTerm; i++){
            if(g.getCoefficient(i) != -99999) {
                g.setCoefficient(i, k*g.getCoefficient(i));
            }
        }

        //add the two polynomials
        Polynomial h = new Polynomial();
        for(int i = 0; i <= g.highestTerm + highestTerm; i++) {
            if(terms.get(i) != null) {
                if(g.getCoefficient(i) != -99999) {
                    h.setCoefficient(i, g.getCoefficient(i) + terms.get(i));
                }
                else{
                    h.setCoefficient(i, terms.get(i));
                }
            }
            else{
                if(g.getCoefficient(i) != -99999) {
                    h.setCoefficient(i, g.getCoefficient(i));
                }
            }

        }
        return h;
    }

    public Polynomial derivative(){
        Polynomial d = new Polynomial();

        for(int i = 0; i <= highestTerm; i++){
            if(terms.get(i) != null) {
                if(i > 0)
                {
                    d.setCoefficient(i - 1, terms.get(i) * i);
                }
            }
        }


        return d;
    }

}
