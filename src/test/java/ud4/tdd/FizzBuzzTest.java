package ud4.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    @DisplayName("FizzBuzz class should exist")
    void fizzBuzzClassShouldExist() {
        FizzBuzz fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("FizzBuzz::transform() method should have an int parameter")
    void fizzBuzzTransformMethodShouldHaveIntParameter() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.transform(1);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "5,Buzz",
            "6,Fizz",
            "10,Buzz",
            "15,FizzBuzz",
            "30,FizzBuzz",
            "7,Tozz",
            "14,Tozz",
            "21,FizzTozz",
            "42,FizzTozz",
            "35,BuzzTozz",
            "70,BuzzTozz",
            "105,FizzBuzzTozz",
    })
    void transform(int n, String expected){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.transform2(n);
        assertEquals(actual, expected);
    }
}
