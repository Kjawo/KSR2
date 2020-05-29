package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Sets.FuzzySet;

import java.util.ArrayList;

public class T1DegreeOfTruth {
    public static Double computeFirstType(Quantifier quantifier, Summarizer summarizer, ArrayList<GameEntity> gameEntities) {
        Double T1 = quantifier.compute(summarizer.getFuzzySet().support().size(), gameEntities.size());
        return T1;
    }

    public static Double computeComplex(Quantifier quantifier, Summarizer summarizer, FuzzySet<GameEntity> summarizersComplexSet, ArrayList<GameEntity> gameEntities) {
        Double T1 = quantifier.compute(summarizersComplexSet.support().size(), gameEntities.size());
        return T1;
    }
}
