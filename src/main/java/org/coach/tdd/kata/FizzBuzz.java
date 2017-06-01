package org.coach.tdd.kata;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String EMPTY = "";

    public String calculate(int number) {
        if (number <= 0) {
            throw new InvalidException(number);
        }

        String result = getFizz(number) + getBuzz(number);

        return result.isEmpty() ? valueOf(number) : result;
    }

    private String getBuzz(int number) {
        return number % 5 == 0 ? BUZZ : EMPTY;
    }

    private String getFizz(int number) {
        return number % 3 == 0 ? FIZZ : EMPTY;
    }
}
