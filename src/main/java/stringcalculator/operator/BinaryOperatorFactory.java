package stringcalculator.operator;

public class BinaryOperatorFactory {

    private BinaryOperatorFactory() {
    }

    public static BinaryOperator create(int operand1, int operand2, String operatorValue) {

        Operator operator = Operator.findByValue(operatorValue)
                .orElseThrow(() -> new IllegalArgumentException("처리할 수 없는 연산자입니다"));

        if (operator.equals(Operator.PLUS)) {
            return new Plus(operand1, operand2);
        } else if (operator.equals(Operator.MINUS)) {
            return new Minus(operand1, operand2);
        } else if (operator.equals(Operator.PRODUCT)) {
            return new Product(operand1, operand2);
        } else if (operator.equals(Operator.DIVIDE)) {
            return new Divide(operand1, operand2);
        }

        throw new IllegalArgumentException("처리할 수 없는 연산자입니다");
    }
}
