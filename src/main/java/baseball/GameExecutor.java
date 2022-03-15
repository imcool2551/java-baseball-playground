package baseball;

import static baseball.Result.CORRECT;

public class GameExecutor {

    private InputView inputView;
    private OutputView outputView;
    private Computer computer;

    public GameExecutor() {
        inputView = new InputView();
        outputView = new OutputView();
        computer = new Computer();
    }

    public void execute() {
        while (true) {
            int guess = inputView.promptGuess();
            Result result = computer.submit(guess);
            outputView.print(result);
            handleResult(result);
        }
    }

    private void handleResult(Result result) {
        if (result.equals(CORRECT)) {
            int choice = inputView.promptChoice();
            resetComputerOrExitByChoice(choice);
        }
    }

    private void resetComputerOrExitByChoice(int choice) {
        if (choice == 1) {
            computer = new Computer();
            return;
        }

        if (choice == 2) {
            System.exit(0);
            return;
        }

        throw new IllegalArgumentException("1,2 중 하나를 선택해주세요");
    }

}
