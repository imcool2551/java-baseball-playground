package baseball.domain;

import java.util.Objects;

public class Ball {

    private final BallPosition position;
    private final BallNumber number;

    public Ball(int position, int no) {
        this.position = new BallPosition(position);
        this.number = new BallNumber(no);
    }

    public BallPosition getPosition() {
        return position;
    }

    public BallNumber getNumber() {
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
        boolean numberMatch = getNumber().equals(anotherBall.getNumber());
        boolean positionMatch = getPosition().equals(anotherBall.getPosition());
        return numberMatch && !positionMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(position, ball.position) && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
