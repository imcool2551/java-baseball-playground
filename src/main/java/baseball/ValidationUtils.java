package baseball;

public class ValidationUtils {

    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMatch(int number, int size) {
        if (number != size) {
            throw new IllegalArgumentException();
        }
    }
}
