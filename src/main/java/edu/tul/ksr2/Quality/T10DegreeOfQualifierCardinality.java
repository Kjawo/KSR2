package edu.tul.ksr2.Quality;

import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

public class T10DegreeOfQualifierCardinality {
    public static Double computeFirstType(Summarizer qualifier) {

        Double T10 = 1.0;
        if(qualifier != null) {
            double maxValue = ParametersMapping.maxValueForParameter.get(ParametersMapping.ParametersMapper.get(qualifier.getEntityFieldName()));
            T10 *= qualifier.getMembershipFunction().calculateCardinality(maxValue);
            T10 = 1.0 - Math.pow(T10, 1.0);
        }
        return T10;
    }
}
