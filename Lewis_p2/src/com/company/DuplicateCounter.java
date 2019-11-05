package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateCounter {
    public static ArrayList<String> uniqueWords;
    public static ArrayList<Integer> wordCounter;

    public DuplicateCounter() {
        uniqueWords = new ArrayList<String>();
        wordCounter = new ArrayList<Integer>();
    }

    public static void count(String dataFile) {
        File file = new File (dataFile);
        Scanner sc = null;
        // Try block will throw in the case of an exception
        try {

            sc = new Scanner(file);

            // Set up variables
            int index = 0;
            Boolean duplicateFound = false;
            String currWord;

            // Loop through all words located in the input file
            while (sc.hasNext()) {
                currWord = sc.next();

                // If the array of words is empty, add the first word
                if (uniqueWords.isEmpty()) {
                    uniqueWords.add(currWord);
                    wordCounter.add(1);
                    index++;
                }

                else {

                    // Loop through all words in the array and check the current word for duplicates
                    for (int i = 0; i < index; i++) {
                        // If a duplicate is found, increase the word counter by 1
                        if (uniqueWords.get(i).equals(currWord)) {

                            wordCounter.set(i, wordCounter.get(i) + 1);
                            duplicateFound = true;
                        }
                    }

                    // If the word doesn't currently exist in the array, add it
                    if (!duplicateFound) {
                        uniqueWords.add(currWord);
                        wordCounter.add(1);
                        index++;
                    }
                }

                // Reset boolean value
                duplicateFound = false;
            }

        }

        // Catch exceptions
        catch (IOException exception) {
            System.out.println("Error: exception occurred.");
        }

        finally {
            sc.close();
        }
    }

    public static void write(String outputFile) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outputFile, "utf-8");

            for (int i = 0; i < uniqueWords.size(); i++) {
                writer.print(uniqueWords.get(i) + " ");
                writer.print(wordCounter.get(i));
                writer.println();
            }
        }
        catch (IOException exception){
            System.out.println("Error: exception occurred.");
        }
        finally {
            writer.close();
        }
    }
}
