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
    private SimpleDoubleProperty T;
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
    ArrayList<Summarizer> summarizersP1;
    ArrayList<Summarizer> summarizersP2;
    Summarizer qualifierP1;
    Summarizer qualifierP2;
    Summarizer qualifier;
    FuzzySet<GameEntity> summarizersComplexSet;
    FuzzySet<GameEntity> summarizersComplexSetP1;
    FuzzySet<GameEntity> summarizersComplexSetP2;
    Boolean isComplex;
    Boolean useQualifier;

    Boolean isMultiSubject = false;

    public SummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t1) {
        this.text = text;
        T1 = t1;
    }

    public SummarizationObject(Quantifier quantifier, Summarizer summarizer) {
        this.isComplex = false;

        this.quantifier = quantifier;
        this.summarizer = summarizer;

        this.useQualifier = false;

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
        this.useQualifier = false;

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

    public SummarizationObject(Summarizer qualifier, Quantifier quantifier, ArrayList<Summarizer> summarizers) {
        this.qualifier = qualifier;
        this.quantifier = quantifier;
        this.summarizers = summarizers;

        this.useQualifier = false;

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
        this.useQualifier = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizers.size(); i++) {
            summarizersAND.append(summarizers.get(i).getTableValue());
            if(i != summarizers.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty(quantifier.getName() + " games which are/have " + qualifier.getTableValue() + ", are/have " + summarizersAND);
    }

    public SummarizationObject(Quantifier quantifier, ArrayList<Summarizer> summarizersP1, ArrayList<Summarizer> summarizersP2, String subjectP1, String subjectP2) {
        //Multi subject First type
        this.quantifier = quantifier;
        this.summarizersP1 = summarizersP1;
        this.summarizersP2 = summarizersP2;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP1 = new ArrayList<>();
        for(Summarizer s : summarizersP1) {
            fuzzySetsP1.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP1 = fuzzySetsP1.get(0);
        if (firstSetP1.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP1.size(); i++) {
                firstSetP1 = FuzzySet.intersect(firstSetP1, fuzzySetsP1.get(i));
            }
        }
        summarizersComplexSetP1 = firstSetP1;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP2 = new ArrayList<>();
        for(Summarizer s : summarizersP2) {
            fuzzySetsP2.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP2 = fuzzySetsP2.get(0);
        if (firstSetP2.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP2.size(); i++) {
                firstSetP2 = FuzzySet.intersect(firstSetP2, fuzzySetsP2.get(i));
            }
        }
        summarizersComplexSetP2 = firstSetP2;

        this.isComplex = true;
        this.useQualifier = false;
        this.isMultiSubject = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizersP1.size(); i++) {
            summarizersAND.append(summarizersP1.get(i).getTableValue());
            if(i != summarizersP1.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty(quantifier.getName() + " games " + subjectP1 + " compared to games " + subjectP2 + ", are/have " + summarizersAND);
    }

    public SummarizationObject(Quantifier quantifier, Summarizer qualifierP1, ArrayList<Summarizer> summarizersP1, Summarizer qualifierP2, ArrayList<Summarizer> summarizersP2, String subjectP1, String subjectP2) {
        //Multi subject second and third type

        this.quantifier = quantifier;
        this.summarizersP1 = summarizersP1;
        this.summarizersP2 = summarizersP2;

        this.qualifierP1 = qualifierP1;
        this.qualifierP2 = qualifierP2;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP1 = new ArrayList<>();
        for(Summarizer s : summarizersP1) {
            fuzzySetsP1.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP1 = fuzzySetsP1.get(0);
        if (firstSetP1.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP1.size(); i++) {
                firstSetP1 = FuzzySet.intersect(firstSetP1, fuzzySetsP1.get(i));
            }
        }
        summarizersComplexSetP1 = firstSetP1;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP2 = new ArrayList<>();
        for(Summarizer s : summarizersP2) {
            fuzzySetsP2.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP2 = fuzzySetsP2.get(0);
        if (firstSetP2.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP2.size(); i++) {
                firstSetP2 = FuzzySet.intersect(firstSetP2, fuzzySetsP2.get(i));
            }
        }
        summarizersComplexSetP2 = firstSetP2;

        this.isComplex = true;
        this.useQualifier = true;
        this.isMultiSubject = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizersP1.size(); i++) {
            summarizersAND.append(summarizersP1.get(i).getTableValue());
            if(i != summarizersP1.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty(quantifier.getName() + " games " + subjectP1 + " compared to games " + subjectP2 + " which are/have " + qualifierP1.getTableValue() + ", are/have " + summarizersAND);
    }

    public SummarizationObject(Quantifier quantifier, Summarizer qualifierP1, ArrayList<Summarizer> summarizersP1, ArrayList<Summarizer> summarizersP2, String subjectP1, String subjectP2) {
        this.quantifier = quantifier;
        this.summarizersP1 = summarizersP1;
        this.summarizersP2 = summarizersP2;

        this.qualifierP1 = qualifierP1;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP1 = new ArrayList<>();
        for(Summarizer s : summarizersP1) {
            fuzzySetsP1.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP1 = fuzzySetsP1.get(0);
        if (firstSetP1.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP1.size(); i++) {
                firstSetP1 = FuzzySet.intersect(firstSetP1, fuzzySetsP1.get(i));
            }
        }
        summarizersComplexSetP1 = firstSetP1;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP2 = new ArrayList<>();
        for(Summarizer s : summarizersP2) {
            fuzzySetsP2.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP2 = fuzzySetsP2.get(0);
        if (firstSetP2.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP2.size(); i++) {
                firstSetP2 = FuzzySet.intersect(firstSetP2, fuzzySetsP2.get(i));
            }
        }
        summarizersComplexSetP2 = firstSetP2;

        this.isComplex = true;
        this.useQualifier = true;
        this.isMultiSubject = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizersP1.size(); i++) {
            summarizersAND.append(summarizersP1.get(i).getTableValue());
            if(i != summarizersP1.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty(quantifier.getName() + " games " + subjectP1 + " which are/have " + qualifierP1.getTableValue() + " compared to games " + subjectP2 +  ", are/have " + summarizersAND);

    }

    public SummarizationObject(ArrayList<Summarizer> summarizersP1, ArrayList<Summarizer> summarizersP2, String subjectP1, String subjectP2) {
        this.summarizersP1 = summarizersP1;
        this.summarizersP2 = summarizersP2;


        ArrayList<FuzzySet<GameEntity>> fuzzySetsP1 = new ArrayList<>();
        for(Summarizer s : summarizersP1) {
            fuzzySetsP1.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP1 = fuzzySetsP1.get(0);
        if (firstSetP1.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP1.size(); i++) {
                firstSetP1 = FuzzySet.intersect(firstSetP1, fuzzySetsP1.get(i));
            }
        }
        summarizersComplexSetP1 = firstSetP1;

        ArrayList<FuzzySet<GameEntity>> fuzzySetsP2 = new ArrayList<>();
        for(Summarizer s : summarizersP2) {
            fuzzySetsP2.add(s.getFuzzySet());
        }
        FuzzySet<GameEntity> firstSetP2 = fuzzySetsP2.get(0);
        if (firstSetP2.set.size() >= 2) {
            for (int i = 1; i < fuzzySetsP2.size(); i++) {
                firstSetP2 = FuzzySet.intersect(firstSetP2, fuzzySetsP2.get(i));
            }
        }
        summarizersComplexSetP2 = firstSetP2;

        this.isComplex = true;
        this.useQualifier = true;
        this.isMultiSubject = true;

        StringBuilder summarizersAND = new StringBuilder();
        for(int i = 0; i < summarizersP1.size(); i++) {
            summarizersAND.append(summarizersP1.get(i).getTableValue());
            if(i != summarizersP1.size() - 1) {
                summarizersAND.append(" and ");
            }
        }
        text = new SimpleStringProperty("There are more games " + subjectP1 + " then games " + subjectP2 +  ", which are/have " + summarizersAND);

    }

    public double getT() {
        return T.get();
    }

    public SimpleDoubleProperty tProperty() {
        return T;
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
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(summarizers));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        calculateOptimalQualityMeasure();

    }

    public void calculateQualityMeasuresSecondType(ArrayList<GameEntity> gameEntities) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeComplex(this.quantifier, this.summarizer, this.summarizersComplexSet, gameEntities));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, summarizers, gameEntities));
        if(this.useQualifier) {
                this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, this.qualifier, summarizers, this.summarizersComplexSet, gameEntities));
        } else {
            this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, summarizers, this.summarizersComplexSet, gameEntities));
        }
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, summarizers, gameEntities, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, summarizers, gameEntities));
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(summarizers));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        calculateOptimalQualityMeasure();
    }

    public void calculateQualityMeasuresMultiSubjectFirstType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeMultipleTypeOne(this.quantifier, this.summarizersP1, gameEntitiesP1, gameEntitiesP2, this.summarizersComplexSetP1, this.summarizersComplexSetP2));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, this.summarizersP1, this.summarizersComplexSetP1, gameEntitiesP1));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(this.summarizersP1));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        this.useQualifier = false;
        calculateOptimalQualityMeasure();
    }

    public void calculateQualityMeasuresMultiSubjectSecondType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeMultipleTypeTwo(this.quantifier, this.qualifierP2, this.summarizersP1, gameEntitiesP1, gameEntitiesP2, this.summarizersComplexSetP1, this.summarizersComplexSetP2));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, this.summarizersP1, this.summarizersComplexSetP1, gameEntitiesP1));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(this.summarizersP1));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        this.useQualifier = false;
        calculateOptimalQualityMeasure();
    }

    public void calculateQualityMeasuresMultiSubjectThirdType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeMultipleTypeThree(this.quantifier, this.qualifierP1, this.summarizersP1, gameEntitiesP1, gameEntitiesP2, this.summarizersComplexSetP1, this.summarizersComplexSetP2));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, this.qualifierP1, this.summarizersP1, this.summarizersComplexSetP1, gameEntitiesP1));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T6 = new SimpleDoubleProperty(T6DegreeOfQuantifierImprecision.computeFirstType(this.quantifier));
        this.T7 = new SimpleDoubleProperty(T7DegreeOfQuantifierCardinality.computeFirstType(this.quantifier));
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(this.summarizersP1));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        this.useQualifier = true;
        calculateOptimalQualityMeasure();
    }

    public void calculateQualityMeasuresMultiSubjectFourthType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2) {
        this.T1 = new SimpleDoubleProperty(T1DegreeOfTruth.computeMultipleTypeFour(this.summarizersComplexSetP1, this.summarizersComplexSetP2));
        this.T2 = new SimpleDoubleProperty(T2DegreeOfImprecision.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T3 = new SimpleDoubleProperty(T3DegreeOfCovering.computeComplex(this.quantifier, this.summarizersP1, this.summarizersComplexSetP1, gameEntitiesP1));
        this.T4 = new SimpleDoubleProperty(T4DegreeOfAppropriateness.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1, this.T3.get()));
        this.T5 = new SimpleDoubleProperty(T5LengthOfASummary.computeFirstType(this.quantifier, this.summarizersP1, gameEntitiesP1));
        this.T6 = new SimpleDoubleProperty(0.0);
        this.T7 = new SimpleDoubleProperty(0.0);
        this.T8 = new SimpleDoubleProperty(T8DegreeOfSummarizerCardinality.computeFirstType(this.summarizersP1));
        this.T9 = new SimpleDoubleProperty(T9DegreeOfQualifierImprecision.computeFirstType(this.qualifier));
        this.T10 = new SimpleDoubleProperty(T10DegreeOfQualifierCardinality.computeFirstType(this.qualifier));
        this.T11 = new SimpleDoubleProperty(T11LengthOfQualifier.computeFirstType(this.qualifier));

        this.useQualifier = false;
        calculateOptimalQualityMeasure();
}

    private void calculateOptimalQualityMeasure() {
        ArrayList<Double> qualityMeasuresWeighted = new ArrayList<>();

//        if(this.useQualifier) {
            qualityMeasuresWeighted.add(this.T1.getValue() * 0.75);
            qualityMeasuresWeighted.add(this.T2.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T3.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T4.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T5.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T6.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T7.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T8.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T9.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T10.getValue() * 0.025);
            qualityMeasuresWeighted.add(this.T11.getValue() * 0.025);
//        } else {
//            qualityMeasuresWeighted.add(this.T1.getValue() * 0.75);
//            qualityMeasuresWeighted.add(this.T2.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T3.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T4.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T5.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T6.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T7.getValue() * 0.25 / 7);
//            qualityMeasuresWeighted.add(this.T8.getValue() * 0.25 / 7);
//        }

        this.T = new SimpleDoubleProperty(qualityMeasuresWeighted.stream().mapToDouble(n -> n).sum());
    }


}
