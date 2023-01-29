package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

  private ISymptomReader reader;
  private ISymptomWriter writer;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms(){
    return reader.getSymptoms();
  }

  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    return symptoms.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 1)));
  }

  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    return new TreeMap<>(symptoms);
  }
	
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}