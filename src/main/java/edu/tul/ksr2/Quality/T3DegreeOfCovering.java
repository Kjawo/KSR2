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

//
//        for (GameEntity gameEntity : gameEntities) {
//            double qualifierMembership = qualifier.getMembershipFunction().compute(gameEntity.get(qualifier.getEntityFieldName()));
//            double summarizerMembership = summarizer.getMembershipFunction().compute(gameEntity.get(summarizer.getEntityFieldName()));
//
//            if (qualifierMembership > 0) {
//                denominator += 1.0;
//                if (summarizerMembership > 0) {
//                    numerator += 1.0;
//                }
//            }
//        }


//        for (GameEntity gameEntity : gameEntities) {
//            double summarizerMembership = summarizers.get(0).getMembershipFunction().compute(gameEntity.get(summarizers.get(0).getEntityFieldName()));
//
//                if (summarizerMembership > 0) {
//
//            }
//        }

        for (Map.Entry<GameEntity, Double> entry : summarizers.get(0).getFuzzySet().getSet().entrySet()) {
            if(entry.getValue() > 0.0)
            {
                numerator += 1.0;
            }
        }

        return numerator / gameEntities.size();
    }

    public static Double computeComplex(Quantifier quantifier, ArrayList<Summarizer> summarizers, FuzzySet<GameEntity> summarizersComplexSet, ArrayList<GameEntity> gameEntities) {
        double numerator = 0.0;

//
//        for (GameEntity gameEntity : gameEntities) {
//            double qualifierMembership = qualifier.getMembershipFunction().compute(gameEntity.get(qualifier.getEntityFieldName()));
//            double summarizerMembership = summarizer.getMembershipFunction().compute(gameEntity.get(summarizer.getEntityFieldName()));
//
//            if (qualifierMembership > 0) {
//                denominator += 1.0;
//                if (summarizerMembership > 0) {
//                    numerator += 1.0;
//                }
//            }
//        }


//        for (GameEntity gameEntity : gameEntities) {
//            double summarizerMembership = summarizers.get(0).getMembershipFunction().compute(gameEntity.get(summarizers.get(0).getEntityFieldName()));
//
//                if (summarizerMembership > 0) {
//
//            }
//        }

        for (Map.Entry<GameEntity, Double> entry : summarizersComplexSet.set.entrySet()) {
            if(entry.getValue() > 0.0)
            {
                numerator += 1.0;
            }
        }

        return numerator / gameEntities.size();
    }
}
