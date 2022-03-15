package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * 1, 1     2, 2,     3,3
 * 2, 2 -> STRIKE
 * 2, 3 -> BALL
 * 2, 7 -> NOTHING
 */
public class Balls {

    private final List<Ball> balls;
    public Balls(List<Integer> numbers) {
        ValidationUtils.validateMatch(numbers.size(), 3);
        this.balls = mapNumbersToBalls(numbers);
    }

    private static List<Ball> mapNumbersToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public BallStatus test(Ball anotherBall) {
        return balls.stream()
                .map(ball -> ball.test(anotherBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
