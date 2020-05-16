package edu.tul.ksr2.Summary;

import java.util.*;

public class SummaryGenerator {
    public List<Tuple<Summary, SummarizationState>> createSummary(Iterable<DCResMeasurement> dcResMeasurements,
                                                                  List<Quantifier> quantifiers,
                                                                  List<Qualifier> qualifiers,
                                                                  List<Summarizer> summarizers,
                                                                  boolean isAndQualifier,
                                                                  boolean isAndSummarizer) {
        summaries.clear();
        Iterator<?> source = dcResMeasurements.iterator();
        List<Object> dataList = new ArrayList<>();
        source.forEachRemaining(dataList::add);
        //TYPU PIERWSZEGO
        //pojedynczy sumaryzator
        for (Summarizer s : summarizers) {
            summaries.add(this.createSummaryFirstType(dataList, quantifiers, s));
        }
        //dwa złączone
            List<Summarizer> tempSumList = new ArrayList<>();
            for (int i = 0; i < summarizers.size(); i++) {
                for (int j = summarizers.size() - 1; j > i; j--) {
                    tempSumList.clear();
                    if (!summarizers.get(i).getMemberFieldName().equals(summarizers.get(j).getMemberFieldName())) {
                        tempSumList.add(summarizers.get(i));
                        tempSumList.add(summarizers.get(j));
                        summaries.add(this.createSummaryFirstTypeMultipleSummarizers(dataList, quantifiers, tempSumList, isAndSummarizer));
                    }
                }
            }
        return summaries;
    }

    private Tuple<Summary, SummarizationState> createSummaryFirstType(List<?> dataList,
                                                                      List<Quantifier> quantifiers,
                                                                      Summarizer summarizer) {
        FuzzySet summarizersSet = FuzzySet.with(dataList).from(summarizer);

        /*double finalSizeNormalized = calculateNormalized(summarizersSet);
        System.out.println(finalSizeNormalized);*/

        SummarizationState summarizationState =
                new SummarizationState(
                        new ArrayList<>(),
                        quantifiers,
                        Collections.singletonList(summarizer),
                        summarizersSet,
                        false,
                        false);

        Tuple<String, Double> nameMaxTuple = this.extractNameAndMax(quantifiers, DegreeOfTruthT1.calculateR(dataList, summarizationState, false));
        double max = nameMaxTuple.getSecond();
        String name = nameMaxTuple.getFirst();
        QualityTuple dot = QualityTuple.of(
                round(max)
        );

        String summaryContent = String.format(this.standardContext, name);
        summaryContent += summarizer.getName();

        Map<String, QualityTuple> qualityMeasures = calculateQualityMeasures(dataList, summarizationState, max, name, false);

        return new Tuple<>(
                new Summary(summaryContent,
                        qualityMeasures.get("T"),
                        dot,
                        qualityMeasures.get("T2"),
                        qualityMeasures.get("T3"),
                        qualityMeasures.get("T4"),
                        qualityMeasures.get("T5"),
                        qualityMeasures.get("T6"),
                        qualityMeasures.get("T7"),
                        qualityMeasures.get("T8"),
                        qualityMeasures.get("T9"),
                        qualityMeasures.get("T10"),
                        qualityMeasures.get("T11")),
                new SummarizationState(
                        new ArrayList<>(),
                        null,
                        Collections.singletonList(summarizer),
                        summarizersSet,
                        false
                        , false
                )
        );
    }
}
