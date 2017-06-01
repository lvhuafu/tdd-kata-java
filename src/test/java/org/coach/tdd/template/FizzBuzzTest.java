package org.coach.tdd.template;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void shouldReturnTheNumberItselfGivenTheNumberCannotBeDivedByThreeOrFive() throws Exception {
        assertThat(fizzBuzz.calculate(1), is("1"));
    }

    @Test
    public void shouldReturnFizzGivenTheNumberCanBeDividedByThree() throws Exception {
        assertThat(fizzBuzz.calculate(3), is("Fizz"));
        assertThat(fizzBuzz.calculate(6), is("Fizz"));
        assertThat(fizzBuzz.calculate(9), is("Fizz"));
    }

    @Test
    public void shouldReturnBuzzGiveTheNumberCanBeDividedByFive() throws Exception {
        assertThat(fizzBuzz.calculate(5), is("Buzz"));
        assertThat(fizzBuzz.calculate(10), is("Buzz"));
        assertThat(fizzBuzz.calculate(20), is("Buzz"));
    }

    @Test
    public void shouldReturnFizzBuzzGivenTheNumberCanBeDividedByBothThreeAndFive() throws Exception {
        assertThat(fizzBuzz.calculate(15), is("FizzBuzz"));
        assertThat(fizzBuzz.calculate(30), is("FizzBuzz"));
        assertThat(fizzBuzz.calculate(45), is("FizzBuzz"));
    }

    @Test(expected = InvalidException.class)
    public void shouldThrowInvalidNumberExceptionGivenTheNumberIsZero() throws Exception {
        fizzBuzz.calculate(0);
    }
}
