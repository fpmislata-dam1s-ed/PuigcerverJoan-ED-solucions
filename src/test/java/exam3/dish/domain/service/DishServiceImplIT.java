package exam3.dish.domain.service;

import exam3.dish.domain.entity.Allergen;
import exam3.dish.domain.entity.Dish;
import exam3.dish.exceptions.DishNotFoundException;
import exam3.dish.persistance.dao.AllergenDaoJdbc;
import exam3.dish.persistance.dao.DishDaoJdbc;
import exam3.dish.persistance.repository.DishRepository;
import exam3.dish.persistance.repository.DishRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DishServiceImplIT {
    DishRepository repository = new DishRepositoryImpl(
            new DishDaoJdbc(),
            new AllergenDaoJdbc()
    );
    DishService service = new DishServiceImpl(repository);

    @BeforeAll
    static void setup() throws SQLException {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.executeScript("sql/dish/schema.sql");
        connection.executeScript("sql/dish/data.sql");
        connection.setAutoCommit(false);
    }

    @AfterEach
    void rollback() throws SQLException {
        DatabaseConnection.getInstance().rollback();
    }

    @Nested
    class GetDishById {
        @Test
        void givenNonExistingDish_shouldThrowException(){
            assertThrows(DishNotFoundException.class, () -> service.getDishById(-1));

        }
        @Test
        void givenExistingDish_shouldReturnDish() throws DishNotFoundException {
            Dish expected = new Dish(1, "Spaghetti Carbonara", 12.50);
            List<Allergen> allergens = new ArrayList<>();
            allergens.add(new Allergen(1, "Gluten"));
            allergens.add(new Allergen(2, "Dairy"));
            allergens.add(new Allergen(3, "Eggs"));
            expected.setAllergens(allergens);

            Dish actual = service.getDishById(1);

            assertEquals(expected, actual);
        }
    }

    @Nested
    class Save {
        @Test
        void givenDish_shouldSaveDish() throws DishNotFoundException {
            Dish dish = new Dish(4, "Pizza", 10.5);

            service.save(dish);
            Dish actual = service.getDishById(4);

            assertEquals(dish, actual);
        }

        @Test
        void givenNull_shouldNotSaveDish(){
            service.save(null);
        }
    }
}