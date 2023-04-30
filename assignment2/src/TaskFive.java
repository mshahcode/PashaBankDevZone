public class TaskFive {
    public static void main(String[] args) {
        int firstOdd = 2;
        int oddJump = 5;

        int firstEven = 5;
        int oddEven = 3;

        int totalSizeOdd = ((112 - firstOdd) / oddJump) + 1;
        int totalSizeEven = ((71 - firstEven) / oddEven) + 1;

        int sumOdd = ((firstOdd + 112)*totalSizeOdd)/2;
        int sumEven = ((firstEven + 71)*totalSizeEven)/2;

        System.out.println("Sum of sequence is: " + (sumOdd + sumEven));

    }
}
