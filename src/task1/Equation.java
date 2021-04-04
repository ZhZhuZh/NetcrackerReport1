package task1;

import java.util.Scanner;

public class Equation {
    private final double a;
    private final double b;
    private final double c;

    Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void roots() {
        class Discriminant {    // nested local class for discriminant
            private final double discriminant;

            Discriminant(double a, double b, double c) {
                discriminant = Math.pow(b, 2) - 4 * a * c;
            }
        }
        Discriminant d = new Discriminant(a, b, c);     // d is a common nation for discriminant
        // calculation of roots occur depending on the value of the discriminant
        if (d.discriminant > 0) {
            double x1 = (-b - Math.sqrt(d.discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(d.discriminant)) / (2 * a);
            System.out.println("Roots of equation: x1=" + x1 + ", x2=" + x2);
        } else if (d.discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Root of equation: x=" + x);
        } else {    //if discriminant < 0
            System.out.println("No real roots");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program can solve quadratic equation of the form ax^2 + bx + c");
        System.out.println("Enter a, b and c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        Equation equation = new Equation(a, b, c);
        equation.roots();
    }
}
