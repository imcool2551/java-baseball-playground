package stringcalculator.operator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OperatorTest {

    @ParameterizedTest
    @EnumSource(Operator.class)
    void findByValue(Operator operator) {
        assertDoesNotThrow(() -> {
            Operator.findByValue(operator.getValue())
                    .orElseThrow();
        });
    }

    @Test
    void findByValue_Throw_WhenNotFound() {
        assertThatThrownBy(() -> {
            String invalidOperatorValue = "^";
            Operator.findByValue(invalidOperatorValue)
                    .orElseThrow();
        }).isInstanceOf(NoSuchElementException.class);
    }
}