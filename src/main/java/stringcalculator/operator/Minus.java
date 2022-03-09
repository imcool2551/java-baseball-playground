package stringcalculator.operator;

public class Minus extends BinaryOperator {

    public Minus(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 - operand2;
    }
}
