package com.mycompany.shestoy;

import javax.swing.JOptionPane;
import java.util.Random;

public class Shestoy {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Введите размерность матриц n:"));
        double x = Double.parseDouble(JOptionPane.showInputDialog("Введите нижнюю границу диапазона x:"));
        double y = Double.parseDouble(JOptionPane.showInputDialog("Введите верхнюю границу диапазона y (больше x):"));

        while (y <= x) {
            y = Double.parseDouble(JOptionPane.showInputDialog("Верхнюю границу должна быть больше нижней. Введите y снова:"));
        }

        double[][] matrix1 = generateMatrix(n, x, y);
        double[][] matrix2 = generateMatrix(n, x, y);
        double[][] productMatrix = multiplyMatrix(matrix1, matrix2, n);

        JOptionPane.showMessageDialog(null, matrixToString(matrix1, n, "Матрица 1:")
                + " " + matrixToString(matrix2, n, "Матрица 2:")
                + " " + matrixToString(productMatrix, n, "Произведение матриц:"));
    }

    private static double[][] generateMatrix(int n, double x, double y) {
        Random random = new Random();
        double[][] matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = x + (y - x) * random.nextDouble();
            }
        }

        return matrix;
    }

    private static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2, int n) {
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static String matrixToString(double[][] matrix, int n, String title) {
        StringBuilder sb = new StringBuilder(title + " ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%.2f ", matrix[i][j]));
            }
            sb.append(" ");
        }

        return sb.toString();
    }
}
