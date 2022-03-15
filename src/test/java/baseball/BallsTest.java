package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallsTest {

    Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(List.of(1, 2, 3));
    }

    @Test
    void 생성_성공() {
        assertDoesNotThrow(() -> {
            new Balls(List.of(1, 2, 3));
        });
    }

    @Test
    void 생성_실패() {
        assertThatThrownBy(() -> {
            new Balls(List.of(1, 2));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크0_볼0() {
        TestResult result = balls.test(List.of(4, 5, 6));

        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    void 스트라이크1_볼0() {
        TestResult result = balls.test(List.of(1, 5, 6));

        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    void 스트라이크0_볼1() {
        TestResult result = balls.test(List.of(4, 5, 1));

        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(1);
    }

    @Test
    void 스트라이크3() {
        TestResult result = balls.test(List.of(1, 2, 3));

        assertThat(result.getStrikes()).isEqualTo(3);
        assertThat(result.getBalls()).isEqualTo(0);
        assertThat(result.isGameOver()).isTrue();
    }
}
