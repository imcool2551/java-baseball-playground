package baseball;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    private final int no;

    public BallNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException("볼의 숮자는 1~9 까지 허용 합니다");
        }
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
