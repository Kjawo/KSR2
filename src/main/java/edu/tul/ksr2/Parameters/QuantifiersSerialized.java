package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="Root")
public class QuantifiersSerialized {

    @ElementList(name = "Quantifiers", entry = "Quantifier")
    private List<QuantifierSerialized> quantifiers;

    public List<QuantifierSerialized> getQuantifiers() {
        return quantifiers;
    }

    @Override
    public String toString() {
        return "QuantifierSerialized{" +
                "quantifier='" + quantifiers + '\'' +
                '}';
    }

    public QuantifiersSerialized(List<QuantifierSerialized> quantifiers) {
        this.quantifiers = quantifiers;
    }

    public QuantifiersSerialized() {
    }
}
