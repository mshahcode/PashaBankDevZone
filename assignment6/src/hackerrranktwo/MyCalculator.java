package hackerrranktwo;

import java.util.Scanner;

public class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else {
            return (long) Math.pow(n, p);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        MyCalculator my_calculator = new MyCalculator();
        try {
            long ans = my_calculator.power(n, p);
            System.out.println(ans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
