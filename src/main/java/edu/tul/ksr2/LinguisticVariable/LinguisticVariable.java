package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinguisticVariable {

    double a;
    double b;
    double c;
    double d;
    String tag;

    public LinguisticVariable(String tag) {
        this.tag = tag;
    }

    public void loadData(ArrayList<GameEntity> gameEntities){
        String type = gameEntities.get(0).get(tag).getClass().getSimpleName();
        ArrayList<Object> arrayList = (ArrayList<Object>) gameEntities.stream()
                                        .map(gameEntity -> gameEntity.get(tag))
                                        .collect(Collectors.toList());
        System.out.println(arrayList);

    }
}
