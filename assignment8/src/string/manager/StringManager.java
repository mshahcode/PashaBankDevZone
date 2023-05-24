package string.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringManager {
    private List<String> stringList = new ArrayList<>(); ;
    private Scanner scanner = new Scanner(System.in);;

    public StringManager() {

    }

    public void addStringsToList() {
        System.out.println("Enter strings (enter 'finish' to finish):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("finish")) {
                break;
            }

            stringList.add(input);
        }

        System.out.println("Strings added to the list:");
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        StringManager manager = new StringManager();
        manager.addStringsToList();
    }
}
