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

    public double calculateDegreeOfFuzziness() {
        return support().size() * 1.0 / set.size();
    }

    public static <T> FuzzySet<T> intersect(FuzzySet<T> first, FuzzySet<T> second) {
        FuzzySet<T> result = new FuzzySet<>();
        for (Map.Entry<T, Double> entity : first.set.entrySet()) {
            if (second.set.containsKey(entity.getKey()) && second.set.get(entity.getKey()) > 0.0) {
                result.set.put(entity.getKey(), Double.min(entity.getValue(), second.set.get(entity.getKey())));
            }
        }
        return result;
    }

}
