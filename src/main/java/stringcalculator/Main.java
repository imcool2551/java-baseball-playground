package stringcalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        StringCalculator calculator = new StringCalculator(expression);
        int result = calculator.calculate();
        System.out.println("연산 결과 = " + result);
    }
}
