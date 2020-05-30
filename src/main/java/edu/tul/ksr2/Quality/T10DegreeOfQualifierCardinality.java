package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class T10DegreeOfQualifierCardinality {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities, Summarizer qualifier) {

        Double T9 = 1.0;
        if(qualifier != null) {
            double maxValue = ParametersMapping.maxValueForParameter.get(ParametersMapping.ParametersMapper.get(qualifier.getEntityFieldName()));
            T9 *= qualifier.getMembershipFunction().calculateCardinality(maxValue);
            T9 = 1.0 - Math.pow(T9, 1.0);
        }
        return T9;
    }
}
