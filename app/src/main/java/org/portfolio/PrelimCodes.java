package org.portfolio;

import javax.swing.*;
import java.util.*;

public class PrelimCodes {
    /**
     * <h4>Prelim Act 01</h4>
     * <p>Hello World</p>
     */
    public static void hello() {
        System.out.println("Hello World!");
    }

    /**
     * <h4>Prelim Act 02</h4>
     * <p>The tree</p>
     */
    public static void theTree() {
        System.out.printf("I think that I shall never see,%na poem as lovely as a tree.%nA tree whose hungry mouth is pressed%nAgainst the Earth's sweet flowing breast.");
    }

    /**
     * <h4>Prelim Act 03A</h4>
     * <p>Input output using Console </p>
     */
    public static void profile() {
        // Console profile
        Scanner scan = new Scanner(System.in);
        String name, address;
        int age;

        System.out.println("----------PROFILE----------");
        System.out.print("Name: "); name = scan.nextLine();
        System.out.print("Age: "); age = scan.nextInt();
        System.out.print("Address: "); address = scan.nextLine();
        
        System.out.printf("%nYou are %s, age %d.%n", name, age);
        System.out.printf("%nWelcome, %s%n", name);
    }

    /**
     * <h4>Prelim Act 03B</h4>
     * <p>Input using console - 2</p>
     */
    public static void operations() {
        int a, b;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type number a: "); a = scan.nextInt();
        System.out.print("Type number b: "); b = scan.nextInt();

        System.out.printf("%nThe sum of %d and %d is %d.%n", a, b, a + b);
        System.out.printf("The difference of %d and %d is %d.%n", a, b, a - b);
        System.out.printf("The product of %d and %d is %d.%n", a, b, a * b);
        System.out.printf("The quotient of %d and %d is %d.%n", a, b, a / b);
    }

    /**
     * <h4>Prelim Act 03C</h4>
     * <p>Input using JOptionPane</p>
     */
    public static void profileJOption() {

        //JOptionPane profile
        String name;
        int age;
        name = JOptionPane.showInputDialog(null, "Type your name:");
        age = Integer.parseInt(JOptionPane.showInputDialog(null, "Type your age:"));
        JOptionPane.showMessageDialog(null, String.format("Name: %s, Age: %d", name, age));
    }

    /**
     * <h4>Prelim Act 04</h4>
     * <p>Create a Class with properties and methods 
     * that you can use for your selected object.</p>
     */
    public static void dinosaur() {
        System.out.println("Hello World!");
        Dinosaur trex = new Dinosaur("Tyrannosaurus Rex", "Rex");
        Dinosaur velociraptor = new Dinosaur("Velociraptor", "Charlie");
        
        trex.roar();
        velociraptor.roar();
        
        trex.die();
        velociraptor.die();
    }
    private static class Dinosaur {
   
        String species, name;
        
        public Dinosaur(String species, String name) {
           this.species = species;
           this.name = name;
           
           System.out.printf("Hello, I am the new %s dinosaur, %s.\n", this.species, this.name);
        }
        
        public void roar() {
           System.out.printf("%s: rawr!\n", name);
        }
        
        public void die() {
           System.out.printf("%s, the %s, died.\n", name, species);
        }
    }
}
