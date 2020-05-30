package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class T11LengthOfQualifier {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities, Summarizer qualifier) {
        return 2 * Math.pow(0.5, 1); // 1 should be qualifier.size()
    }
}
