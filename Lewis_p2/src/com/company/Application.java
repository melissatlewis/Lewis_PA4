/* COP3330 Programming Assignment 4 - Problem 2
   Written by: Melissa Lewis */

package com.company;

public class Application {

    public static void main(String[] args) {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_word_counts.txt");
    }
}
