package edu.tul.ksr2.Quality;

import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;

public class T7DegreeOfQuantifierCardinality {
    public static Double computeFirstType(Quantifier quantifier) {
        return 1 - quantifier.getMembershipFunction().calculateCardinality(ParametersMapping.maxValueForParameter.get("AmountOfGames"));
    }
}
