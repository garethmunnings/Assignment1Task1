import java.util.Hashtable;

public class Polynomial {
    Hashtable<Integer, Integer> terms = new Hashtable<>();
    int highestTerm = 0;

    public void setCoefficient(int exp, int coefficient) {
        if(exp > highestTerm) {
            highestTerm = exp;
        }

        terms.put(exp, coefficient);

    }

    public int getCoefficient(int exp) {
        return terms.get(exp);
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
}
