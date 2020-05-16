package edu.tul.ksr2.MembershipFunctions;

public class trapmf implements MembershipFunction {
    private double a, b, c, d;

    public trapmf(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double compute(double x) {
        if (x >= a && b > x) {
            return (x - a) / (b - a);
        }
        else if (x >= b && x <= c) {
            return 1.0;
        }
        else if (x > c && x <= d) {
            return (d - x) / (d - c);
        }
        else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "trapmf{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
