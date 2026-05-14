package exam3.dish.persistance.repository;

import exam3.dish.domain.entity.Allergen;
import exam3.dish.domain.entity.Dish;
import exam3.dish.persistance.dao.AllergenDao;
import exam3.dish.persistance.dao.DishDao;

import java.util.List;

public class DishRepositoryImpl implements DishRepository {
    private final DishDao dishDao;
    private final AllergenDao allergenDao;

    public DishRepositoryImpl(DishDao dishDao, AllergenDao allergenDao) {
        this.dishDao = dishDao;
        this.allergenDao = allergenDao;
    }

    @Override
    public Dish findById(int id) {
        Dish dish = this.dishDao.findById(id);
        if (dish != null) {
            List<Allergen> allergens = this.allergenDao.findByDishId(id);
            dish.setAllergens(allergens);
        }
        return dish;
    }

    @Override
    public void save(Dish dish) {
        Dish existingDish = this.dishDao.findById(dish.getId());
        if (existingDish == null) {
            this.dishDao.insert(dish);
        } else {
            this.dishDao.update(dish);
        }
    }
}
