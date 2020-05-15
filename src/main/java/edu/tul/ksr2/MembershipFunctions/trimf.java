package edu.tul.ksr2.MembershipFunctions;

public class trimf implements MembershipFunction {
    private double a, b, c;

    public trimf(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double compute(double x) {
        if (x == b) {
            return 1;
        } else if ( x > a && x <= b) {
            return (1.0/(b-a)) * (x - a);
        } else if (x > b && x < c) {
            return (-1.0/(c-b))*(x-c);
        } else
            return 0;
    }
}
