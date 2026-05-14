package exam3.dish.domain.service;

import exam3.dish.domain.entity.Dish;
import exam3.dish.exceptions.DishNotFoundException;
import exam3.dish.persistance.repository.DishRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DishServiceImplTest {
    DishRepository repository = Mockito.mock(DishRepository.class);
    DishService service = new DishServiceImpl(repository);

    @Nested
    class GetDishById {
        @Test
        void givenNonExistingDish_shouldThrowException(){
            when(repository.findById(1)).thenReturn(null);

            assertThrows(DishNotFoundException.class, () -> service.getDishById(1));

        }
        @Test
        void givenExistingDish_shouldReturnDish() throws DishNotFoundException {
            Dish expected = new Dish(1, "Pizza", 10.5);
            when(repository.findById(1)).thenReturn(expected);

            Dish actual = service.getDishById(1);

            assertSame(expected, actual);
        }
    }

    @Nested
    class Save {
        @Test
        void givenDish_shouldSaveDish(){
            Dish dish = new Dish(1, "Pizza", 10.5);

            service.save(dish);

            verify(repository).save(dish);
        }

        @Test
        void givenNull_shouldNotSaveDish(){
            service.save(null);

            verify(repository, never()).save(null);
        }
    }
}