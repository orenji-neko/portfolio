package org.console;

import java.io.BufferedReader;
import java.io.IOException;

import org.portfolio.PrelimCodes;

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
        String option;
        displayMainMenu();
        while(state) {
            try {
                displayMainMenu();
                System.out.print("choice > ");
                option = buffer.readLine();
                switch(Character.toLowerCase(option.charAt(0))) {
                    case 'p', 'm', 's', 'f':
                        new SubMenu(buffer).run(Character.toLowerCase(option.charAt(0))); // sub loop
                        break;
                    case 'x':
                        state = false; // break the loop
                        break;
                    default:
                        System.out.println("Unknown input!");
                        break;
                }
            } catch(IOException ioException) {
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

    /**
     * Sub Menu Class
     */
    private class SubMenu {
        private boolean state;
        private BufferedReader buffer;

        public SubMenu(BufferedReader buffer) {
            state = true;
            this.buffer = buffer;
        }

        public void run(char option) throws IOException {
            System.out.println("""
                    =================================
                    S U B  -  M E N U
                    =================================
                    """);
            displaySubMenu(option);
            while(state) {
                System.out.print("choice > ");
                option = buffer.readLine().charAt(0);
                switch(Character.toLowerCase(option)) {
                    case '1':
                        PrelimCodes.hello();
                        break;
                    default:
                        System.out.println("error! no command");
                        break;
                    case 'x':
                        state = false;
                        break;
                }
            }
        }

        private void displaySubMenu(char option) {
            switch(Character.toLowerCase(option)) {
                case 'p':
                    System.out.println("""
                        1 - Pre-Act#01
                        2 - Pre-Act#02
                        3 - Pre-Act#03
                        4 - Pre-Act#04""");
                    break;
                default:
                    System.out.println("Not yet implemented!");
                    break;
            }
            System.out.println("X - Main Menu");
        }
    }
}