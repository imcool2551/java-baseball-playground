package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {


    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3 / 3 = 3"}, delimiter = '=')
    void calculate(String expression, int result) {
        StringCalculator calculator = new StringCalculator(expression);

        assertThat(calculator.calculate())
                .isEqualTo(result);
    }
}