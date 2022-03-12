package stringcalculator;

import org.junit.jupiter.api.Test;
import stringcalculator.exception.EvenSizedExpressionException;
import stringcalculator.exception.InvalidOperandException;
import stringcalculator.exception.OperatorNotFoundException;

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
        String expression = "1 +";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(EvenSizedExpressionException.class);
    }

    @Test
    void validate_Throw_WhenInvalidOperand() {
        String expression = "1 + 2 + x";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(InvalidOperandException.class);
    }

    @Test
    void validate_Throw_WhenInvalidOperator() {
        String expression = "1 ^ 3";

        assertThatThrownBy(() -> {
            ExpressionValidator.validate(expression);
        }).isInstanceOf(OperatorNotFoundException.class);
    }
}