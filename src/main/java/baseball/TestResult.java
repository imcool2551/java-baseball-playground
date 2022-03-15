package baseball;

public class TestResult {

    private int strikes;
    private int balls;

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strikes += 1;
        }

        if (status.isBall()) {
            balls += 1;
        }
    }

    public boolean isGameOver() {
        return strikes == 3;
    }
}
