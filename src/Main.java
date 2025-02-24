public class Main {
    public static void main(String[] args) {
        Polynomial f = new Polynomial();
        f.setCoefficient(2, 3);
        f.setCoefficient(1, -2);
        f.setCoefficient(0, 10);
        f.print();
        System.out.println();
        System.out.println(f.evaluate(2));


    }
}
