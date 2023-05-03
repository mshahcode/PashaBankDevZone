import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Task 1: Print the square root of all integers less than N
        int N = 5;
        for (int i = 1; i < N; i++) {
            System.out.print(Math.sqrt(i) + " ");
        }
        System.out.println();

        // Task 2: Display Fibonacci series up to N terms using while loop
        int n = 10;
        int firstTerm = 0, secondTerm = 1;
        System.out.print(firstTerm + " " + secondTerm + " ");
        int i = 2;
        while (i < n) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(nextTerm + " ");
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            i++;
        }
        System.out.println();

        // Task 3: Print all prime numbers within a given range
        int start = 10, end = 70;
        System.out.print("Prime numbers between " + start + " and " + end + ": ");
        for (int j = start; j <= end; j++) {
            boolean isPrime = true;
            for (int k = 2; k < j; k++) {
                if (j % k == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(j + " ");
            }
        }
        System.out.println();

        // Task 4: Find min and max of a multi-dimensional array
        int[][] arr = {{1, 2, 5}, {10, 23, 4}, {56, 22, 43}};
        int min = arr[0][0], max = arr[0][0];
        for (int[] row : arr) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
                if (element > max) {
                    max = element;
                }
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
