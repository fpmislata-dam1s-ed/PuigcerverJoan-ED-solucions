package exam3.dish.domain.service;

import exam3.dish.domain.entity.Dish;
import exam3.dish.exceptions.DishNotFoundException;

public interface DishService {
    Dish getDishById(int id) throws DishNotFoundException;
    void save(Dish dish);
}
