package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class T4DegreeOfAppropriateness {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities, double T3) {
//        double T3 = DegreeOfCovering.computeFirstType(quantifier, summarizers, gameEntities);
        double multiplication = 1.0;

        for(Summarizer summarizer : summarizers) {
            multiplication *= summarizer.getFuzzySet().calculateDegreeOfFuzziness() / gameEntities.size();
        }

        return Math.abs(multiplication - T3);
    }
}
