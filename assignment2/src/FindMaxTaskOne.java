public class FindMaxTaskOne {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Please enter three float values.");
            System.exit(1);
        }

        float floatValue1 = Float.parseFloat(args[0]);
        float floatValue2 = Float.parseFloat(args[1]);
        float floatValue3 = Float.parseFloat(args[2]);

        float max = floatValue1;
        if (floatValue2 > max) {
            max = floatValue2;
        }
        if (floatValue3 > max) {
            max = floatValue3;
        }
        System.out.println("The maximum of the three numbers is: " + max);
    }

}
