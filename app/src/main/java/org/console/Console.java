package org.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.portfolio.*;

/**
 * <h3> 
 * Class for Console Interface </h3>
 * <p> This will be used if we flag CONSOLE.
 * Check {@link org.console.Console} for more details. </p>
 * @author Mark Jess Anthony S. Enfermo
 */
public class Console {
    /**
     * <p> This is the bool for the Console mainloop.
     */
    private boolean state;

    public Console() {
        state = true;
    }

    public void run(BufferedReader buffer) {
        char option;
        while(state) {
            displayMainMenu(); // mainmenu
            try {
                System.out.print("choice > ");
                option = buffer.readLine().charAt(0); // reads input first character
                switch(Character.toLowerCase(option)) {
                    case 'p', 'm', 's', 'f':
                        new SubMenu().run(buffer, Character.toLowerCase(option));
                        break;
                    case 'x': // exit program
                        state = false;
                        break;
                    default:
                        System.out.println("unknown choice!");
                        break;
                }
            } catch(IOException ioException) { // buffer errors, what to do if it happens? 
                ioException.printStackTrace();
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("""
                =================================
                M A I N  M E N U
                =================================
                P - Prelims
                M - Midterms
                S - Semi-Finals
                F - Finals
                X - Exit
                """);
    }

    // all submenus
    private class SubMenu {
        private boolean state;

        SubMenu() {
            state = true;
        }
        
        // mainOption must be lowercased
        public void run(BufferedReader buffer, char mainOption) throws IOException {
            char subOption;
            while(state) {
                displaySubMenu(mainOption); // display everything
                System.out.print("choice > ");
                subOption = Character.toLowerCase(buffer.readLine().charAt(0));
                if(Character.isDigit(subOption)) {
                    callFunctions(mainOption, subOption, buffer);
                } else if(subOption == 'x') {
                    state = false;
                }
            }
        }

        // important sub menu displays
        public void displaySubMenu(char option) {
            System.out.println("""
                    =================================
                    S U B  -  M E N U
                    =================================""");
            switch(option) {
                case 'p':
                    System.out.println("""
                        1 - Pre-Act#01 - Hello World
                        2 - Pre-Act#02 - The Tree
                        3 - Pre-Act#03 - Input/Output
                        4 - Pre-Act#04 - Methods, Classes, and Objects
                            """);
                    break;
                case 'm':
                    System.out.println("""
                        1 - Mid-Act#05 - Switch Case
                        2 - Mid-Act#06 - Loops
                        3 - Mid-Act#07 - Nested Loops
                            """);
                    break;
                case 's':
                    System.out.println("""
                        1 - SF-Act#01
                        2 - SF-Act#02
                        3 - SF-Act#03
                        4 - SF-Act#04
                        """);
                    break;
                case 'f':
                    System.out.println("""
                        1 - Finals-Act#01
                        2 - Finals-Act#02
                        3 - Finals-Act#03
                        4 - Finals-Act#04
                        """);
                    break;
            }
            System.out.println("X - Exit");
        }

        // call Functions
        public void callFunctions(char mainOption, int subOption, BufferedReader buffer) {
            switch(mainOption) {
                case 'p': 
                    switch(subOption) { // prelim functions
                        case '1': PrelimCodes.hello(); break;
                        case '2': PrelimCodes.theTree(); break;
                        case '3': // since there are 3 acts
                            PrelimCodes.profile();
                            PrelimCodes.operations();
                            PrelimCodes.profileJOption();
                            break;
                        case '4': PrelimCodes.dinosaur(); break;
                }
                case 'm':
                    switch(subOption) { // midterm functions
                        case '1': MidtermCodes.gradeEquivalent(buffer); break;
                        case '2': MidtermCodes.avgOfSeveral(buffer); break;
                        case '3': MidtermCodes.nestedGrading(buffer); break;
                    }
            }
        }
    }
}