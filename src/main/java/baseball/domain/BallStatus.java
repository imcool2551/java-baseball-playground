package baseball.domain;

public enum BallStatus {
    BALL, NOTHING, STRIKE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
