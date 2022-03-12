package stringcalculator.exception;

public class InvalidOperandException extends RuntimeException {

    public InvalidOperandException() {
        super("잘못된 피연산자입니다.");
    }
}
