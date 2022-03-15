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

    public BallStatus test(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (isBall(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return getNumber() == ball.getNumber() &&
                getPosition() != ball.getPosition();
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
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
