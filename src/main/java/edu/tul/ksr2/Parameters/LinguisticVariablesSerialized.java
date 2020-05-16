package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="DataRoot")
public class LinguisticVariablesSerialized {

    @ElementList(name = "Game", entry = "GameProperty")
    private List<LinguisticVariableSerialized> linguisticVariablesSerialized;

    public List<LinguisticVariableSerialized> getLinguisticVariables() {
        return linguisticVariablesSerialized;
    }
}

