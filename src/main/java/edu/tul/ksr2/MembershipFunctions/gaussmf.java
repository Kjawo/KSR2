package edu.tul.ksr2.MembershipFunctions;

public class gaussmf implements MembershipFunction{
    @Override
    public double compute(double x) {
        return 0;
    }

    @Override
    public double compute(double x, double total) {
        return 0;
    }

    @Override
    public String generateLatexEq(String name) {
        return null;
    }

    @Override
    public double getA() {
        return 0;
    }

    @Override
    public double getB() {
        return 0;
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
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double calculateCardinality(double total) {
        return 0;
    }

    @Override
    public double getSupp(double total) {
        return 0;
    }
}
