package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

  /**
  * Execute the Analytics counter application.
  */
  public static void main(String[] args) {
    ISymptomWriter writer = new WriteSymptomDataToFile();
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
    List<String> symptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(symptoms);
    Map<String, Integer> mapSymptomsSorted = analyticsCounter.sortSymptoms(mapSymptoms);
    analyticsCounter.writeSymptoms(mapSymptomsSorted);
  }

}