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

    public double evaluate(int x) {
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
}
