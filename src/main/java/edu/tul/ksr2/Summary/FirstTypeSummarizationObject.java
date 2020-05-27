package edu.tul.ksr2.Summary;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Quality.DegreeOfImprecision;
import edu.tul.ksr2.Quality.DegreeOfTruth;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class FirstTypeSummarizationObject {
    private Quantifier quantifier;
    private Summarizer summarizer;
    private SimpleStringProperty text;
    private SimpleDoubleProperty T1;
    private SimpleDoubleProperty T2;

    public FirstTypeSummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t1) {
        this.text = text;
        T1 = t1;
    }

    public FirstTypeSummarizationObject(Quantifier quantifier, Summarizer summarizer) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;

        text = new SimpleStringProperty(quantifier.getName() + " games are/have " + summarizer.getName() + " " + summarizer.getEntityFieldName());
    }

    public FirstTypeSummarizationObject(Quantifier quantifier, Summarizer summarizer, SimpleStringProperty text, SimpleDoubleProperty t1) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        this.text = text;
        T1 = t1;
    }

    public FirstTypeSummarizationObject(String  text, double t1) {
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

    public void calculateQualityMeasures(ArrayList<GameEntity> gameEntities) {
        ArrayList<Summarizer> summarizers = new ArrayList<>();
        summarizers.add(summarizer);

        this.T1 = new SimpleDoubleProperty(DegreeOfTruth.computeFirstType(this.quantifier, this.summarizer, gameEntities));
        this.T2 = new SimpleDoubleProperty(DegreeOfImprecision.computeFirstType(this.quantifier, summarizers, gameEntities));

    }
}
