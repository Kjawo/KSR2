package edu.tul.ksr2.Summary;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class SummarizationObject {
    private SimpleStringProperty text;
    private SimpleDoubleProperty T1;

    public SummarizationObject(SimpleStringProperty  text, SimpleDoubleProperty t1) {
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

    @Override
    public String toString() {
        return "SummarizationObject{" +
                "text='" + text + '\'' +
                ", T1=" + T1 +
                '}';
    }
}
