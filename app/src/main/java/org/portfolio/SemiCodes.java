package org.portfolio;

import java.io.BufferedReader;
import java.io.IOException;

public class SemiCodes {
    /**
     * <h4>Semifinals Act 09</h4>
     * <p>String Manipulation</p>
     */
    public static void stringActivity() {
        String str = "The quick brown fox";
        System.out.println(str);

        System.out.printf("Length: %d\n", str.length());

        // concat
        str = str.concat(" jumps over the lazy dog.");
        System.out.println(str);

        // length of concatenated
        System.out.printf("Length: %d\n", str.length());

        // starts with the
        System.out.printf("Starts with 'The': %b\n", str.startsWith("The"));

        // replacing
        str = str.replace("brown", "black").replace("fox", "wolf").replace("dog", "pig");
        System.out.println(str);

        // upper casing
        str = str.toUpperCase();
        System.out.println(str);

        // check brown
        System.out.printf("%s contains 'brown': %b\n", str, str.contains("brown".toUpperCase()));
        // check black
        System.out.printf("%s contains 'black': %b\n", str, str.contains("black".toUpperCase()));

        // PIG index
        System.out.printf("Index of the word 'PIG': %d\n", str.indexOf("PIG"));
    }

    /**
     * <h4>Semifinals Act 10</h4>
     * <p>Working with arrays</p>
     */
    public static void sortArrays(BufferedReader buffer) {
        int len = 5;
        double[] grades = new double[len];

        System.out.printf("Enter %s grades\n", len);

        for(int i = 0; i < grades.length; i++) {
            System.out.printf("Enter grade #%d: ", i + 1);
            try {
                grades[i] = Double.parseDouble(buffer.readLine());
            } catch(IOException ioException) {
                ioException.printStackTrace();
            }
        }

        System.out.println("\nEntered grades");
        for(double grade : grades) {
            System.out.printf("  %.2f", grade);
        } System.out.println();

        // selection sort
        double avg = 0, temp;
        for(int i = 0; i < grades.length; i++) {
            
            for(int j = i + 1; j < grades.length; j++) {
                if(grades[i] > grades[j]) {
                    temp = grades[j];
                    grades[j] = grades[i];
                    grades[i] = temp;
                }
            }

            avg += grades[i];
        }
        avg = avg / len;
        
        System.out.println("\nGrades sorted in ascending order");
        for(double grade : grades) {
            System.out.printf("  %.2f", grade);
        } System.out.println();

        System.out.printf("\nSmallest grade: %.2f\n", grades[0]);
        System.out.printf("Largest grade: %.2f\n", grades[grades.length - 1]);
        System.out.printf("Average: %.2f\n", avg);
    }
}
