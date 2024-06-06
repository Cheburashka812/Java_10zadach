package com.mycompany.pyatyi;

import java.util.Scanner;
import java.util.Random;

public class Pyatyi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        double x, y;

        System.out.print("Vvedite razmer massivov n: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Nekorectnoe znachenie: ");
            scanner.next();
        }
        n = scanner.nextInt();

        System.out.print("Vvedite niznyy granicy diapazona x: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Nekorectnoe znachenie: ");
            scanner.next();
        }
        x = scanner.nextDouble();

        System.out.print("Vvedite verhnyy granicy diapazona y: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Nekorectnoe znachenie: ");
            scanner.next();
        }
        y = scanner.nextDouble();

        if(n <= 0) {
            System.out.println("Necorectnoe znachenie");
            return;
        }
        if(x >= y) {
            System.out.println("Necorectnoe znachenie");
            return;
        }

        double[] array1 = generateArray(n, x, y);
        double[] array2 = generateArray(n, x, y);
        double[] sumArray = new double[n];

        for (int i = 0; i < n; i++) {
            sumArray[i] = array1[i] + array2[i];
        }

        System.out.println("Massiv 1: ");
        printArray(array1);

        System.out.println("Massiv 2: ");
        printArray(array2);

        System.out.println("Sum massivov: ");
        printArray(sumArray);
    }

    public static double[] generateArray(int size, double min, double max) {
        Random random = new Random();
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = min + (max - min) * random.nextDouble();
        }
        return result;
    }

    public static void printArray(double[] array) {
        for(double value : array) {
            System.out.printf("%.2f ", value);
        }
        System.out.println();
    }
}
