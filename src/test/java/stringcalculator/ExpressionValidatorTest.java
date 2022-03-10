package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionValidatorTest {

    @Test
    void exception_WhenInvalidExpression() {
        String expression = "1 + ";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exception_WhenInvalidOperand() {
        String expression = "1 + x";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exception_WhenInvalidOperator() {
        String expression = "1 ^ 3";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}