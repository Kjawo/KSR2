package edu.tul.ksr2.Quality;

import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;

public class T6DegreeOfQuantifierImprecision {

    public static Double computeFirstType(Quantifier quantifier) {
        return 1.0 - quantifier.getSupp(ParametersMapping.maxValueForParameter.get("AmountOfGames"));
    }
}
