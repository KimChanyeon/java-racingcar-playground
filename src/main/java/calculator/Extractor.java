package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public static final String BASIC_DELIMITER = ",|:";
    public static final String LINE_BREAK = "\n";

    final String input;

    public Extractor(String input) {
        this.input = input;
    }

    public List<Integer> extractNumbers() {
        String[] tokens = makeTokens();
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            validCheckAndAdd(token, numbers);
        }
        return numbers;
    }

    private String[] makeTokens() {
        String delimiter = extractDelimiter();
        if (!delimiter.equals(BASIC_DELIMITER)) {
            return input.substring(input.indexOf(LINE_BREAK) + LINE_BREAK.length()).split(delimiter);
        }
        return input.split(delimiter);
    }

    private static void validCheckAndAdd(String token, List<Integer> numbers) {
        if (!validToken(token)) {
            throw new IllegalArgumentException("Invalid token: " + token);
        }
        numbers.add(Integer.parseInt(token));
    }

    private static boolean validToken(String token) {
        return Character.isDigit(token.charAt(0)) && Character.digit(token.charAt(0), 10) >= 0;
    }

    String extractDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }

        return BASIC_DELIMITER;
    }
}
