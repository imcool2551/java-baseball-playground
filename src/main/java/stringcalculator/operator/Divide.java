package stringcalculator.operator;

public class Divide extends BinaryOperator {

    public Divide(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 / operand2;
    }
}
