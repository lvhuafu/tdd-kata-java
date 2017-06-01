package org.coach.tdd.template;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FizzBuzzTest {
    @Test
    public void shouldReturnTheNumberItselfGivenTheNumberCannotBeDivedByThreeOrFive() throws Exception {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.calculate(1), is("1"));
    }
}
