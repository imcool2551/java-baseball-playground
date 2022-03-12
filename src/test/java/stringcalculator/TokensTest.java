package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stringcalculator.exception.NotEnoughTokenException;

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

    @Test
    void replaceFirstThreeWith() {
        Tokens tokens = new Tokens(new ArrayList<>(List.of("1", "+", "3")));
        int initialSize = tokens.size(); // 3

        tokens.replaceFirstThreeWith(4);

        int afterSize = tokens.size(); // 1
        assertThat(initialSize - afterSize).isEqualTo(2);
    }

    @Test
    void replaceFirstThreeWith_Throw_WhenNotEnoughTokens() {
        Tokens tokens = new Tokens(new ArrayList<>(List.of("1")));

        assertThatThrownBy(() -> {
            tokens.replaceFirstThreeWith(1);
        }).isInstanceOf(NotEnoughTokenException.class);
    }


    private static Stream<Arguments> provideArgumentsForSizeTest() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "2"), 3),
                Arguments.of(List.of("1", "+", "2", "*", "3"), 5)
        );
    }
}