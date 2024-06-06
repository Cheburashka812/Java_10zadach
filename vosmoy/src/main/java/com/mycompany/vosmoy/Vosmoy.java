package com.mycompany.vosmoy;

import java.util.Random;
import java.util.Scanner;

public class Vosmoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int startRange;
        int endRange;
        String input;
        int targetNumber;
        int guess;


        System.out.print("Vvedite nachalo diapazona: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Necorectnoe znachenie");
            scanner.next();
        }
        startRange = scanner.nextInt();

        System.out.print("Vvedite konec diapazona: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Necorectnoe znachenie");
            scanner.next();
        }
        endRange = scanner.nextInt();

        if (startRange > endRange) {
            int temp = startRange;
            startRange = endRange;
            endRange = temp;
        }

        targetNumber = startRange + random.nextInt(endRange - startRange + 1);
        System.out.println("I zagadal chiclo ot " + startRange + " do " + endRange + ". Poprobyi ugadat eto chislo. Vvedi 'Sdays!' dlya zavercheniya igry.");

        while (true) {
            System.out.print("Vasha popytka: ");
            input = scanner.next();

            if ("Sdays!".equalsIgnoreCase(input)) {
                System.out.println("Igra zavershena. Zagadannoe chislo bylo: " + targetNumber);
                break;
            }

            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vvedite celoe chislo ili 'Sdays!' dlya sdachi.");
                continue;
            }

            if (guess == targetNumber) {
                System.out.println("Pozdravlyem! Vy ugadali chislo!");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Zagadannoe chislo bolshe.");
            } else {
                System.out.println("Zagadannoe chislo menshe.");
            }
        }

        scanner.close();
    }
}