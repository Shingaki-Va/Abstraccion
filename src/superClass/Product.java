package superClass;

public abstract class Product {

    //ATRIBUTES
    private float discount;
    private float price;
    private String name;
    private int Quantity;

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
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    //ABSTRACT METHOD
    public abstract void CalculateDiscount();


}


