package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ExpressionValidatorTest {

    @Test
    void validate() {
        String expression1 = "1 + 2 * 3";
        String expression2 = " 1 + 2 * 3 / 4 ";

        assertDoesNotThrow(() -> {
            ExpressionValidator.validate(expression1);
            ExpressionValidator.validate(expression2);
        });
    }


    @Test
    void validate_Throw_WhenInvalidExpression() {
        String expression1 = "1 + ";
        String expression2 = "1 + 2.0";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression1);
            ExpressionValidator.validate(expression2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_Throw_WhenInvalidOperand() {
        String expression = "1 + x";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_Throw_WhenInvalidOperator() {
        String expression = "1 ^ 3";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}