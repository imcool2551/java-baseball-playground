package stringcalculator;

import stringcalculator.exception.OperatorNotFoundException;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    PRODUCT("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private BinaryOperator<Integer> operation;

    Operator(String symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator findOperatorBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(OperatorNotFoundException::new);
    }

    public int calculate(int operand1, int operand2) {
        return operation.apply(operand1, operand2);
    }
}
