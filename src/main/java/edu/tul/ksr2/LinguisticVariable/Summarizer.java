package edu.tul.ksr2.LinguisticVariable;

import edu.tul.ksr2.GameEntity;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.Parameters.XMLReader;
import edu.tul.ksr2.Sets.FuzzySet;
import edu.tul.ksr2.Summary.FirstTypeSummarizationObject;
import edu.tul.ksr2.Summary.SummaryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Summarizer {

    public String name;
    private MembershipFunction membershipFunction;
    private FuzzySet<GameEntity> fuzzySet;

    public Summarizer(String name, MembershipFunction membershipFunction, FuzzySet<GameEntity> fuzzySet) {
        this.name = name;
        this.membershipFunction = membershipFunction;
        this.fuzzySet = fuzzySet;
    }

    public Summarizer(String name) {
        this.name = name;
    }

}
