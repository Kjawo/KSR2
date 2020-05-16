package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class XMLReader {
    public static ArrayList<Qualifier> read() {
        Serializer serializer = new Persister();
        File source = new File(
                Objects.requireNonNull(XMLReader.class.getClassLoader().getResource("Quantifiers.xml")).getFile()
        );

        QuantifiersSerialized quantifiersSerialized = new QuantifiersSerialized();
        try {
            quantifiersSerialized = serializer.read(QuantifiersSerialized.class, source);
            System.out.println(quantifiersSerialized);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*TODO: create membershipfunction and quantifier object*/

        return null;
    }
}
