package exam3.dish.domain.service;

import exam3.dish.domain.entity.Dish;
import exam3.dish.exceptions.DishNotFoundException;
import exam3.dish.persistance.repository.DishRepository;

public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish getDishById(int id) throws DishNotFoundException {
        Dish dish = this.dishRepository.findById(id);
        if (dish == null) {
            throw new DishNotFoundException("Dish with id " + id + " not found");
        }
        return dish;
    }

    @Override
    public void save(Dish dish) {
        if(dish != null)
            this.dishRepository.save(dish);
    }
}
