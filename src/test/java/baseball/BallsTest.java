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
    void 볼즈_생성_성공() {
        assertDoesNotThrow(() -> {
            new Balls(List.of(1, 2, 3));
        });
    }

    @Test
    void 볼즈_생성_실패() {
        assertThatThrownBy(() -> {
            new Balls(List.of(1, 2));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단일_스트라이크() {
        BallStatus status = balls.test(new Ball(1, 1));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 단일_볼() {
        BallStatus status = balls.test(new Ball(2, 1));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 단일_나띵() {
        BallStatus status = balls.test(new Ball(1, 4));

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
