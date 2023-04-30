public class TaskFour {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please enter one symbol.");
            System.exit(1);
        }

        char symbol = args[0].charAt(0);

        if(symbol >=97 & symbol <= 122){
            System.out.println(Character.toUpperCase(symbol));
        } else if (symbol>=65 & symbol <= 90) {
            System.out.println(Character.toLowerCase(symbol));
        }else{
            System.out.println("The symbol you entered is not alphabet");
        }
    }
}
