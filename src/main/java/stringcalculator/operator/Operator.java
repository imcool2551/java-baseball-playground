package stringcalculator.operator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    PRODUCT("*"),
    DIVIDE("/");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static Optional<Operator> findByValue(String value) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getValue().equals(value))
                .findFirst();
    }

    public String getValue() {
        return value;
    }
}
