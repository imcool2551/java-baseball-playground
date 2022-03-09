package stringcalculator.operator;

public class BinaryOperatorFactory {

    private BinaryOperatorFactory() {
    }

    public static BinaryOperator create(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return new Plus(operand1, operand2);
        } else if (operator.equals("-")) {
            return new Minus(operand1, operand2);
        } else if (operator.equals("*")) {
            return new Product(operand1, operand2);
        } else if (operator.equals("/")) {
            return new Divide(operand1, operand2);
        }
        throw new UnsupportedOperationException("지원하지 않는 연산입니다");
    }
}
