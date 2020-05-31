package edu.tul.ksr2.Quality;

import edu.tul.ksr2.LinguisticVariable.Summarizer;

public class T9DegreeOfQualifierImprecision {
    public static Double computeFirstType(Summarizer qualifier) {

        Double T9 = 1.0;
        if(qualifier != null) {
            T9 *= qualifier.getFuzzySet().calculateDegreeOfFuzziness();
            T9 = 1.0 - Math.pow(T9, 1.0);
        }
        return T9;
    }
}
