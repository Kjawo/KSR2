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

    public double compute(double x, double totalAmount) {
        return membershipFunction.compute(x, totalAmount);
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Quantifier{" +
                "name='" + name + '\'' +
                ", membershipFunction=" + membershipFunction +
                '}';
    }

    public String generateLatexSubsection () {
        StringBuilder result = new StringBuilder();
        result.append("\\subsubsection{").append(this.name).append("}");

        result.append(membershipFunction.generateLatexEq(name));


        return result.toString();
    }
}
