package stringcalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

    private StringCalculator() {
    }
    public static int execute(String expression) {
        ExpressionValidator.validate(expression);
        Tokens tokens = transform(expression);
        return calculate(tokens);
    }

    private static Tokens transform(String expression) {
        String[] tokenArray = expression.trim().split(" ");
        List<String> tokenList = new LinkedList<>(Arrays.asList(tokenArray));
        return new Tokens(tokenList);
    }

    private static int calculate(Tokens tokens) {
        while (tokens.size() > 1) {
            tokens.calculateFirstThree();
        }

        return tokens.result();
    }

}
