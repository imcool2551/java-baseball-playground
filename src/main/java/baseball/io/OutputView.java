package baseball.io;

import baseball.domain.TestResult;

import java.util.Scanner;

public class OutputView {

    private final Scanner scanner;

    public OutputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printResult(TestResult result) {
        System.out.println(result);
    }

}
