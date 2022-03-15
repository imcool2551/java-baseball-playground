package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;
    public Balls(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("볼의 길이는 3이어야 합니다");
        }
        this.balls = mapNumbersToBalls(numbers);
    }

    private static List<Ball> mapNumbersToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, numbers.get(i)));
        }
        return balls;
    }

    public TestResult test(List<Integer> submits) {
        TestResult result = new TestResult();
        Balls userBalls = new Balls(submits);

        for (Ball ball : balls) {
            BallStatus status = userBalls.test(ball);
            result.report(status);
        }

        return result;
    }

    private BallStatus test(Ball anotherBall) {
        return balls.stream()
                .map(ball -> ball.test(anotherBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
