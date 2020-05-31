package edu.tul.ksr2.Quality;

import edu.tul.ksr2.LinguisticVariable.Summarizer;

public class T11LengthOfQualifier {
    public static Double computeFirstType(Summarizer qualifier) {
        if(qualifier != null){
            return 2 * Math.pow(0.5, 1); // 1 should be qualifier.size()
        } else {
           return 0.0;
        }
    }
}
