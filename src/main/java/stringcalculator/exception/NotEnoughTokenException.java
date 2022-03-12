package stringcalculator.exception;

public class NotEnoughTokenException extends RuntimeException{

    public NotEnoughTokenException() {
        super("토큰의 개수가 부족합니다.");
    }
}
