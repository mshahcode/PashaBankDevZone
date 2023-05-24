package generics.manager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericsManager genericsManager = new GenericsManager();
        List<String> stringList = Arrays.asList("bmw", "mercedes", "toyota");
        String targetString = "bmw";
        System.out.println("Contains string: " + genericsManager.containsVariable(stringList,targetString));
    }
}
