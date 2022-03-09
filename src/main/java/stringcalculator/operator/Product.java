package stringcalculator.operator;

public class Product extends BinaryOperator {

    public Product(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public int calculate() {
        return operand1 * operand2;
    }
}
