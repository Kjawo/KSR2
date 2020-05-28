package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class DegreeOfQuantifierCardinality {
    public static Double computeFirstType(Quantifier quantifier, Summarizer summarizers, ArrayList<GameEntity> gameEntities) {

        return 1 - quantifier.getMembershipFunction().calculateCardinality();
    }
}