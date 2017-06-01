package org.coach.tdd.template;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public String calculate(int number) {
        String result = valueOf(number);

        if (number % 3 == 0 && number % 5 == 0) {
            return FIZZ + BUZZ;
        }
        if (number % 3 == 0) {
            result = FIZZ;
        }
        if (number % 5 == 0) {
            result = BUZZ;
        }

        return result;
    }
}
