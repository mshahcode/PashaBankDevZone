public class FindMinTaskTwo {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Please enter three short values.");
            System.exit(1);
        }

        short floatValue1 = Short.parseShort(args[0]);
        short floatValue2 = Short.parseShort(args[1]);
        short floatValue3 = Short.parseShort(args[2]);

        short min = (floatValue1 < floatValue2) ? ((floatValue1 < floatValue3) ? floatValue1 : floatValue3) : ((floatValue2 < floatValue3) ? floatValue2 : floatValue3);

        System.out.println("The minimum of the three numbers is: " + min);
    }

}
