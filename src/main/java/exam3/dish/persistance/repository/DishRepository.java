package exam3.dish.persistance.repository;

import exam3.dish.domain.entity.Dish;

public interface DishRepository {
    Dish findById(int id);
    void save(Dish dish);
}
