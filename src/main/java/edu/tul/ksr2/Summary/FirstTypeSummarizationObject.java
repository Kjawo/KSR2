package edu.tul.ksr2.Summary;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class FirstTypeSummarizationObject {
    private Quantifier quantifier;
    private Summarizer summarizer;
    private SimpleStringProperty text;
    private SimpleDoubleProperty T;

    public FirstTypeSummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t) {
        this.text = text;
        T = t;
    }

    public FirstTypeSummarizationObject(Quantifier quantifier, Summarizer summarizer, Double t) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        T = new SimpleDoubleProperty(t);

        text = new SimpleStringProperty(quantifier.getName() + " games are/have " + summarizer.getName() + " " + summarizer.getEntityFieldName());
    }

    public FirstTypeSummarizationObject(Quantifier quantifier, Summarizer summarizer, SimpleStringProperty text, SimpleDoubleProperty t) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        this.text = text;
        T = t;
    }

    public FirstTypeSummarizationObject(String  text, double t) {
        this.text = new SimpleStringProperty(text);
        T = new SimpleDoubleProperty(t);
    }

    public String getText() {
        return text.get();
    }

    public double getT() {
        return T.get();
    }

    @Override
    public String toString() {
        return "SummarizationObject{" +
                "text='" + text + '\'' +
                ", T1=" + T +
                '}';
    }
}
