package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        ValidationUtils.validateRange(position, 1, 3);
        ValidationUtils.validateRange(number, 1, 9);
        this.position = position;
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public BallStatus test(Ball anotherBall) {
        if (this.equals(anotherBall)) {
            return BallStatus.STRIKE;
        }

        if (checkIfBallWith(anotherBall)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean checkIfBallWith(Ball anotherBall) {
        return getNumber() == anotherBall.getNumber() &&
                getPosition() != anotherBall.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
