package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {

    public static ArrayList<String> uniqueWords;

    public DuplicateRemover() {
        uniqueWords = new ArrayList<String>();
    }



    public static void remove(String dataFile) {
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
                    index++;
                }

                else {

                    // Loop through all words in the array and check the current word for duplicates
                    for (int i = 0; i < index; i++) {
                        if (uniqueWords.get(i).equals(currWord)) {
                            duplicateFound = true;
                            break;
                        }
                    }

                    // If the word doesn't currently exist in the array, add it
                    if (!duplicateFound) {
                        uniqueWords.add(currWord);
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
            } // Replace with print to output file*/
        }
        catch (IOException exception){
            System.out.println("Error: exception occurred.");
        }
        finally {
            writer.close();
        }
    }
}