package stringcalculator.operator;

public class Plus extends BinaryOperator {

    public Plus(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 + operand2;
    }
}
