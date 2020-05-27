package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class DegreeOfTruth {
    public static Double compute(Quantifier quantifier, Summarizer summarizer, ArrayList<GameEntity> gameEntities) {
        Double T1 = quantifier.compute(summarizer.getSetSize(), gameEntities.size());
        return T1;
    }
}
