package com.mycompany.tretiy;

import java.util.Random;
import java.util.Scanner;

public class Tretiy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vvedite dliny massiva n: ");
        int n = getIntFromUser(scanner);

        int[] originalArray = new int[n];
        int[] reversedArray = new int[n];
        Random randomGenerator = new Random();

        System.out.println("Ishodnyi massiv:");
        for (int i = 0; i < n; i++) {
            originalArray[i] = randomGenerator.nextInt(100);
            System.out.print(originalArray[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            reversedArray[n - i - 1] = originalArray[i];
        }

        System.out.println("Obratniy massiv:");
        for (int value : reversedArray) {
            System.out.print(value + " ");
        }
    }

    private static int getIntFromUser(Scanner scanner) {
        int input = -1;
        while (input < 1) {
            if (!scanner.hasNextInt()) {
                System.out.println("Eto ne chislo:");
                scanner.next();
                continue;
            }
            input = scanner.nextInt();
            if (input < 1) {
                System.out.println("Chislo dolzno byt polozhitelnum:");
            }
        }
        return input;
    }
}