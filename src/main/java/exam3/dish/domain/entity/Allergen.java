package exam3.dish.domain.entity;

import java.util.Objects;

public class Allergen {
    private int id;
    private String name;

    public Allergen() {
    }

    public Allergen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Allergen(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergen allergen = (Allergen) o;
        return id == allergen.id && Objects.equals(name, allergen.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Allergen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
