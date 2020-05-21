package edu.tul.ksr2.Summary;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;

import java.util.ArrayList;
import java.util.Map;

public class SummaryGenerator {

    public static ArrayList<SummarizationObject> summarizeAmmounts(Map<String, Double> membership, String summarizerTag){
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();
        ArrayList<Quantifier> quantifiers = XMLReader.readQuantifier();
        double ammount = 0,
                totalAmount = 0,
                computedMembership,
                highestComputedMembership = 0;
        String labelName = "";

        for(String key : membership.keySet()){
            totalAmount += membership.get(key);
        }

        for(String key : membership.keySet()){
            highestComputedMembership = -1;
            ammount = membership.get(key);
            for(Quantifier quant : quantifiers) {
                computedMembership = quant.compute(ammount, totalAmount);
                if(computedMembership > highestComputedMembership){
                    highestComputedMembership = computedMembership;
                    labelName = quant.getName();
                }

                if(computedMembership > 0.0) {
                    summarizationObjects.add(new SummarizationObject(quant.getName() + " games are/have " + key + " " + summarizerTag, computedMembership));
//                    System.out.println("[" + String.format("%.2f", computedMembership) + "] " + quant.getName() + " games are/have " + key + " " + summarizerTag) ;
                }
            }
//            System.out.println(labelName + " games are/have " + key + " " + summarizerTag);
        }
        return summarizationObjects;
    }
}
