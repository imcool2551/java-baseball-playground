package baseball;

public class ValidationUtils {

    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(min + "부터 " + max + " 까지 허용합니다.");
        }
    }
}
