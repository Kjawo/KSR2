package edu.tul.ksr2.Sets;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FuzzySet<T> {
    public HashMap<T, Double> set;

    public FuzzySet() {
        set = new HashMap<>();
    }

    public FuzzySet(HashMap<T, Double> set) {
        this.set = set;
    }

    public HashMap<T, Double> getSet() {
        return set;
    }

    public void setSet(HashMap<T, Double> set) {
        this.set = set;
    }

    public void add(T t, Double d) {
        set.put(t, d);
    }

    public HashMap<T, Double> support() {
        HashMap<T, Double> support = new HashMap<>();

        for (Map.Entry<T, Double> entry : set.entrySet()) {
            if(entry.getValue() > 0.0)
            {
                support.put(entry.getKey(), entry.getValue());
            }
        }

        return support;
    }

}
