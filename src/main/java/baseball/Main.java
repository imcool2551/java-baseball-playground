package baseball;

import baseball.domain.Balls;
import baseball.domain.TestResult;
import baseball.io.InputView;
import baseball.io.OutputView;

import java.util.*;

import static baseball.domain.BallNumber.MAX_NO;
import static baseball.domain.BallNumber.MIN_NO;
import static baseball.io.InputView.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static InputView inputView = new InputView(scanner);
    private static OutputView outputView = new OutputView(scanner);

    public static void main(String[] args) {
        Balls answerBalls = new Balls(generateRandom());

        while (true) {
            List<Integer> userGuess = mapToList(inputView.promptUserGuess());
            TestResult result = answerBalls.test(userGuess);
            outputView.printResult(result);
            answerBalls = handleGameOver(result, answerBalls);
        }
    }

    public static List<Integer> generateRandom() {
        Random rand = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < 3) {
            randomNumbers.add(rand.nextInt((MAX_NO - MIN_NO) + 1) + MIN_NO);
        }

        return new ArrayList<>(randomNumbers);
    }

    private static List<Integer> mapToList(int guess) {
        return List.of(guess / 100, guess / 10 % 10, guess % 10);
    }

    private static Balls handleGameOver(TestResult result, Balls answerBalls) {
        int menuChoice = inputView.promptMenuOnGameOver(result);

        if (menuChoice == RESUME_GAME) {
            return answerBalls;
        }

        if (menuChoice == NEW_GAME) {
            return new Balls(generateRandom());
        }

        if (menuChoice == EXIT_GAME) {
            System.exit(0);
        }

        return answerBalls;
    }
}
