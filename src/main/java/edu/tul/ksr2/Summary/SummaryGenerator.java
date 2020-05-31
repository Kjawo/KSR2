package edu.tul.ksr2.Summary;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Sets.FuzzySet;

import java.util.ArrayList;
import java.util.Map;

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

        if(useQuantifier) {
            ArrayList<GameEntity> newGameEntities = new ArrayList<>();
            qualifier.populateFuzzySet(gameEntities);
            for (Map.Entry<GameEntity, Double> entry : qualifier.getFuzzySet().support().entrySet()) {
                if(entry.getValue() > 0.0)
                {
                    newGameEntities.add(entry.getKey());
                }
            }
            gameEntities = newGameEntities;
        }

        for(Summarizer summarizer : summarizers) {
            summarizer.populateFuzzySet(gameEntities);
        }

        for(Quantifier quantifier : quantifiers) {
            SummarizationObject summarizationObject = new SummarizationObject(quantifier, summarizers);
            if(useQuantifier) {
                summarizationObject = new SummarizationObject(qualifier, quantifier, summarizers);
            } else {
                summarizationObject = new SummarizationObject(quantifier, summarizers);
            }
            summarizationObject.calculateQualityMeasuresSecondType(gameEntities);
            summarizationObjects.add(summarizationObject);
        }



        return summarizationObjects;
    }

    public static ArrayList<SummarizationObject> generateMultiSubjectSummarization(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, ArrayList<Quantifier> quantifiers, Summarizer qualifier, ArrayList<Summarizer> summarizers, boolean useQuantifier, String subjectP1, String subjectP2) {
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP1 = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP2 = new ArrayList<>();

        Summarizer qualifierP1 = qualifier;
        Summarizer qualifierP2 = qualifier;

        ArrayList<Summarizer> summarizersP1 = new ArrayList<>();
        ArrayList<Summarizer> summarizersP2 = new ArrayList<>();

        for(Summarizer summarizer : summarizers) {
            summarizersP1.add(new Summarizer(summarizer));
            summarizersP2.add(new Summarizer(summarizer));
        }



        if(useQuantifier) {
            ArrayList<GameEntity> newGameEntitiesP1 = new ArrayList<>();
            qualifierP1.populateFuzzySet(gameEntitiesP1);

            ArrayList<GameEntity> newGameEntitiesP2 = new ArrayList<>();
            qualifierP2.populateFuzzySet(gameEntitiesP2);

            for (Map.Entry<GameEntity, Double> entry : qualifierP1.getFuzzySet().support().entrySet()) {
                if(entry.getValue() > 0.0)
                {
                    newGameEntitiesP1.add(entry.getKey());
                }
            }
            gameEntitiesP1 = newGameEntitiesP1;

            for (Map.Entry<GameEntity, Double> entry : qualifierP2.getFuzzySet().support().entrySet()) {
                if(entry.getValue() > 0.0)
                {
                    newGameEntitiesP2.add(entry.getKey());
                }
            }
            gameEntitiesP2 = newGameEntitiesP2;
        }

        for(Summarizer summarizer : summarizersP1) {
            summarizer.populateFuzzySet(gameEntitiesP1);
        }

        for(Summarizer summarizer : summarizersP2) {
            summarizer.populateFuzzySet(gameEntitiesP2);
        }

        var lol1 = summarizersP1.get(0).getFuzzySet().support();
        var lol2 = summarizersP2.get(0).getFuzzySet().support();


        for(Quantifier quantifier : quantifiers) {
            SummarizationObject summarizationObjectP1 = new SummarizationObject(quantifier, summarizersP1);
            SummarizationObject summarizationObjectP2 = new SummarizationObject(quantifier, summarizersP2);

            SummarizationObject summarizationObject = new SummarizationObject(quantifier, summarizersP2);

            if(useQuantifier) {
                summarizationObjectP1 = new SummarizationObject(qualifierP1, quantifier, summarizersP1);
                summarizationObjectP2 = new SummarizationObject(qualifierP2, quantifier, summarizersP2);

                summarizationObject = new SummarizationObject(quantifier, qualifierP1, summarizersP1, qualifierP2, summarizersP2, subjectP1, subjectP2);
                summarizationObject.calculateQualityMeasuresMultiSubjectSecondType(gameEntitiesP1, gameEntitiesP2);

            } else {
                summarizationObjectP1 = new SummarizationObject(quantifier, summarizersP1);
                summarizationObjectP2 = new SummarizationObject(quantifier, summarizersP2);

                summarizationObject = new SummarizationObject(quantifier, summarizersP1, summarizersP2, subjectP1, subjectP2);
                summarizationObject.calculateQualityMeasuresMultiSubjectFirstType(gameEntitiesP1, gameEntitiesP2);

            }
            summarizationObjects.add(summarizationObject);
        }



        return summarizationObjects;
    }

    public static ArrayList<SummarizationObject> generateMultiSubjectSummarizationThirdType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, ArrayList<Quantifier> quantifiers, Summarizer qualifier, ArrayList<Summarizer> summarizers, boolean useQuantifier, String subjectP1, String subjectP2) {
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP1 = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP2 = new ArrayList<>();

        Summarizer qualifierP1 = qualifier;
        Summarizer qualifierP2 = qualifier;

        ArrayList<Summarizer> summarizersP1 = new ArrayList<>();
        ArrayList<Summarizer> summarizersP2 = new ArrayList<>();

        for(Summarizer summarizer : summarizers) {
            summarizersP1.add(new Summarizer(summarizer));
            summarizersP2.add(new Summarizer(summarizer));
        }


        if(useQuantifier) {
            ArrayList<GameEntity> newGameEntitiesP1 = new ArrayList<>();
            qualifierP1.populateFuzzySet(gameEntitiesP1);

            ArrayList<GameEntity> newGameEntitiesP2 = new ArrayList<>();
            qualifierP2.populateFuzzySet(gameEntitiesP2);

            for (Map.Entry<GameEntity, Double> entry : qualifierP1.getFuzzySet().support().entrySet()) {
                if(entry.getValue() > 0.0)
                {
                    newGameEntitiesP1.add(entry.getKey());
                }
            }
            gameEntitiesP1 = newGameEntitiesP1;

            for (Map.Entry<GameEntity, Double> entry : qualifierP2.getFuzzySet().support().entrySet()) {
                if(entry.getValue() > 0.0)
                {
                    newGameEntitiesP2.add(entry.getKey());
                }
            }
            gameEntitiesP2 = newGameEntitiesP2;
        }

        for(Summarizer summarizer : summarizersP1) {
            summarizer.populateFuzzySet(gameEntitiesP1);
        }

        for(Summarizer summarizer : summarizersP2) {
            summarizer.populateFuzzySet(gameEntitiesP2);
        }


        for(Quantifier quantifier : quantifiers) {
            SummarizationObject summarizationObjectP1 = new SummarizationObject(quantifier, summarizersP1);
            SummarizationObject summarizationObjectP2 = new SummarizationObject(quantifier, summarizersP2);

            SummarizationObject summarizationObject = new SummarizationObject(quantifier, summarizersP2);

            summarizationObjectP1 = new SummarizationObject(qualifierP1, quantifier, summarizersP1);
            summarizationObjectP2 = new SummarizationObject(qualifierP2, quantifier, summarizersP2);

            summarizationObject = new SummarizationObject(quantifier, qualifierP2, summarizersP1, summarizersP2, subjectP1, subjectP2);

            summarizationObject.calculateQualityMeasuresMultiSubjectThirdType(gameEntitiesP1, gameEntitiesP2);
            summarizationObjects.add(summarizationObject);
        }



        return summarizationObjects;
    }

    public static ArrayList<SummarizationObject> generateMultiSubjectSummarizationFourthType(ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, ArrayList<Summarizer> summarizers, String subjectP1, String subjectP2) {
        ArrayList<SummarizationObject> summarizationObjects = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP1 = new ArrayList<>();
        ArrayList<SummarizationObject> summarizationObjectsP2 = new ArrayList<>();


        ArrayList<Summarizer> summarizersP1 = new ArrayList<>();
        ArrayList<Summarizer> summarizersP2 = new ArrayList<>();

        for(Summarizer summarizer : summarizers) {
            summarizersP1.add(new Summarizer(summarizer));
            summarizersP2.add(new Summarizer(summarizer));
        }


        for(Summarizer summarizer : summarizersP1) {
            summarizer.populateFuzzySet(gameEntitiesP1);
        }

        for(Summarizer summarizer : summarizersP2) {
            summarizer.populateFuzzySet(gameEntitiesP2);
        }

        SummarizationObject summarizationObject = new SummarizationObject(summarizersP1, summarizersP2, subjectP1, subjectP2);

        summarizationObject.calculateQualityMeasuresMultiSubjectFourthType(gameEntitiesP1, gameEntitiesP2);
        summarizationObjects.add(summarizationObject);



        return summarizationObjects;
    }
}
