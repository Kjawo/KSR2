package edu.tul.ksr2.Sets;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.HashMap;

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
}
