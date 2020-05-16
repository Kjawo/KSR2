package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.ArrayList;

public class LinguisticVariable {

    ArrayList<String> labels;
    ArrayList<MembershipFunction> membershipFunctions;

    public LinguisticVariable(ArrayList<String> labels, ArrayList<MembershipFunction> membershipFunctions) {
        this.labels = labels;
        this.membershipFunctions = membershipFunctions;
    }

    @Override
    public String toString() {
        return "LinguisticVariable{" +
                "labels=" + labels +
                ", membershipFunctions=" + membershipFunctions +
                '}';
    }

}
