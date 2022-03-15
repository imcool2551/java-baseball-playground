package baseball;

import static baseball.Result.*;

public class OutputView {

    public void print(Result result) {
        System.out.println(result);
        if (result.equals(CORRECT)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
