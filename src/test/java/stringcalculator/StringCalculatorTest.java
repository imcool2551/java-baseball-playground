package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3 / 3 = 3"}, delimiter = '=')
    void execute(String expression, int result) {
        assertThat(StringCalculator.execute(expression))
                .isEqualTo(result);
    }
}