package inputvalidation;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();

            String s = String.valueOf(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input type. Please enter an integer!");
        }
    }
}

