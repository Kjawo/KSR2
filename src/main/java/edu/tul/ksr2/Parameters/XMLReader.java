package edu.tul.ksr2.Parameters;

import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import edu.tul.ksr2.LinguisticVariable.Quantifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class XMLReader {
    public static ArrayList<Quantifier> readQuantifier() {
        ArrayList<Quantifier> quantifiers = new ArrayList<>();

        Serializer serializer = new Persister();
        File source = new File(
                Objects.requireNonNull(XMLReader.class.getClassLoader().getResource("Quantifiers.xml")).getFile()
        );

        QuantifiersSerialized quantifiersSerialized = new QuantifiersSerialized();
        try {
            quantifiersSerialized = serializer.read(QuantifiersSerialized.class, source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (var q: quantifiersSerialized.getQuantifiers()
        ) {
            quantifiers.add(new Quantifier(q.getName(), q.getMembershipFunction()));
        }

        return quantifiers;
    }

    public static void saveQuantifiers(QuantifiersSerialized quantifiersSerialized) {
        Serializer serializer = new Persister();
        File result = new File(Objects.requireNonNull(XMLReader.class.getClassLoader().getResource("Quantifiers.xml")).getFile());

        try {
            serializer.write(quantifiersSerialized, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LinguisticVariable> readLinguisicVariables() {
        ArrayList<LinguisticVariable> linguisticVariables = new ArrayList<>();

        Serializer serializer = new Persister();
        File source = new File(
                Objects.requireNonNull(XMLReader.class.getClassLoader().getResource("MembershipParameters.xml")).getFile()
        );

        LinguisticVariablesSerialized linguisticVariablesSerialized = new LinguisticVariablesSerialized();
        try {
            linguisticVariablesSerialized = serializer.read(LinguisticVariablesSerialized.class, source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (var l: linguisticVariablesSerialized.getLinguisticVariables()
        ) {
            ArrayList<String> labels = new ArrayList<>();
            ArrayList<MembershipFunction> membershipFunctions = new ArrayList<>();

            for (var inside: l.getLinguisticVarLabelsSerialized()
                 ) {
                labels.add(inside.getLabel());
                membershipFunctions.add(inside.getMembershipFunction());
            }

            linguisticVariables.add(new LinguisticVariable(l.getName(), labels, membershipFunctions));
        }

        return linguisticVariables;
    }
}