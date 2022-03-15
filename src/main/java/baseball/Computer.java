package baseball;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Computer {

    private final String answer;

    public Computer() {
        answer = generateAnswer();
        System.out.println("answer = " + answer);
    }

    private String generateAnswer() {
        Set<Integer> st = randomNumberSetOfSize(3);
        return convertSetToString(st);
    }

    private Set<Integer> randomNumberSetOfSize(int size) {
        Random random = new Random();
        Set<Integer> integers = new LinkedHashSet<>();
        while (integers.size() < size) {
            integers.add(random.nextInt(9) + 1);
        }
        return integers;
    }

    private String convertSetToString(Set<Integer> integers) {
        StringBuilder sb = new StringBuilder();
        integers.stream()
                .forEach(sb::append);
        return sb.toString();
    }

    public Result submit(int guessed) {
        if (guessed < 100 || guessed > 999) {
            throw new IllegalArgumentException("100 ~ 999 까지의 숫자를 입력해주세요");
        }

        String guessedString = String.valueOf(guessed);
        return compare(answer, guessedString);
    }

    private Result compare(String answer, String submit) {
        int sameNumberCount = (int) answer.chars()
                .filter(i -> submit.contains(Integer.toString(i - '0')))
                .count();

        int strikes = (int) IntStream
                .range(0, answer.length())
                .filter(i -> answer.charAt(i) == submit.charAt(i))
                .count();

        return new Result(sameNumberCount - strikes, strikes);
    }

}
