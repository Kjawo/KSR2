package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

public class T9DegreeOfQualifierImprecision {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities, Summarizer qualifier) {

        Double T9 = 1.0;
        if(qualifier != null) {
            T9 *= qualifier.getFuzzySet().calculateDegreeOfFuzziness();
            T9 = 1.0 - Math.pow(T9, 1.0);
        }
        return T9;
    }
}
