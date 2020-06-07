package edu.tul.ksr2.MembershipFunctions;

public class gaussmf implements MembershipFunction{

    private double a, b;
    private boolean isRelative = false;

    public gaussmf(double a, double b, boolean isRelative) {
        this.a = a;
        this.b = b;
        this.isRelative = isRelative;
    }

    public gaussmf(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double compute(double x) {
        return Math.exp(-1 * Math.pow(x - b, 2) / Math.pow(2 * a, 2));
    }

    @Override
    public double compute(double x, double total) {
        double temp = x/total;
        return Math.exp(-1 * Math.pow(temp - b, 2) / Math.pow(2 * a, 2));
    }

    @Override
    public String generateLatexEq(String name) {
        return null;
    }

    @Override
    public double getA() {
        return a;
    }

    @Override
    public double getB() {
        return b;
    }

    @Override
    public double getC() {
        return 0;
    }

    @Override
    public double getD() {
        return 0;
    }

    @Override
    public boolean isRelative() {
        return isRelative;
    }

    @Override
    public String getName() {
        return "Gaussian";
    }

    @Override
    public double calculateCardinality(double total) {
            double integral = 0;
            if(this.isRelative){
                for (double x = 0; x < 1; x += 0.01)
                {
                    integral += this.compute(x) * 0.01;
                }
            } else {
                for (double x = 0; x < 1; x += 0.01)
                {
                    integral += this.compute(x, total) * 0.01;
                }
            }
            return integral;
    }

    @Override
    public double getSupp(double total) {
        if(!isRelative){
            return (a + b)/total - (b - a)/total;
        } else {
            return (a + b) - (b - a);
        }
    }
}
