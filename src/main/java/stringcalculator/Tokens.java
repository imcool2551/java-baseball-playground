package stringcalculator;

import stringcalculator.exception.NotEnoughTokenException;

import java.util.List;

public class Tokens {

    private final List<String> tokens;

    public Tokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public String get(int index) {
        return tokens.get(index);
    }

    public int size() {
        return tokens.size();
    }

    public void replaceFirstThreeWith(int result) {
        if (size() < 3) {
            throw new NotEnoughTokenException();
        }

        tokens.subList(0, 3).clear();
        tokens.add(0, String.valueOf(result));
    }

}
