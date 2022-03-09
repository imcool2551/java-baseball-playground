package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String string = "(1,2)";
        String subString = string.substring(1, string.length() - 1);
        assertThat(subString).isEqualTo("1,2");
    }

    @DisplayName("chartAt() 은 인덱스를 벗어나면 StringIndexOutOfBoundsException 를 던진다")
    @Test
    void charAt() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }

}
