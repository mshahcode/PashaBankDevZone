package numberoperations;

public class Solution {
    public static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;

        for (int day = i; day <= j; day++) {
            int reversed = reverseNumber(day);
            if (Math.abs(day - reversed) % k == 0) {
                beautifulDays++;
            }
        }
        return beautifulDays;
    }

    public static int reverseNumber(int number) {
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int i = 20;
        int j = 23;
        int k = 6;

        int result = beautifulDays(i, j, k);
        System.out.println(result);
    }
}
