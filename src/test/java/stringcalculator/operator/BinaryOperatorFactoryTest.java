package stringcalculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BinaryOperatorFactoryTest {

    @DisplayName("Operator 를 통해 BinaryOperator 생성")
    @ParameterizedTest
    @EnumSource(Operator.class)
    void create(Operator operator) {
        assertDoesNotThrow(() -> {
            BinaryOperatorFactory.create(1, 1, operator.getValue());
        });
    }

    @DisplayName("Operator 에 없는 연산자를 통해 BinaryOperator 생성 시도시 예외")
    @Test
    void create_Throw_WhenCreatingOperatorWithUnknownOperator() {
        assertThatThrownBy(() -> {
            BinaryOperatorFactory.create(1, 1, "^");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 으로 나누는 BinaryOperator 생성 시도시 예외")
    @Test
    void create_Throw_WhenCreatingDivideOperatorWithZeroOperand() {
        int operand1 = 1;
        int operand2 = 0;

        assertThatThrownBy(() -> {
            BinaryOperatorFactory.create(operand1, operand2, "/");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}