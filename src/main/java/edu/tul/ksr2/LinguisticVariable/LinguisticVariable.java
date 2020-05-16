package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.ArrayList;

public class LinguisticVariable {

    private String name;
    private ArrayList<String> labels;
    private ArrayList<MembershipFunction> membershipFunctions;

    public LinguisticVariable(String name, ArrayList<String> labels, ArrayList<MembershipFunction> membershipFunctions) {
        this.name = name;
        this.labels = labels;
        this.membershipFunctions = membershipFunctions;
    }

    @Override
    public String toString() {
        return "LinguisticVariable{" +
                "name='" + name + '\'' +
                ", labels=" + labels +
                ", membershipFunctions=" + membershipFunctions +
                '}';
    }
}
