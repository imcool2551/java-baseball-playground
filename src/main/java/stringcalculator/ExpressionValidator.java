package stringcalculator;

import stringcalculator.exception.EvenSizedExpressionException;
import stringcalculator.exception.InvalidOperandException;

public class ExpressionValidator {

    private ExpressionValidator() {
    }

    public static void validate(String expression) {
        String[] tokens = expression.trim().split(" ");
        validateTokens(tokens);
    }

    private static void validateTokens(String[] tokens) {
        validateSize(tokens);
        validateOperands(tokens);
        validateOperators(tokens);
    }

    private static void validateSize(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new EvenSizedExpressionException();
        }
    }

    private static void validateOperands(String[] tokens) {
        for (int i = 0; i < tokens.length; i = i + 2) {
            validateOperand(tokens[i]);
        }
    }

    private static void validateOperand(String operand) {
        if (operand == null || operand.isBlank()) {
            throw new InvalidOperandException();
        }

        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new InvalidOperandException();
        }
    }

    private static void validateOperators(String[] tokens) {
        for (int i = 1; i < tokens.length; i = i + 2) {
            validateOperator(tokens[i]);
        }
    }

    private static void validateOperator(String symbol) {
        Operator.findOperatorBySymbol(symbol);
    }
}
