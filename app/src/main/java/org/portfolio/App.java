package org.portfolio;
import org.console.*;


public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Thread mainthread = new Thread(new Console());
        mainthread.start();
    }
}