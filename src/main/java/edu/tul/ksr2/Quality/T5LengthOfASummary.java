package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;
import java.util.Map;

public class T5LengthOfASummary {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities) {
        return 2.0 * Math.pow(0.5, summarizers.size());
    }
}
