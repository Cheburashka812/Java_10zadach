package com.mycompany.desyatyi;

import java.util.Scanner;

public class Desyatyi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] productNames = new String[3];
        int[] productQuantities = new int[3];
        double[] productPrices = new double[3];


        for (int i = 0; i < 3; i++) {
            System.out.println("Vvedite nazvanie tovara " + (i + 1) + ":");
            productNames[i] = input.nextLine();

            System.out.println("Vvedite kolichestvo produkta " + productNames[i] + ":");
            productQuantities[i] = input.nextInt();

            System.out.println("Vvedite cenu " + productNames[i] + ":");
            productPrices[i] = input.nextDouble();
            input.nextLine();
        }

        for (int i = 0; i < 3; i++) {
            double inventoryCost = productPrices[i] * productQuantities[i];
            System.out.println("Stoimost vsex " + productNames[i] + ": " + inventoryCost);
        }
    }
}
