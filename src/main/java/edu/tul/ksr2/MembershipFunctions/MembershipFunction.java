package edu.tul.ksr2.MembershipFunctions;

public interface MembershipFunction {
    double compute(double x);
    double compute(double x, double total);
    boolean isRelative = false;

    String generateLatexEq(String name);
}
