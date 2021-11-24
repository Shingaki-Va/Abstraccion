package subClass;

import superClass.Product;

public class Toy extends Product {
    //ATRIBUTES
    private boolean hasDiscount;

    //CONSTRUCTOR
    public Toy() {
    }

    //SETTER
    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    //METHOD
    @Override
    public void CalculateDiscount() {
        if (hasDiscount) {
            this.setDiscount((float) (this.getPrice() * 0.25));
        } else {
            this.setDiscount(0);
        }
    }


}
