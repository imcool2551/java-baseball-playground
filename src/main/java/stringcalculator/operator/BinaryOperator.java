package stringcalculator.operator;

public abstract class BinaryOperator {

    protected int operand1;
    protected int operand2;

    protected BinaryOperator(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    abstract public int calculate();
}
