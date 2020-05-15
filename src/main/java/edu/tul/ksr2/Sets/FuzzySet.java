package edu.tul.ksr2.Sets;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;

import java.util.HashMap;

public class FuzzySet<T> {
    public MembershipFunction membershipFunction;
    public HashMap<T, Double> set;

    public FuzzySet() {
        set = new HashMap<>();
    }

    public FuzzySet(HashMap<T, Double> set) {
        this.set = set;
    }

    public FuzzySet(MembershipFunction membershipFunction) {
        set = new HashMap<>();
        this.membershipFunction = membershipFunction;
    }

    public FuzzySet(MembershipFunction membershipFunction, HashMap<T, Double> set) {
        this.membershipFunction = membershipFunction;
        this.set = set;
    }
}
