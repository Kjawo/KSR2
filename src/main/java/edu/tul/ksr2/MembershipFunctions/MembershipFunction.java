package edu.tul.ksr2.MembershipFunctions;

public interface MembershipFunction {
    double compute(double x);
    boolean isRelative = false;

    String generateLatexEq(String name);
}
