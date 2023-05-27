package org.portfolio;

import java.io.*;

public class MidtermCodes {
    /**
     * <h4>Midterm Act 05</h4>
     * <p>Grade Equivalent</p>
     */
    public static void gradeEquivalent(BufferedReader buffer) {
        System.out.print("Input grade: ");
        double d = 0;
        try {
		    d = Double.parseDouble(buffer.readLine());
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
		
		if(gradeConvert(d) != 'X') {
			System.out.printf("The equivalent letter grade for %.2f is %c\n", d, gradeConvert(d));
		} else {
			System.out.println("The grade is invalid.");
		}
    }
    private static char gradeConvert(double grade) {
		if(grade >= 1.0 && grade <= 1.5) {
			return 'A';
		} else if(grade >= 1.6 && grade <= 2.0) {
			return 'B';
		} else if(grade >= 2.1 && grade <= 2.5) {
			return 'C';
		} else if(grade >= 2.6 && grade <= 3.0) {
			return 'D';
		} else if(grade >= 3.1 && grade <= 5.0) {
			return 'F';
		} else {
			return 'X';
		}
	}

    /**
     * <h4>Midterm Act 06</h4>
     * <p>Average of Several Grades</p>
     */
    public static void avgOfSeveral(BufferedReader b) {
        int n = 0;
        double buffer = 0, output = 0;
        
        System.out.print("First, enter the number of grades to process: ");
        do {
            try {
                n = Integer.parseInt(b.readLine());
                if(n < 2) System.out.print("Error! Number must be greater than one. Enter again: ");
            } catch(IOException ioException) {
                ioException.printStackTrace();
            }
        } while(n < 2);
        
        for(int i = 0; i < n;) {
           System.out.printf("Enter grade #%d: ", i + 1);
            try {
                buffer = Double.parseDouble(b.readLine());
            } catch(IOException ioException) {
                ioException.printStackTrace();
            }
           if(!(buffer >= 1.0 && buffer <= 5.0)) {
              System.out.println("*** Invalid entry. Grade must be from 1.0 to 5.0 ***");
           }
           else {
              output += buffer;
              i++;
           }
        }
        
        output = output / n;
        System.out.printf("The average of the %d grades entered is %.1f\n", n, output);
        System.out.printf("You have a letter grade of %c\n", gradeConvert(output));

    }

    /**
     * <h4>Midterm Act 07</h4>
     * <p>Average of Several Grades with range checking</p>
     */
    public static void nestedGrading(BufferedReader b) {
        int n = 0;
        double buffer = 0, output = 0;
        boolean active = true, inputMode = true;

        do {
            try {
                System.out.print("First, enter the number of grades to process: ");
            
                while(n < 2 && inputMode) {
                    n = Integer.parseInt(b.readLine());
                    if(n < 2) System.out.print("Error! Number must be greater than 1, Input again: ");
                    else inputMode = false;
                }
                    
                for(int i = 0; i < n;) {
                    System.out.printf("Enter grade #%d: ", i + 1);
                    buffer = Double.parseDouble(b.readLine());
            
                    if(!(buffer >= 1.0 && buffer <= 5.0)) {
                        System.out.println("*** Invalid entry. Grade must be from 1.0 to 5.0 ***");
                    }
                    else {
                        output += buffer;
                        i++;
                    }
                }

                output = output / n;
                System.out.printf("The average of the %d grades entered is %.2f\n", n, output);
                System.out.printf("You have a letter grade of %c\n", gradeConvert(output)); 
                
                System.out.print("Do you want to try again?[y/n]: ");
                switch(b.readLine()) {
                    case "y":
                        inputMode = true;
                        n = 0;
                        output = 0;
                        break;
                    case "n":
                    default:
                        active = false;
                        break;
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } while(active);
    }
}
