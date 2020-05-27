package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class DegreeOfCovering {
    public static Double computeFirstType(Quantifier quantifier, Summarizer summarizer, ArrayList<GameEntity> gameEntities) {
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
        for (GameEntity gameEntity : gameEntities) {
            double summarizerMembership = summarizer.getMembershipFunction().compute(gameEntity.get(summarizer.getEntityFieldName()));

                if (summarizerMembership > 0) {
                    numerator += 1.0;
            }
        }

        return numerator / gameEntities.size();
    }
}
