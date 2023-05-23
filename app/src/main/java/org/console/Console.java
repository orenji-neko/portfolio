package org.console;

/**
 * <h3> 
 * Class for Console Interface </h3>
 * <p> This is a Runnable. This will be used if we flag CONSOLE.
 * Check {@link org.console.Console} for more details. </p>
 * @author Mark Jess Anthony S. Enfermo
 */
public class Console implements Runnable {
    /**
     * <p> This is the bool for the Console mainloop.
     */
    private boolean state = false;

    @Override
    public void run() {
        System.out.println("""
                Never gonna give you up,\n
                never gonna let you down, \n
                never gonna run around and \n
                desert you.
                """);
    }
}
