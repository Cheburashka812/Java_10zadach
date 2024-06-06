package com.mycompany.vtoroi;

import java.util.Random;
import java.util.Scanner;

public class Vtoroi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vvedite kolichestvo strok n: ");
        int n = getIntFromUser(scanner);

        System.out.print("Vvedite kolichestvo stolbcov m: ");
        int m = getIntFromUser(scanner);

        int[][] matrix = new int[n][m];
        int[] rowSum = new int[n];
        int[] columnSum = new int[m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Random randomGenerator = new Random();

        System.out.println("Ishodnaya matrica:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = randomGenerator.nextInt(100);
                System.out.print(matrix[i][j] + " ");

                rowSum[i] += matrix[i][j];
                columnSum[j] += matrix[i][j];

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            System.out.println();
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Summa elementov po strokam:");
        for (int sum : rowSum) {
            System.out.print(sum + " ");
        }
        System.out.println("Summa elementov po stolbcam:");
        for (int sum : columnSum) {
            System.out.print(sum + " ");
        }
    }

    private static int getIntFromUser(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Eto ne chislo:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
