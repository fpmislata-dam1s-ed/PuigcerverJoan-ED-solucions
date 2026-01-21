package ud4.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void classShouldExist(){
        FizzBuzz fb = new FizzBuzz();
    }

    @Test
    void transformShouldHaveIntParameter(){
        FizzBuzz fb = new FizzBuzz();
        fb.transform(3);
    }

    @Test
    void transformShouldReturnString(){
        FizzBuzz fb = new FizzBuzz();
        String result = fb.transform(3);
    }

    @ParameterizedTest(name = "transform({0}) => {1}")
    @CsvSource({
            "1,1",
            "3,Fizz",
            "5,Buzz",
            "15,FizzBuzz",
            "7,Tozz",
            "21,FizzTozz",
            "35,BuzzTozz",
            "105,FizzBuzzTozz",
    })
    void transform(int n, String expected){
        FizzBuzz fb = new FizzBuzz();
        String result = fb.transform(n);
        assertEquals(expected, result);
    }
}
