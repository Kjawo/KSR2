package edu.tul.ksr2.Summary;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class FirstTypeSummarizationObject {
    private Quantifier quantifier;
    private Summarizer summarizer;
    private SimpleStringProperty text;
    private SimpleDoubleProperty T1;

    public FirstTypeSummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t1) {
        this.text = text;
        T1 = t1;
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

    @Override
    public String toString() {
        return "SummarizationObject{" +
                "text='" + text + '\'' +
                ", T1=" + T1 +
                '}';
    }
}
