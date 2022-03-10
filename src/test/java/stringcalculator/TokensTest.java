package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokensTest {

    @ParameterizedTest
    @MethodSource("provideArgumentsForSizeTest")
    void size(List<String> strings, int size) {
        Tokens tokens = new Tokens(strings);
        assertThat(tokens.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @MethodSource("provideListForResultTest")
    void result(List<String> strings, int result) {
        Tokens tokens = new Tokens(strings);
        assertThat(tokens.result()).isEqualTo(result);
    }

    @Test
    void result_Throw_WhenTokensSizeNot1() {
        List<String> strings = List.of("1", "+", "2");
        Tokens tokens = new Tokens(strings);
        assertThatThrownBy(() -> {
            tokens.result();
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void calculateFirstThree() {
        List<String> strings = new ArrayList<>(List.of("1", "+", "2"));
        Tokens tokens = new Tokens(strings);

        int initialSize = tokens.size();
        tokens.calculateFirstThree();
        int afterSize = tokens.size();

        assertThat(initialSize - afterSize).isEqualTo(2);
    }

    @Test
    void calculateFirstThree_Throw_WhenTokenSizeLessThan3() {
        List<String> strings = new ArrayList<>(List.of("1", "+"));
        Tokens tokens = new Tokens(strings);

        assertThatThrownBy(() -> {
            tokens.calculateFirstThree();
        }).isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> provideArgumentsForSizeTest() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "2"), 3),
                Arguments.of(List.of("1", "+", "2", "*", "3"), 5)
        );
    }

    private static Stream<Arguments> provideListForResultTest() {
        return Stream.of(
                Arguments.of(List.of("1"), 1),
                Arguments.of(List.of("3"), 3)
        );
    }


}