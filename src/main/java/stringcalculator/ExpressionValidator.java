package stringcalculator;

import stringcalculator.operator.Operator;

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
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }
    }

    private static void validateOperands(String[] tokens) {
        for (int i = 0; i < tokens.length; i = i + 2) {
            validateOperand(tokens[i]);
        }
    }

    private static void validateOperand(String operand) {
        if (operand == null || operand.isBlank()) {
            throw new IllegalArgumentException("처리할 수 없는 피연산자입니다.");
        }

        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("처리할 수 없는 피연산자입니다.");
        }
    }

    private static void validateOperators(String[] tokens) {
        for (int i = 1; i < tokens.length; i = i + 2) {
            validateOperator(tokens[i]);
        }
    }

    private static void validateOperator(String value) {
        Operator.findByValue(value)
                .orElseThrow(() -> new IllegalArgumentException("처리할 수 없는 연산자입니다"));
    }
}
