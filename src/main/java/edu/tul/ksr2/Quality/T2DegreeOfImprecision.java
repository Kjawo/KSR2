package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class T2DegreeOfImprecision {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities) {

        Double multiplication = 1.0;
        for(Summarizer summarizer : summarizers) {
            multiplication *= summarizer.getFuzzySet().calculateDegreeOfFuzziness();
        }

        Double T2 = 1.0 - Math.pow(multiplication, 1.0 / summarizers.size());
        return T2;
    }
}
