package exam3.dish.persistance.dao;

import exam3.dish.domain.entity.Dish;

public interface DishDao {
    Dish findById(int id);
    int insert(Dish dish);
    int update(Dish dish);
}
