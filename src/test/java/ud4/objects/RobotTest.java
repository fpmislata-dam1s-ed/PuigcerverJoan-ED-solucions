package ud4.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    @Nested
    @DisplayName("Constructors")
    class ConstructorTests {
        @Test
        @DisplayName("Robot()")
        void testDefaultConstructor(){
            // Act
            Robot r = new Robot();

            // Assert
            assertAll(
                    () -> assertEquals(0, r.getX()),
                    () -> assertEquals(0, r.getY()),
                    () -> assertEquals(1, r.getSpeed())
            );
        }

        @Test
        @DisplayName("Robot(x, y)")
        void testConstructorWithPosition(){
            // Arrange
            double x = 10;
            double y = -10;

            // Act
            Robot r = new Robot(x, y);

            // Assert
            assertAll(
                    () -> assertEquals(x, r.getX()),
                    () -> assertEquals(y, r.getY()),
                    () -> assertEquals(1, r.getSpeed())
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0,0.5",
            "9.5,10.0",
            "9.7,10.0",
            "10.0,10.0",
    })
    void accelerate(double initialSpeed, double expectedSpeed){
        // Arrange
        Robot r = new Robot(0, 0, initialSpeed);

        // Act
        r.accelerate();

        // Assert
        assertEquals(expectedSpeed, r.getSpeed(), 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "0.1,0",
            "0.5,0",
            "10.0,9.5",
    })
    void decelerate(double initialSpeed, double expectedSpeed){
        // Arrange
        Robot r = new Robot(0, 0, initialSpeed);

        // Act
        r.decelerate();

        // Assert
        assertEquals(expectedSpeed, r.getSpeed(), 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "0,1,1",
            "1,1,2",
            "-2,1,-1",
    })
    void up(double y, double speed, double expectedY){
        Robot r = new Robot(0, y, speed);
        r.up();
        assertEquals(expectedY, r.getY());
    }
}