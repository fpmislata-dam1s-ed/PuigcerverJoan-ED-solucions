package exam3.dish.persistance.dao;

import exam3.dish.domain.entity.Allergen;

import java.util.List;

public interface AllergenDao {
    List<Allergen> findByDishId(int dishId);
}
