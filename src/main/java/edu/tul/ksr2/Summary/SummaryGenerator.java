package edu.tul.ksr2.Summary;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.Parameters.XMLReader;

import java.util.ArrayList;
import java.util.Map;

public class SummaryGenerator {

    public static void summarizeAmmounts(Map<String, Double> membership){
        ArrayList<Quantifier> quantifiers = XMLReader.readQuantifier();
        double ammount = 0;
        for(String key : membership.keySet()){
            ammount += membership.get(key);
        }
        for(String key : membership.keySet()){
            membership.put(key, membership.get(key)/ammount);
        }
        double computedMembership;
        double highestComputedMembership = 0;
        String labelName = "";
        for(String key : membership.keySet()){
            ammount = membership.get(key);
            for(Quantifier quant : quantifiers) {
                computedMembership = quant.compute(ammount);
                if(computedMembership > highestComputedMembership){
                    highestComputedMembership = computedMembership;
                    labelName = quant.getName();
                }
            }
            System.out.println(labelName + " games are " + key);
        }
    }
}
