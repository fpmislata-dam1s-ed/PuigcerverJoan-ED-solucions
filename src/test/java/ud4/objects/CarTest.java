package ud4.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private final String PLATE = "0000 BBB";

    @Nested
    class Constructors {
        @Test
        @DisplayName("Car(plate)")
        void shouldCreateCarWithPlate(){
            // Arrange
            String plate = "0000 BBB";

            // Act
            Car car = new Car(plate);

            // Assert
            assertAll(
                    () -> assertEquals(plate, car.getPlate()),
                    () -> assertEquals(0, car.getKilometers()),
                    () -> assertEquals(0, car.getSpeed())
            );
        }

        @Test
        @DisplayName("Car(plate, kilometers)")
        void shouldCreateCarWithPlateAndKilometers(){
            // Arrange
            String plate = "0000 BBB";
            double kilometers = 50.5;

            // Act
            Car car = new Car(plate, kilometers);

            // Assert
            assertAll(
                    () -> assertEquals(plate, car.getPlate()),
                    () -> assertEquals(kilometers, car.getKilometers()),
                    () -> assertEquals(0, car.getSpeed())
            );
        }
    }

    @Nested
    @DisplayName("Car.accelerate(speed)")
    class AccelerateParamTests {
        @Test
        @DisplayName("0 accelerate(5) -> 5")
        void givenStoppedCar_shouldIncreaseVelocity(){
            // Arrange
            Car car = new Car(PLATE);

            // Act
            car.accelerate(5);

            // Assert
            assertEquals(5, car.getSpeed());
        }

        @Test
        @DisplayName("10 accelerate(10) -> 20")
        void givenMovingCar_shouldIncreaseVelocity(){
            // Arrange
            Car car = new Car(PLATE, 10, 0);

            // Act
            car.accelerate(10);

            // Assert
            assertEquals(20, car.getSpeed());
        }

        @Test
        @DisplayName("10 accelerate(-5) -> 10")
        void givenNegativeSpeed_shouldNotModifyCarSpeed(){
            // Arrange
            Car car = new Car(PLATE, 10, 0);

            // Act
            car.accelerate(-5);

            // Assert
            assertEquals(10, car.getSpeed());
        }
    }

    @Nested
    @DisplayName("Car.accelerate()")
    class AccelerateTests {
        @Test
        @DisplayName("0 accelerate() -> 5")
        void givenStoppedCar_shouldIncreaseVelocity(){
            // Arrange
            Car car = new Car(PLATE);

            // Act
            car.accelerate();

            // Assert
            assertEquals(5, car.getSpeed());
        }

        @Test
        @DisplayName("10 accelerate() -> 15")
        void givenMovingCar_shouldIncreaseVelocity(){
            // Arrange
            Car car = new Car(PLATE, 10, 0);

            // Act
            car.accelerate();

            // Assert
            assertEquals(15, car.getSpeed());
        }

        @Test
        @DisplayName("10 accelerate(-5) -> 10")
        void givenNegativeSpeed_shouldNotModifyCarSpeed(){
            // Arrange
            Car car = new Car(PLATE, 10, 0);

            // Act
            car.accelerate(-5);

            // Assert
            assertEquals(10, car.getSpeed());
        }
    }
}