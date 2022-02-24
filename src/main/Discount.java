package main;

public class Discount {
    int itemsNeeded;
    float discountPrice;

    public Discount(int itemsNeeded, float discountPrice) {
        this.itemsNeeded = itemsNeeded;
        this.discountPrice = discountPrice;
    }

    public int getItemsNeeded() {
        return itemsNeeded;
    }

    public void setItemsNeeded(int itemsNeeded) {
        this.itemsNeeded = itemsNeeded;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }
}
