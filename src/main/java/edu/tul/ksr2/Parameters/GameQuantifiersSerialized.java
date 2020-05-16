package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="DataRoot")
public class GameQuantifiersSerialized implements QuantifiersSerializedInterface {

    @Path("GameProperty")
    @Element(name="Name")
    private String propertyName;

    @ElementList(inline = true, required = false)
    private List<QuantifierSerialized> quantifiers;

    public List<QuantifierSerialized> getQuantifiers() {
        return quantifiers;
    }

    public String getName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return "QuantifierSerialized{" +
                "quantifier='" + quantifiers + '\'' +
                '}';
    }
}

