package edu.tul.ksr2.Parameters;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import edu.tul.ksr2.LinguisticVariable.Quantifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class XMLReader {
    public static ArrayList<Quantifier> read(String filename, boolean gameProperties) {
        ArrayList<Quantifier> quantifiers = new ArrayList<>();

        Serializer serializer = new Persister();
        File source = new File(
                Objects.requireNonNull(XMLReader.class.getClassLoader().getResource(filename)).getFile()
        );
        QuantifiersSerializedInterface quantifiersSerialized = null;

        try {
            if(gameProperties) {
                quantifiersSerialized = new GameQuantifiersSerialized();
                quantifiersSerialized = serializer.read(GameQuantifiersSerialized.class, source);
            } else {
                quantifiersSerialized = new QuantifiersSerialized();
                quantifiersSerialized = serializer.read(QuantifiersSerialized.class, source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (var q: quantifiersSerialized.getQuantifiers()
             ) {
            quantifiers.add(new Quantifier(q.getName(), q.getMembershipFunction()));
        }

        return quantifiers;
    }
}
