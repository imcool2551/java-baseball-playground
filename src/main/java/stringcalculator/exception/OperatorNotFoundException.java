package stringcalculator.exception;

public class OperatorNotFoundException extends RuntimeException{

    public OperatorNotFoundException() {
        super("처리할 수 없는 연산자입니다.");
    }
}
