package uncheckedException;

public class UncheckedException {
    public static void divideByZero() {
        int x = 1;
        int y = 0;
        int result = x / y;
        System.out.println(result);
    }
    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            System.err.println("Divide by zero: " + e.getMessage());
        }
    }
}
