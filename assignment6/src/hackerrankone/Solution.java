package hackerrankone;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int dividend = scanner.nextInt();
            int divisor = scanner.nextInt();

            if (divisor == 0) {
                throw new ArithmeticException("/ by zero");
            }

            int quotient = dividend / divisor;
            System.out.println(quotient);
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: " + e.getMessage());
        }
    }
}