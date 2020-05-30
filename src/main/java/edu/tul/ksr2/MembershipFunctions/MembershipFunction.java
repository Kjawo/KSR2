package edu.tul.ksr2.MembershipFunctions;

public interface MembershipFunction {
    double compute(double x);
    double compute(double x, double total);
    double a = 0, b = 0, c = 0, d = 0;
    boolean isRelative = false;

    String generateLatexEq(String name);

    public double getA();

    public double getB();

    public double getC();

    public double getD();

    public boolean isRelative();

    public String getName();

    public double calculateCardinality(double total);

    public double getSupp(double total);
}
