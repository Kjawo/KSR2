package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public String getName() {
        return name;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public ArrayList<MembershipFunction> getMembershipFunctions() {
        return membershipFunctions;
    }
}
