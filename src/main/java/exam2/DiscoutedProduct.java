package exam2;

public class DiscoutedProduct {
    private final String name;
    private double price;
    private double discount;

    public DiscoutedProduct(String name, double price, double discount) {
        this.name = name;
        this.price = Math.max(0, price);
        this.discount = Math.min(50, Math.max(0, discount));
    }

    public DiscoutedProduct(String name, double price) {
        this(name, price, 0);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
    }

    public void setDiscount(double discount) {
        if (discount >= 0 && discount <= 50)
            this.discount = discount;
    }

    public double getFinalPrice(){
        return this.price * (1 - this.discount / 100);
    }
}
