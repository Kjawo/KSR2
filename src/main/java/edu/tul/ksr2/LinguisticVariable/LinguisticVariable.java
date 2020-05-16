package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.w3c.dom.Document;

public class LinguisticVariable {

    double a;
    double b;
    double c;
    double d;
    String tag;

    public LinguisticVariable(String tag) {
        this.tag = tag;
    }

    public void loadData(ArrayList<GameEntity> gameEntities){
        ArrayList<Object> arrayList = (ArrayList<Object>) gameEntities.stream()
                                        .map(gameEntity -> gameEntity.get(tag))
                                        .collect(Collectors.toList());
//        System.out.println(arrayList);

        File file = new File("src\\main\\resources\\data\\MembershipParameters.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder;
        Document document = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        if (document != null) {
            System.out.println(document.getElementById("Duration").getTextContent());
        }

    }
}
