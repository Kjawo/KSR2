package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Sets.FuzzySet;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Summarizer {

    public String name;
    private String entityFieldName;
    private MembershipFunction membershipFunction;
    private FuzzySet<GameEntity> fuzzySet;

    private SimpleStringProperty tableValue;

    public Summarizer(String name, String entityFieldName, MembershipFunction membershipFunction) {
        this.name = name;
        this.entityFieldName = entityFieldName;
        this.membershipFunction = membershipFunction;

        this.tableValue = new SimpleStringProperty(this.name + " " + this.entityFieldName);
    }

    public Summarizer(String name, MembershipFunction membershipFunction, FuzzySet<GameEntity> fuzzySet) {
        this.name = name;
        this.membershipFunction = membershipFunction;
        this.fuzzySet = fuzzySet;
    }

    public Summarizer(String name) {
        this.name = name;
    }

    public Summarizer(String name, MembershipFunction membershipFunction) {
        this.name = name;
        this.membershipFunction = membershipFunction;
    }

    public void populateFuzzySet(ArrayList<GameEntity> gameEntity) {
        FuzzySet<GameEntity> newFuzzySet = new FuzzySet<>();
        double membership = 0;
        for (GameEntity g : gameEntity) {
            membership = membershipFunction.compute(g.get(this.entityFieldName));

            newFuzzySet.add(g, membership);
        }

        this.fuzzySet = newFuzzySet;
    }

    public String getName() {
        return name;
    }

    public String getEntityFieldName() {
        return entityFieldName;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public FuzzySet<GameEntity> getFuzzySet() {
        return fuzzySet;
    }

    public Double getSetSize() {
        return Double.valueOf(fuzzySet.set.size());
    }

    public String getTableValue() {
        return tableValue.get();
    }

    public SimpleStringProperty tableValueProperty() {
        return tableValue;
    }

    @Override
    public String toString() {
        return name;
    }
}
