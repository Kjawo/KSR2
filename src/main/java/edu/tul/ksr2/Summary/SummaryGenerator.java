package edu.tul.ksr2.Summary;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Parameters.XMLReader;
import edu.tul.ksr2.Sets.FuzzySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SummaryGenerator {

    public static ArrayList<FirstTypeSummarizationObject> generateFirstTypeSummarization(ArrayList<GameEntity> gameEntities, ArrayList<Quantifier> quantifiers, ArrayList<Summarizer> summarizers) {
        ArrayList<FirstTypeSummarizationObject> firstTypeSummarizationObjects = new ArrayList<>();

        for(Summarizer summarizer : summarizers) {
            summarizer.populateFuzzySet(gameEntities);
        }

        for(Summarizer summarizer : summarizers) {

            for(Quantifier quantifier : quantifiers) {
                if(quantifier.compute(summarizer.getFuzzySet().support().size(), gameEntities.size()) > 0.0) {
                    FirstTypeSummarizationObject firstTypeSummarizationObject = new FirstTypeSummarizationObject(quantifier, summarizer);
                    firstTypeSummarizationObject.calculateQualityMeasures(gameEntities);
                    firstTypeSummarizationObjects.add(firstTypeSummarizationObject);
                }
            }
        }



        return firstTypeSummarizationObjects;
    }

//    public static ArrayList<FirstTypeSummarizationObject> summarizeAmmounts(String summarizerName, ArrayList<Quantifier> quantifiers, ArrayList<GameEntity> gameEntities) {
//        Map<String, Double> membership = getSummarizersEntityCount(summarizerName, gameEntities);
//
//        ArrayList<FirstTypeSummarizationObject> firstTypeSummarizationObjects = new ArrayList<>();
//        double ammount = 0,
//                totalAmount = 0,
//                computedMembership,
//                highestComputedMembership = 0;
//        String labelName = "";
//
//        for (String key : membership.keySet()) {
//            totalAmount += membership.get(key);
//        }
//
//        for (String key : membership.keySet()) {
//            highestComputedMembership = -1;
//            ammount = membership.get(key);
//            for (Quantifier quant : quantifiers) {
//                computedMembership = quant.compute(ammount, totalAmount);
//                if (computedMembership > highestComputedMembership) {
//                    highestComputedMembership = computedMembership;
//                    labelName = quant.getName();
//                }
//
//                ArrayList<Double> qualityMeasures = computeQualityMeasures();
//                firstTypeSummarizationObjects.add(new FirstTypeSummarizationObject(quant.getName() + " games are/have " + key + " " + summarizerName, computedMembership));
////                    firstTypeSummarizationObjects.add(new FirstTypeSummarizationObject(quant, quant.getName() + " games are/have " + key + " " + summarizerName, computedMembership));
//            }
////            System.out.println(labelName + " games are/have " + key + " " + summarizerTag);
//        }
//        return firstTypeSummarizationObjects;
//    }
//
//    private static Map<String, Double> getSummarizersEntityCount(String summarizerName, ArrayList<GameEntity> gameEntities) {
//        ArrayList<Object> gameData = (ArrayList<Object>) gameEntities.stream()
//                .map(gameEntity -> gameEntity.get(summarizerName))
//                .collect(Collectors.toList());
////        System.out.println(gameData);
//
//        ArrayList<LinguisticVariable> linguisticVariables = XMLReader.readLinguisicVariables();
//        LinguisticVariable rightLingVar = null;
//        for (LinguisticVariable LV : linguisticVariables) {
//            if (LV.getName().equals(ParametersMapping.ParametersMapper.get(summarizerName))) {
//                rightLingVar = LV;
//                break;
//            }
//        }
//        double computedMembership,
//                highestFoundMembership = 0;
//        int indx = 0;
//        String labelName = "";
//        Map<String, Double> membership = new HashMap<>();
//
//        Double entityCount = 0.0;
//
//        for (Object obj : gameData) {
//            labelName = rightLingVar.getLabels().get(indx);
//            for (MembershipFunction fun : rightLingVar.getMembershipFunctions()) {
//                computedMembership = fun.compute(((double) (Integer) obj));
//                if (computedMembership > highestFoundMembership) {
//                    highestFoundMembership = computedMembership;
//                    labelName = rightLingVar.getLabels().get(indx);
//                }
//                indx++;
//            }
//            membership.merge(labelName, (double) 1, Double::sum);
//            highestFoundMembership = 0;
//            indx = 0;
//        }
////        System.out.println(tag + " " + membership);
////        System.out.println("\\subsection{" + tag + "}");
//        return membership;
//    }

    private static ArrayList<Double> computeQualityMeasures() {
        ArrayList<Double> qualityMeasures = new ArrayList<>();

//        qualityMeasures.add(DegreeOfTruth.compute());

        return qualityMeasures;
    }
}
