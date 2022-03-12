package stringcalculator.exception;

public class EvenSizedExpressionException extends RuntimeException {

    public EvenSizedExpressionException() {
        super("계산식의 (피연산자 + 연산자)는 홀수개 여야합니다.");
    }
}
