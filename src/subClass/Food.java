package subClass;

import superClass.Product;

import java.util.Calendar;

public class Food extends Product {

    //CONSTRUCTOR
    public Food() {
    }

    //METHOD
    @Override
    public void CalculateDiscount() {
        Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            this.setDiscount((float) (this.getPrice() * 0.15));
        } else {
            this.setDiscount(0);
        }
    }

}
