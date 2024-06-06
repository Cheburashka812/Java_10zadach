package com.mycompany.sedmoy;

import java.util.Scanner;

public class Sedmoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vvedite radius okruznhosti: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Nekorectnoe znachenie:");
            scanner.next();
        }
        double radius = scanner.nextDouble();

        while (radius <= 0) {
            System.out.println("Nekorectnoe znachenie");
            while (!scanner.hasNextDouble()) {
                System.out.println("Nekorectnoe znachenie");
                scanner.next();
            }
            radius = scanner.nextDouble();
        }

        System.out.println("Vyberite cel rascheta. Vvedite 'ploshad' dlya rascheta plochadi okryznosti ili  'dlina' dlya rascheta dliny okruznosti:");
        String calculationType = scanner.next();

        while (!(calculationType.equalsIgnoreCase("ploshad") || calculationType.equalsIgnoreCase("dlina"))) {
            System.out.println("Nekorectnoe znachenie:");
            calculationType = scanner.next();
        }

        if (calculationType.equalsIgnoreCase("ploshad")) {
            System.out.println("Ploshad okruznosti s radiusom " + radius + " = " + calculateArea(radius));
        } else {
            System.out.println("Dlina okruznosti s radiusom " + radius + " = " + calculateCircumference(radius));
        }

        scanner.close();
    }

    private static double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }
}
