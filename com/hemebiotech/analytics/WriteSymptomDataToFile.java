package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.File;
import java.util.TreeSet;

/**
 * Simple implementation writing in a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(new File("results.out"))) {
            // I'm using the TreeSet to sort my symptoms
            for (String symptom : new TreeSet<>(symptoms.keySet())) {
                writer.write(symptom + ": " + symptoms.get(symptom) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}