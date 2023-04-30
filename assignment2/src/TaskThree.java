public class TaskThree {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Please enter two integer values and a symbol.");
            System.exit(1);
        }

        int intValue1 = Integer.parseInt(args[0]);
        int intValue2 = Integer.parseInt(args[1]);
        char symbol = args[2].charAt(0);

        int result = switch (symbol) {
            case '+' -> intValue1 + intValue2;
            case '-' -> intValue1 - intValue2;
            case '*' -> intValue1 * intValue2;
            case '/' -> intValue2 != 0 ? intValue1 / intValue2 : 0;
            default -> {
                System.err.println("Your choice is incorrect");
                yield 0;
            }
        };

        System.out.println("The result of the operation is: " + result);
    }
}
