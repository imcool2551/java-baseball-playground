package stringcalculator.operator;

public class Divide extends BinaryOperator {

    public Divide(int operand1, int operand2) {
        super(operand1, operand2);
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
    }

    @Override
    public int calculate() {
        return operand1 / operand2;
    }
}
