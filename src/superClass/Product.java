package superClass;

public abstract class Product {

    //ATRIBUTES
    private float discount;
    private float price;
    private String name;
    private int quantity;

    //CONSTRUCTOR
    public Product() {
    }

    //GETTERS AND SETTERS
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //ABSTRACT METHOD
    public abstract void CalculateDiscount();

    @Override
    public String toString() {
        return "-" + name + " $" + price + " (" + quantity + "u) | total $" + quantity * price ;
    }
}


