package exam3.dish.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dish {
    private final int id;
    private final String name;
    private final double price;
    List<Allergen> allergens;

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.allergens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && Double.compare(price, dish.price) == 0 && Objects.equals(name, dish.name) && Objects.equals(allergens, dish.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, allergens);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", allergens=" + allergens +
                '}';
    }
}
