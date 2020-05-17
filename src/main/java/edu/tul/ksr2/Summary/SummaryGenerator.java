package edu.tul.ksr2.Summary;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;

import java.util.ArrayList;
import java.util.Map;

public class SummaryGenerator {

    public static void summarizeAmmounts(Map<String, Double> membership, String qualifierTag){
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
            }
            System.out.println(labelName + " games are/have " + key + " " + qualifierTag);
        }
    }
}
