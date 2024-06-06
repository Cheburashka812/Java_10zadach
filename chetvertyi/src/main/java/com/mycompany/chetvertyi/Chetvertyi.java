package com.mycompany.chetvertyi;

import java.util.Scanner;
import java.util.Random;

public class Chetvertyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vvedite dliny massiva n: ");
        int n = getIntFromUser(scanner);

        System.out.print("Vvedite niznnyy granicy diapazona x: ");
        double x = getDoubleFromUser(scanner);

        System.out.print("Vvedite verhnyy granicy diapazona y: ");
        double y = getDoubleFromUser(scanner);

        while(y <= x) {
            System.out.println("Nekorectnoe znachenie dlya y.");
            y = getDoubleFromUser(scanner);
        }

        double[] array = new double[n];
        Random random = new Random();
        double sum = 0;

        System.out.println("Elementy:");
        for (int i = 0; i < array.length; i++) {
            array[i] = x + (y - x) * random.nextDouble();
            sum += array[i];
            System.out.println(array[i]);
        }

        double average = sum / n;

        System.out.println("Summa elementov: " + sum);
        System.out.println("Sr arifm: " + average);
    }

    private static int getIntFromUser(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Necorectnoe chislo.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getDoubleFromUser(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Necorectnoe chislo.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}