package baseball;

public class TestResult {

    private final int strikes;
    private final int balls;

    public TestResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
