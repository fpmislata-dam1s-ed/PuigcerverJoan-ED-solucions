package ud4.objects.shapes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Nested
    class ConstructorTests {
        @Test
        void constructorWithAllArgs(){
            // Arrange
            double x = 1;
            double y = 2;
            double width = 5;
            double height = 10;

            // Act
            Rectangle r = new Rectangle(x, y, width, height);

            // Assert
            assertAll(
                () -> assertEquals(x, r.getX()),
                () -> assertEquals(y, r.getY()),
                () -> assertEquals(width, r.getWidth()),
                () -> assertEquals(height, r.getHeight())
            );
        }
    }

    @ParameterizedTest(name="{0} x {1} = {2}")
    @CsvSource({
            "5,10,50",
            "0,0,0",
    })
    void area(double width, double height, double expected){
        // Arrange
        Rectangle r = new Rectangle(width, height);

        // Act
        double actual = r.getArea();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "({0},{1}).move({2},{3}) => ({4},{5})")
    @CsvSource({
            "0,0,0,0,0,0",
            "0,0,1,1,1,1",
            "0,0,-1,-1,-1,-1",
            "1,1,1,1,2,2",
            "1,1,-1,-1,0,0",
            "-1,-1,1,1,0,0",
            "-1,-1,-1,-1,-2,-2",
    })
    void move(double x, double y, double dx, double dy, double expectedX, double expectedY){
        // Arrange
        Rectangle r = new Rectangle(x, y, 10, 10);

        // Act
        r.move(dx, dy);

        // Assert
        assertEquals(expectedX, r.getX());
        assertEquals(expectedY, r.getY());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,2,2,1,1,true",
            "0,0,2,2,3,1,false",
            "0,0,2,2,-1,1,false",
            "0,0,2,2,1,3,false",
            "0,0,2,2,1,3,false",
            "2,0,2,2,3,1,true",
            "-2,0,2,2,-1,1,true",
            "0,2,2,2,1,3,true",
            "0,-2,2,2,1,-1,true",
    })
    void contains(double x, double y, double w, double h, double px, double py, boolean expected){
        Rectangle r = new Rectangle(x, y, w, h);
        boolean actual = r.contains(px, py);
        assertEquals(expected, actual);
    }
}