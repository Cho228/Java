package Lab0.src.main.java.lab0;

import java.util.Scanner;

public class Variant2 {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int Integer2(int M)
    {
        assert (M >= 1000): ("If the weight is lower than 1 ton, it makes no sense to use this function");

        return M / 1000;
    }

    public static boolean Boolean2(int number)
    {
        return number % 2 != 0;
    }

    public static int If2(int number) {
        if (number > 0) {
            number += 1;
        } else {
            number -= 2;
        }
        return number;
    }

    public static String Case2(int k) {
        return switch (k) {
            case 1 -> ("Bad");
            case 2 -> ("Unsatisfactory");
            case 3 -> ("Satisfactory");
            case 4 -> ("Good");
            case 5 -> ("Awesome");
            default -> throw new IllegalArgumentException("The grade should be between 1-5");
        };
    }

    public static int For2(int a, int b) {
        assert (a < b): ("A must be smaller than B");

        int count = 0;
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
            count++;
        }
        return count;
    }

    public static int While2(int a, int b) {

        assert(a > 0): "A must be positive integer.";
        assert(b > 0): "B must be positive integer.";
        assert(a > b): "A must be greater than B.";

        int count = 0;
        while (a >= b) {
            a -= b;
            count++;
        }

        return count;
    }

    public static int[] Array2(int n) {
        assert (n > 0) : ("N must be more than 0");

        int[] powersOfTwo = new int[n];
        for (int i = 0; i < n; i++) {
            powersOfTwo[i] = (int) Math.pow(2, i + 1);
        }

        return powersOfTwo;
    }

    public static int[][] Matrix2(int m, int n) {
        assert (m > 0): "Number of rows should be > 0";
        assert (n > 0): "Number of columns should be > 0";

        int[][] matrix = new int[m][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 5 * (j + 1);
            }
        }

        return matrix;
    }
}