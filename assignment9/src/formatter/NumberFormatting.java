package formatter;

import java.util.List;
import java.util.stream.Collectors;

public class NumberFormatting {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 44, 7, 20, 12);

        INumberFormatter iNumberFormatter = numberList -> numberList.stream()
                .map(number -> (number % 2 == 0 ? "e" : "o") + number.toString())
                .collect(Collectors.joining(","));

        String formattedNumbers = iNumberFormatter.formatNumbers(numbers);
        System.out.println(formattedNumbers);
    }
}
