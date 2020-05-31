package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Sets.FuzzySet;

import java.util.ArrayList;
import java.util.Map;

public class T3DegreeOfCovering {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities) {
        double numerator = 0.0;

        for (Map.Entry<GameEntity, Double> entry : summarizers.get(0).getFuzzySet().getSet().entrySet()) {
            if(entry.getValue() > 0.0)
            {
                numerator += 1.0;
            }
        }

        return numerator / gameEntities.size();
    }

    public static Double computeComplex(Quantifier quantifier, Summarizer qualifier, ArrayList<Summarizer> summarizers, FuzzySet<GameEntity> summarizersComplexSet, ArrayList<GameEntity> gameEntities) {

        double numerator = 0.0;
        double denominator = 0.0;

        for(GameEntity gameEntity : gameEntities) {
            double qualifierMembership = 0.0;
            double summarizerMembership = 0.0;
            if( qualifier.getFuzzySet().getSet().containsKey(gameEntity) )
                qualifierMembership = qualifier.getFuzzySet().set.get(gameEntity);
            if( summarizersComplexSet.getSet().containsKey(gameEntity) )
                summarizerMembership = summarizersComplexSet.getSet().get(gameEntity);

            if (qualifierMembership > 0) {
                denominator += 1.0;
                if (summarizerMembership > 0) {
                    numerator += 1.0;
                }
            }
        }

        if(denominator == 0.0)
            return 0.0;
        return numerator / denominator;


    }

    public static Double computeComplex(Quantifier quantifier, ArrayList<Summarizer> summarizers, FuzzySet<GameEntity> summarizersComplexSet, ArrayList<GameEntity> gameEntities) {
        double numerator = 0.0;

        for (Map.Entry<GameEntity, Double> entry : summarizersComplexSet.set.entrySet()) {
            if(entry.getValue() > 0.0)
            {
                numerator += 1.0;
            }
        }

        return numerator / gameEntities.size();
    }
}

