package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;

import java.util.ArrayList;

public class T8DegreeOfSummarizerCardinality {
    public static Double computeFirstType(Quantifier quantifier, ArrayList<Summarizer> summarizers, ArrayList<GameEntity> gameEntities) {
        Double T8 = 1.0;
        for(Summarizer summarizer : summarizers){
            double maxValue = ParametersMapping.maxValueForParameter.get(ParametersMapping.ParametersMapper.get(summarizer.getEntityFieldName()));
            T8 *= summarizer.getMembershipFunction().calculateCardinality(maxValue);
        }
        T8 = 1.0 - Math.pow(T8, 1.0 / summarizers.size());
        return T8;
    }
}
