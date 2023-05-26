package org.portfolio;
import org.console.Console;
import java.io.*;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        Console console = new Console();
        console.run(buffer);
    }
}