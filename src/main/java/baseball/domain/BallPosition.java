package baseball.domain;

import java.util.Objects;

public class BallPosition {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;

    private final int position;

    public BallPosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("볼의 위치는 1~3 까지 허용합니다");
        }

        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
