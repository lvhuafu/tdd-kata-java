package org.coach.tdd.template;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";

    public String calculate(int number) {
        if (number % 3 == 0) {
            return FIZZ;
        }
        return valueOf(number);
    }
}
