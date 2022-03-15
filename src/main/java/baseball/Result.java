package baseball;

import java.util.Objects;

public class Result {

    public static final Result CORRECT = new Result(0, 3);
    private final int balls;
    private final int strikes;

    public Result(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return balls == result.balls && strikes == result.strikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, strikes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (balls == 0 && strikes == 0) {
            sb.append("NOTHING");
        }

        if (balls > 0) {
            sb.append(balls + "볼 ");
        }

        if (strikes > 0) {
            sb.append(strikes + "스트라이크 ");
        }

        return sb.toString();
    }
}
