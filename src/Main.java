public class Main {
    public static void main(String[] args) {
        Polynomial f = new Polynomial();

        f.setCoefficient(1, 2);
        f.setCoefficient(0, 5);
        System.out.print("f(x) = ");
        System.out.println(f.toString());


        Polynomial fprime = f.derivative();
        System.out.print("f'(x) = ");
        System.out.println(fprime.toString());

//        Polynomial g = new Polynomial();
//        g.setCoefficient(2, 3);
//        g.setCoefficient(1, 1);
//        g.setCoefficient(0, -2);
//        System.out.print("g(x) = ");
//        g.print();

//        Polynomial h = f.add(2, g);


//        System.out.print("h(x) = ");
//        h.print();
//        System.out.println();
        //System.out.println(f.evaluate(2));


    }
}
