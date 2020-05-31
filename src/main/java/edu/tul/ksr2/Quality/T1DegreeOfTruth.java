package edu.tul.ksr2.Quality;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.LinguisticVariable.ParametersMapping;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.LinguisticVariable.Summarizer;
import edu.tul.ksr2.Sets.FuzzySet;

import java.util.ArrayList;

public class T1DegreeOfTruth {
    public static Double computeFirstType(Quantifier quantifier, Summarizer summarizer, ArrayList<GameEntity> gameEntities) {
        Double T1 = quantifier.compute(summarizer.getFuzzySet().support().size(), gameEntities.size());
        return T1;
    }

    public static Double computeComplex(Quantifier quantifier, Summarizer summarizer, FuzzySet<GameEntity> summarizersComplexSet, ArrayList<GameEntity> gameEntities) {
        Double T1 = quantifier.compute(summarizersComplexSet.support().size(), gameEntities.size());
        return T1;
    }

    public static Double computeMultipleTypeOne(Quantifier quantifier, ArrayList<Summarizer> summarizer, ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, FuzzySet<GameEntity> summarizersComplexSetP1, FuzzySet<GameEntity> summarizersComplexSetP2) {

        Double M1SP1 = (double) summarizersComplexSetP1.support().size()/gameEntitiesP1.size();
        Double M2SP2 = (double) summarizersComplexSetP2.support().size()/gameEntitiesP2.size();
        double res = M1SP1/(M1SP1 + M2SP2);
        if(quantifier.getMembershipFunction().isRelative()){
            return quantifier.compute(res);
        } else {
            return quantifier.compute(res * ParametersMapping.maxValueForParameter.get("AmountOfGames"));
        }
    }

    public static Double computeMultipleTypeTwo(Quantifier quantifier, Summarizer qualifierP2, ArrayList<Summarizer> summarizer, ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, FuzzySet<GameEntity> summarizersComplexSetP1, FuzzySet<GameEntity> summarizersComplexSetP2) {

        Double M1SP1 = (double) summarizersComplexSetP1.support().size()/gameEntitiesP1.size();
        Double M2SP2 = (double) FuzzySet.intersect(summarizersComplexSetP2, qualifierP2.getFuzzySet()).support().size()/gameEntitiesP2.size();
        double res = M1SP1/(M1SP1 + M2SP2);
        if(quantifier.getMembershipFunction().isRelative()){
            return quantifier.compute(res);
        } else {
            return quantifier.compute(res * ParametersMapping.maxValueForParameter.get("AmountOfGames"));
        }
    }

    public static Double computeMultipleTypeThree(Quantifier quantifier, Summarizer qualifierP1, ArrayList<Summarizer> summarizer, ArrayList<GameEntity> gameEntitiesP1, ArrayList<GameEntity> gameEntitiesP2, FuzzySet<GameEntity> summarizersComplexSetP1, FuzzySet<GameEntity> summarizersComplexSetP2) {

        Double M1SP1 = (double) FuzzySet.intersect(summarizersComplexSetP1, qualifierP1.getFuzzySet()).support().size()/gameEntitiesP1.size();
        Double M2SP2 = (double) summarizersComplexSetP2.support().size()/gameEntitiesP2.size();
        double res = M1SP1/(M1SP1 + M2SP2);
        if(quantifier.getMembershipFunction().isRelative()){
            return quantifier.compute(res);
        } else {
            return quantifier.compute(res * ParametersMapping.maxValueForParameter.get("AmountOfGames"));
        }
    }

    public static Double computeMultipleTypeFour(FuzzySet<GameEntity> summarizersComplexSetP1, FuzzySet<GameEntity> summarizersComplexSetP2) {
        Double M1SP1 = (double) summarizersComplexSetP1.support().size();
        Double M2SP2 = (double) summarizersComplexSetP2.support().size();
        return M1SP1/(M1SP1 + M2SP2);
    }
}
