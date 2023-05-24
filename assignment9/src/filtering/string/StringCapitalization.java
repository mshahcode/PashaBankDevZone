package filtering.string;

import java.util.List;
import java.util.stream.Collectors;

public class StringCapitalization {
    public static void main(String[] args) {
        List<String> strings = List.of("bmw", "apple", "ant", "abc", "mercedes");

        FiltrationInterface filtrationInterface = string -> string.stream().filter(s -> s.startsWith("a") && s.length() == 3).collect(Collectors.toList());

        List<String> filteredStrings = filtrationInterface.filterStringArray(strings);
        System.out.println(filteredStrings);
    }
}


