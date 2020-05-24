package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class LinguisticVariableSerialized {
    @Element(name="Name")
    private String name;

    @ElementList(name = "Properties", entry = "PropertyTreeItem")
    private List<LinguisticVarLabelSerialized> linguisticVarLabelsSerialized;

    public String getName() {
        return name;
    }

    public List<LinguisticVarLabelSerialized> getLinguisticVarLabelsSerialized() {
        return linguisticVarLabelsSerialized;
    }

    public LinguisticVariableSerialized(String name, List<LinguisticVarLabelSerialized> linguisticVarLabelsSerialized) {
        this.name = name;
        this.linguisticVarLabelsSerialized = linguisticVarLabelsSerialized;
    }

    public LinguisticVariableSerialized() {
    }
}
