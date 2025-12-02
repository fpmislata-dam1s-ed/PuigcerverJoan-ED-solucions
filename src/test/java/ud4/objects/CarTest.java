package ud4.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final String PLATE = "0000 BBB";
    @Nested
    class ConstructorTests {
        @Test
        void testConstructorWithAllParameters(){
            // Arrange
            int kilometers = 100;

            // Act
            Car car = new Car(PLATE, kilometers);

            // Assert
            assertAll(
                () -> assertEquals(PLATE, car.getPlate()),
                () -> assertEquals(kilometers, car.getKilometers()),
                () -> assertEquals(0, car.getSpeed())
            );
        }

        @Test
        void testConstructorWithAllParametersNegativeKilometersShouldBe0(){
            // Arrange
            int kilometers = -100;

            // Act
            Car car = new Car(PLATE, kilometers);

            // Assert
            assertAll(
                    () -> assertEquals(PLATE, car.getPlate()),
                    () -> assertEquals(0, car.getKilometers()),
                    () -> assertEquals(0, car.getSpeed())
            );
        }

        @Test
        void testConstructorWithPlate(){
            // Act
            Car car = new Car(PLATE);

            // Assert
            assertAll(
                    () -> assertEquals(PLATE, car.getPlate()),
                    () -> assertEquals(0, car.getKilometers()),
                    () -> assertEquals(0, car.getSpeed())
            );
        }
    }

    @Nested
    class AccelerateTests {
        private Car car;

        @BeforeEach
        void setup(){
            car = new Car(PLATE);
        }

        @Test
        void test(){
            // Act
            car.accelerate();

            // Assert
            assertEquals(5, car.getSpeed());
        }

        @Test
        void testMultipleAccelerate(){
            // Act
            car.accelerate();
            car.accelerate();
            car.accelerate();

            // Assert
            assertEquals(15, car.getSpeed());
        }
    }
}