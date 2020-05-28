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

    public ArrayList<Summarizer> getSummarizers(String entityFieldName) {
        ArrayList<Summarizer> summarizers = new ArrayList<>();
        for(int i = 0; i < this.labels.size(); i++) {
            summarizers.add(new Summarizer(this.labels.get(i), entityFieldName, this.membershipFunctions.get(i)));
        }
        return summarizers;
    }


    public String generateLatexSubsection () {


        StringBuilder result = new StringBuilder();
        result.append("\\subsubsection{").append(this.name).append("}");
        for(int i = 0; i < labels.size(); i++) {
            result.append(membershipFunctions.get(i).generateLatexEq(labels.get(i)));
        }


        return result.toString();
    }

}
