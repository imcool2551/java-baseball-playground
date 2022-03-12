package stringcalculator;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    private Tokens tokens;

    public StringCalculator(String expression) {
        ExpressionValidator.validate(expression);
        this.tokens = transform(expression);
    }

    private Tokens transform(String expression) {
        String[] tokenArray = expression.trim().split(" ");
        List<String> tokenList = new LinkedList<>(List.of(tokenArray));
        return new Tokens(tokenList);
    }

    public int calculate() {
        while (onProcess()) {
            int operand1 = Integer.parseInt(tokens.get(0));
            int operand2 = Integer.parseInt(tokens.get(2));

            String symbol = tokens.get(1);
            Operator operator = Operator.findOperatorBySymbol(symbol);

            int result = operator.calculate(operand1, operand2);
            tokens.replaceFirstThreeWith(result);
        }

        return Integer.parseInt(tokens.get(0));
    }

    private boolean onProcess() {
        return tokens.size() >= 3;
    }
}
