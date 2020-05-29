package edu.tul.ksr2.Summary;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class SummaryGenerator {

    public static ArrayList<SummarizationObject> generateFirstTypeSummarization(ArrayList<GameEntity> gameEntities, ArrayList<Quantifier> quantifiers, ArrayList<Summarizer> summarizers) {
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();

        for(Summarizer summarizer : summarizers) {
            summarizer.populateFuzzySet(gameEntities);
        }

        for(Summarizer summarizer : summarizers) {

            for(Quantifier quantifier : quantifiers) {
                if(quantifier.compute(summarizer.getFuzzySet().support().size(), gameEntities.size()) > 0.0) {
                    SummarizationObject summarizationObject = new SummarizationObject(quantifier, summarizer);
                    summarizationObject.calculateQualityMeasuresFirstType(gameEntities);
                    summarizationObjects.add(summarizationObject);
                }
            }
        }



        return summarizationObjects;
    }

    public static ArrayList<SummarizationObject> generateSecondTypeSummarization(ArrayList<GameEntity> gameEntities, ArrayList<Quantifier> quantifiers, Summarizer qualifier, ArrayList<Summarizer> summarizers, boolean useQuantifier) {
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();

        if(!useQuantifier) {
            for(Summarizer summarizer : summarizers) {
                summarizer.populateFuzzySet(gameEntities);
            }

            for(Quantifier quantifier : quantifiers) {
                SummarizationObject summarizationObject = new SummarizationObject(quantifier, summarizers);
                summarizationObject.calculateQualityMeasuresSecondType(gameEntities);
                summarizationObjects.add(summarizationObject);
            }
        }else {


        }


        return summarizationObjects;
    }
}
