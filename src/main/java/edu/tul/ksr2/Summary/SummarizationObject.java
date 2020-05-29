package edu.tul.ksr2.Summary;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Quality.*;
import edu.tul.ksr2.Sets.FuzzySet;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class SummarizationObject {
    private Quantifier quantifier;
    private Summarizer summarizer;
    private SimpleStringProperty text;
    private SimpleDoubleProperty T1;
    private SimpleDoubleProperty T2;
    private SimpleDoubleProperty T3;
    private SimpleDoubleProperty T4;
    private SimpleDoubleProperty T5;
    private SimpleDoubleProperty T6;
    private SimpleDoubleProperty T7;
    private SimpleDoubleProperty T8;
    private SimpleDoubleProperty T9;
    private SimpleDoubleProperty T10;
    private SimpleDoubleProperty T11;

    ArrayList<Summarizer> summarizers;
    Summarizer qualifier;
    FuzzySet<GameEntity> summarizersComplexSet;
    Boolean isComplex;

    public SummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t1) {
        this.text = text;
        T1 = t1;
    }

    public SummarizationObject(Quantifier quantifier, Summarizer summarizer) {
        this.isComplex = false;

        this.quantifier = quantifier;
        this.summarizer = summarizer;

        text = new SimpleStringProperty(quantifier.getName() + " games are/have " + summarizer.getName() + " " + summarizer.getEntityFieldName());
    }

    public SummarizationObject(Quantifier quantifier, ArrayList<Summarizer> summarizers) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;

        ArrayList<FuzzySet<GameEntity>> fuzzySets = new ArrayList<>();
        for(Summarizer s : summarizers) {
            fuzzySets.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSet = fuzzySets.get(0);
        if (firstSet.set.size() >= 2) {
            for (int i = 1; i < fuzzySets.size(); i++) {
                firstSet = FuzzySet.intersect(firstSet, fuzzySets.get(i));
            }
        }
        summarizersComplexSet = firstSet;


        this.isComplex = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizers.size(); i++) {
            summarizersAND.append(summarizers.get(i).getTableValue());
            if(i != summarizers.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty(quantifier.getName() + " games are/have " + summarizersAND);
    }

    public SummarizationObject(Quantifier quantifier, Summarizer summarizer, SimpleStringProperty text, SimpleDoubleProperty t1) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        this.text = text;
        T1 = t1;
    }

    public SummarizationObject(String  text, double t1) {
        this.text = new SimpleStringProperty(text);
        T1 = new SimpleDoubleProperty(t1);
    }

    public String getText() {
        return text.get();
    }

    public double getT1() {
        return T1.get();
    }

    public double getT2() {
        return T2.get();
    }

    public double getT3() {
        return T3.get();
    }

    public double getT4() {
        return T4.get();
    }

    public double getT5() {
        return T5.get();
    }

    public SimpleDoubleProperty t4Property() {
        return T4;
    }

    public SimpleDoubleProperty t5Property() {
        return T5;
    }

    public double getT6() {
        return T6.get();
    }

    public SimpleDoubleProperty t6Property() {
        return T6;
    }

    public double getT7() {
        return T7.get();
    }

    public SimpleDoubleProperty t7Property() {
        return T7;
    }

    public double getT8() {
        return T8.get();
    }

    public SimpleDoubleProperty t8Property() {
        return T8;
    }

    public double getT9() {
        return T9.get();
    }

    public SimpleDoubleProperty t9Property() {
        return T9;
    }

    public double getT10() {
        return T10.get();
    }

    public SimpleDoubleProperty t10Property() {
        return T10;
    }

    public double getT11() {
        return T11.get();
    }

    public SimpleDoubleProperty t11Property() {
        return T11;
    }

    public SimpleDoubleProperty t3Property() {
        return T3;
    }

    public SimpleDoubleProperty t2Property() {
        return T2;
    }

    @Override
    public String toString() {
        return "SummarizationObject{" +
                "text='" + text + '\'' +
                ", T1=" + T1 +
                '}';
    }

    public void calculateQualityMeasuresFirstType(ArrayList<GameEntity> gameEntities) {
        ArrayList<Summarizer> summarizers = new ArrayList<>();
        summarizers.add(summarizer);

        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeFirstType(this.quantifier, this.summarizer, gameEntities));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, summarizers, gameEntities, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier, this.summarizer, gameEntities));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier, this.summarizer, gameEntities));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T9 = new SimpleDoubleProperty(0.0);
        this.T10 = new SimpleDoubleProperty(0.0);
        this.T11 = new SimpleDoubleProperty(0.0);
    }

    public void calculateQualityMeasuresSecondType(ArrayList<GameEntity> gameEntities) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeComplex(this.quantifier, this.summarizer, this.summarizersComplexSet, gameEntities));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, summarizers, this.summarizersComplexSet, gameEntities));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, summarizers, gameEntities, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T6 = new SimpleDoubleProperty(0.0);
        this.T7 = new SimpleDoubleProperty(0.0);
        this.T8 = new SimpleDoubleProperty(0.0);
        this.T9 = new SimpleDoubleProperty(0.0);
        this.T10 = new SimpleDoubleProperty(0.0);
        this.T11 = new SimpleDoubleProperty(0.0);
    }
}
