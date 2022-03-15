package baseball.io;

import baseball.domain.TestResult;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final int MIN_GUESS = 100;
    public static final int MAX_GUESS = 999;
    public static final int RESUME_GAME = -1;
    public static final int NEW_GAME = 1;
    public static final int EXIT_GAME = 2;
    public static final List<Integer> POSSIBLE_MENU =
            List.of(RESUME_GAME, NEW_GAME, EXIT_GAME);
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptUserGuess() {
        System.out.print("숫자를 입력해 주세요: ");
        int guess = scanner.nextInt();

        if (guess < MIN_GUESS || guess > MAX_GUESS) {
            throw new IllegalArgumentException("숫자는 100~999 까지 허용합니다");
        }

        return guess;
    }

    public int promptMenuOnGameOver(TestResult result) {
        int menu = RESUME_GAME;

        if (result.isGameOver()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요");
            menu = scanner.nextInt();
        }

        if (!POSSIBLE_MENU.contains(menu)) {
            throw new IllegalArgumentException("선택 가능한 메뉴는 1, 2 입니다");
        }

        return menu;
    }
}
