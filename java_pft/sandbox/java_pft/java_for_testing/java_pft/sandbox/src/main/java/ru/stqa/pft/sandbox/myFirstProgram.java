package ru.stqa.pft.sandbox;
public class myFirstProgram {
    public static void main(String[] args) {
        hello();

        Square s = new Square(5) ;
        System.out.println("The are of the square with the side " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("The are of the rectangle with the sides " + r.a + " and " + r.b + " = " + r.area());
    }

    public static void hello() {
        System.out.println("Hello, worlds!");
    }

}

