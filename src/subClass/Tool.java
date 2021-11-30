package subClass;

import superClass.Product;

public class Tool extends Product {
    //ATRIBUTES
    private boolean payWithCC;

    //CONSTRUCTOR
    public Tool() {
    }

    //GETTER AND SETTERS
    public void setPayWithCC(boolean payWithCC) {
        this.payWithCC = payWithCC;
    }

    //METHOD
    @Override
    public void CalculateDiscount() {
        if (payWithCC) {
            this.setDiscount((float) (this.getPrice() * 0.05));
        } else this.setDiscount(0);
    }


}
