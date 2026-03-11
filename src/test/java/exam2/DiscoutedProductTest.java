package exam2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DiscoutedProductTest {
    @Nested
    class Constructors{
        @Test
        void nameAndPrice(){
            String name = "Product1";
            double price = 10.0;

            DiscoutedProduct dp = new DiscoutedProduct(name, price);

            assertAll(
                    () -> assertEquals(name, dp.getName()),
                    () -> assertEquals(price, dp.getPrice()),
                    () -> assertEquals(0, dp.getDiscount())
            );
        }

        @Test
        void nameAndPriceNegative(){
            String name = "Product1";
            double price = -10.0;

            DiscoutedProduct dp = new DiscoutedProduct(name, price);

            assertAll(
                    () -> assertEquals(name, dp.getName()),
                    () -> assertEquals(0, dp.getPrice()),
                    () -> assertEquals(0, dp.getDiscount())
            );
        }

        @ParameterizedTest
        @CsvSource({
                "10,10,10,10",
                "-10,10,0,10",
                "10,-10,10,0",
                "10,60,10,50",
        })
        void allParams(double price, double discount, double expectedPrice, double expectedDiscount){
            String name = "Product1";
            DiscoutedProduct dp = new DiscoutedProduct(name, price, discount);

            assertAll(
                    () -> assertEquals(name, dp.getName()),
                    () -> assertEquals(expectedPrice, dp.getPrice()),
                    () -> assertEquals(expectedDiscount, dp.getDiscount())
            );
        }
    }

    @ParameterizedTest
    @CsvSource({
            "20,20",
            "-10,10",
            "0,0",
    })
    void setPrice(double price, double expectedPrice){
        DiscoutedProduct dp = new DiscoutedProduct("Product1", 10, 0);

        dp.setPrice(price);

        assertEquals(expectedPrice, dp.getPrice());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "20,20",
            "-10,10",
            "60,10",
    })
    void setDiscount(double discount, double expectedDiscount){
        DiscoutedProduct dp = new DiscoutedProduct("Product1", 10, 10);

        dp.setDiscount(discount);

        assertEquals(expectedDiscount, dp.getDiscount());
    }

    @ParameterizedTest
    @CsvSource({
            "100,0,100",
            "100,20,80",
            "50,20,40",
            "0,10,0",
    })
    void getFinalPrice(double price, double discount, double expectedFinalPrice){
        DiscoutedProduct dp = new DiscoutedProduct("Product1", price, discount);

        double finalPrice = dp.getFinalPrice();

        assertEquals(expectedFinalPrice, finalPrice);
    }
}