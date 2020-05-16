package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

class LinguisticVariableSerialized {
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
}
