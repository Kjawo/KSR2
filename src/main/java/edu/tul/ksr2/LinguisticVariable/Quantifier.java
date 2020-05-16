package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

public class Quantifier {
    private String name;
    private MembershipFunction membershipFunction;

    public Quantifier(String name, MembershipFunction membershipFunction) {
        this.name = name;
        this.membershipFunction = membershipFunction;
    }

    public double compute(double x) {
        return membershipFunction.compute(x);
    }
}
