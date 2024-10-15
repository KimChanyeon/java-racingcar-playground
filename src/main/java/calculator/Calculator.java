package calculator;

import java.util.List;

public class Calculator {

    public static int splitAndSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        Extractor extractor = new Extractor(input);
        List<Integer> numbers = extractor.extractNumbers();
        return getSum(numbers);
    }

    public static int getSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
