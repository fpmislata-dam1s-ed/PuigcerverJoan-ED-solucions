package ud4.objects.shapes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Nested
    class ConstructorsTests {
        @Test
        void defaultConstructor(){
            Rectangle r = new Rectangle();

            assertAll(
                    () -> assertEquals(0, r.getX()),
                    () -> assertEquals(0, r.getY()),
                    () -> assertEquals(1, r.getWidth()),
                    () -> assertEquals(1, r.getHeight())
            );
        }

        @Test
        void widthAndHeightConstructor(){
            double width = 5;
            double height = 10;
            Rectangle r = new Rectangle(width, height);

            assertAll(
                    () -> assertEquals(0, r.getX()),
                    () -> assertEquals(0, r.getY()),
                    () -> assertEquals(width, r.getWidth()),
                    () -> assertEquals(height, r.getHeight())
            );
        }

        @Test
        void allParameters(){
            double x = 1;
            double y = 2;
            double width = 5;
            double height = 10;
            Rectangle r = new Rectangle(x, y, width, height);

            assertAll(
                    () -> assertEquals(x, r.getX()),
                    () -> assertEquals(y, r.getY()),
                    () -> assertEquals(width, r.getWidth()),
                    () -> assertEquals(height, r.getHeight())
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "8,5,40",
    })
    void area(double width, double height, double expected){
        Rectangle r = new Rectangle(width, height);
        double actual = r.getArea();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "8,5,26",
    })
    void perimeter(double width, double height, double expected){
        Rectangle r = new Rectangle(width, height);
        double actual = r.getPerimeter();
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "0,0,2,2,1,1,true",
            "0,0,2,2,3,1,false",
            "0,0,2,2,1,3,false",
    })
    void contains(double x1, double y1, double width, double height, double x2, double y2, boolean expected){
        Rectangle r = new Rectangle(x1, y1, width, height);
        boolean actual = r.contains(x2, y2);
        assertEquals(expected, actual);
    }

}