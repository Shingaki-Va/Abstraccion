package subClass;

import superClass.Product;

import java.util.Objects;

public class Clothe extends Product {
    private String Type;

    public Clothe() {
    }

    //GETTER AND SETTERS
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    //METHOD
    @Override
    public void CalculateDiscount() {
        if (Objects.equals(this.getType(), "W") || Objects.equals(this.getType(), "K")) {
            this.setDiscount((float) (this.getPrice() * 0.15));
        } else {
            this.setDiscount(0);
        }
    }

}
