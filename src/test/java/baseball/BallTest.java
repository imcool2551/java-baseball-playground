package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallTest {

    Ball ball = new Ball(1, 1);

    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,9", "3,1", "3,9"}, delimiter = ',')
    void 공_생성_테스트_성공(int position, int number) {
        assertDoesNotThrow(() -> {
            new Ball(position, number);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "0,10", "4,0", "4,10"}, delimiter = ',')
    void 공_생성_테스트_실패(int position, int number) {
        assertThatThrownBy(() -> {
            new Ball(position, number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크() {
        Ball anotherBall = new Ball(1, 1);

        assertThat(ball.test(anotherBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Ball anotherBall = new Ball(2, 1);

        assertThat(ball.test(anotherBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 나띵() {
        Ball anotherBall = new Ball(2, 2);

        assertThat(ball.test(anotherBall)).isEqualTo(BallStatus.NOTHING);
    }

}
