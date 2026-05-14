package exam3.dish.domain.entity;

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
}
