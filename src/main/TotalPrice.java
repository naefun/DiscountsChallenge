package main;

public class TotalPrice {
    float total;
    float deliveryCharge;

    public void addToTotal(float amountToAdd){
        this.total += amountToAdd;
        setDeliveryCharge(this.total);
    }

    private void setDeliveryCharge(float total){
        if(total >= 50){
            this.deliveryCharge = 0;
        }else{
            this.deliveryCharge = 7;
        }
    }

    public float getTotal() {
        return total;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }
}
