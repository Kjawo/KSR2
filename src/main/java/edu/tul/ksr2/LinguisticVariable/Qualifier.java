package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Parameters.XMLReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Qualifier {

    public String tag;

    public Qualifier(String tag) {
        this.tag = tag;
    }

    public void loadData(ArrayList<GameEntity> gameEntities) {
        ArrayList<Object> gameData = (ArrayList<Object>) gameEntities.stream()
                .map(gameEntity -> gameEntity.get(tag))
                .collect(Collectors.toList());
//        System.out.println(gameData);

        ArrayList<LinguisticVariable> linguisticVariables = XMLReader.readLinguisicVariables();
        LinguisticVariable rightLingVar = null;
        for(LinguisticVariable LV : linguisticVariables){
            if(LV.getName().equals(ParametersMapping.ParametersMapper.get(tag))){
                rightLingVar = LV;
                break;
            }
        }
        double computedMembership,
                highestFoundMembership = 0;
        int indx = 0;
        String labelName = "";
        Map<String, Double> membership = new HashMap<>();

        for(Object obj : gameData){
            labelName = rightLingVar.getLabels().get(indx);
            for(MembershipFunction fun : rightLingVar.getMembershipFunctions()) {
                computedMembership = fun.compute(((double) (Integer) obj));
                if (computedMembership > highestFoundMembership) {
                    highestFoundMembership = computedMembership;
                    labelName = rightLingVar.getLabels().get(indx);
                }
                indx++;
            }
            membership.merge(labelName, (double) 1, Double::sum);
            highestFoundMembership = 0;
            indx = 0;
        }
        System.out.println(membership);
        Summarizer.summarizeAmmounts(membership);
    }
}
