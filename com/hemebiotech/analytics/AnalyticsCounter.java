package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Contain the methods to read, write, count and sort the symptoms.
 */
public class AnalyticsCounter {
  private final ISymptomReader reader;
  private final ISymptomWriter writer;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
   * Read the symptoms from the {@link ISymptomReader}.
   *
   * @return a {@link List} containing the read symptoms, can be empty.
   */
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  /**
   * Count the symptoms.
   *
   * @param symptoms a {@link List} containing the read symptoms, can be empty.
   * @return a {@link Map} with unsorted symptoms as key and count as value
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    return symptoms.stream().collect(
        Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 1))
      );
  }

  /**
   * Sort the symptoms.
   *
   * @param symptoms a {@link Map} with unsorted symptoms as key and count as value
   * @return a {@link Map} with sorted symptoms as key and count as value
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  /**
   * Writes the symptoms to the {@link ISymptomWriter}.
   *
   * @param symptoms a {@link Map} with sorted symptoms as key and count as value
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}