package main;

public class Item {
    int id;
    float price;
    Discount discount;

    public Item(int id, float price, Discount discount) {
        this.id = id;
        this.price = price;
        this.discount = discount;

        ItemCatalogue.addItem(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
