package ro.upt;

public class DiscountCalculator {
    public double getDiscount (double price, boolean hasCoupon){
        if(price<0){
            throw new InvalidPriceException("Price is negative");
        }
        if(hasCoupon){
            return 30;
        }
        else if(price >=100.0){
            return 20;
        }
        else{
            return 0;
        }
    }
}
