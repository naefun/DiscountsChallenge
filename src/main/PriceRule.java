package main;

import java.security.InvalidParameterException;

public class PriceRule {
    int id;
    float price;
    Discount discount;

    public PriceRule(int id, float price, Discount discount) {
        if(id <= 0){
            throw new InvalidParameterException("Id has not been set / cannot be 0 or less");
        }
        this.id = id;
        this.price = price;
        this.discount = discount;
    }
}
