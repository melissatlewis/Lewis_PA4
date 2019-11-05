/* COP3330 Programming Assignment 4 - Problem 1
   Written by: Melissa Lewis */

package com.company;

public class Application {

    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
	    duplicateRemover.remove("problem1.txt");
	    duplicateRemover.write("unique_words.txt");

    }
}
