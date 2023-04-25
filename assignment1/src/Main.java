import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // task 1,2,3,4,5,6
        int number = 30;
        System.out.println(number);

        double valueDouble = (double) number;
        System.out.println(valueDouble);

        int valueInt = 20;
        System.out.println(valueInt);

        String valueString = "Learning Session";
        System.out.println(valueString);

        valueDouble = 23.63;
        System.out.println(valueDouble);

        // User-Input Task

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer value: ");
        valueInt = scanner.nextInt();

        System.out.print("Enter a double value: ");
        valueDouble = scanner.nextDouble();

        System.out.print("Enter a character: ");
        char valueChar = scanner.next().charAt(0);

        System.out.print("Enter a string: ");
        valueString = scanner.next();

        System.out.println("Integer: " + valueInt);
        System.out.println("Double: " + valueDouble);
        System.out.println("Character: " + valueChar);
        System.out.println("String: " + valueString);

    }
}