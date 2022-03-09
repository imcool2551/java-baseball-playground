package stringcalculator;

import stringcalculator.operator.BinaryOperator;
import stringcalculator.operator.BinaryOperatorFactory;

import java.util.List;

public class Tokens {

    private final List<String> tokens;

    public Tokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public int size() {
        return tokens.size();
    }

    public int result() {
        if (tokens.size() != 1) {
            throw new IllegalStateException("계산이 완료되지 않았습니다");
        }

        return Integer.parseInt(tokens.get(0));
    }

    public void calculateFirstThree() {
        if (size() < 3) {
            throw new IllegalStateException("토큰의 개수가 세 개 미만입니다");
        }
        int operand1 = Integer.parseInt(tokens.get(0));
        int operand2 = Integer.parseInt(tokens.get(2));
        String operator = tokens.get(1);

        BinaryOperator binaryOperator =
                BinaryOperatorFactory.create(operand1, operand2, operator);

        int result = binaryOperator.calculate();
        replaceFirstThree(result);
    }

    private void replaceFirstThree(int result) {
        if (size() < 3) {
            throw new IllegalStateException("토큰의 개수가 세 개 미만입니다");
        }

        tokens.subList(0, 3).clear();
        tokens.add(0, String.valueOf(result));
    }

}
