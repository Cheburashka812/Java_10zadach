package com.mycompany.pervyi;

import java.util.Scanner;
import java.util.Random;

public class Pervyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Vvedite razmer massiva: ");
        int n = getPositiveIntFromUser(scanner);

        System.out.println("Vvedite znachenie poroga: ");
        int x = scanner.nextInt();

        int[] randomNumbers = new int[n];
        System.out.println("Ishodnyi massiv: ");
        for (int i = 0; i < n; i++) {
            randomNumbers[i] = random.nextInt(101);
            System.out.print(randomNumbers[i] + " ");
        }

        System.out.println("Indeksy elementov, znacheniya kotoryx prevoshodyat porog " + x + ":");
        for (int i = 0; i < n; i++) {
            if (randomNumbers[i] > x) {
                System.out.print(i + " ");
            }
        }
    }

    private static int getPositiveIntFromUser(Scanner scanner) {
        int input;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Necorectnoe znachenie: ");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input > 0) {
                return input;
            } else {
                System.out.println("Necorectnoe znachenie: ");
            }
        }
    }
}
