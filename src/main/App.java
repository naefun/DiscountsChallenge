package main;

public class App {
    public static void main(String[] args) {

        PricingRules pricingRules = generatePricingRules();
        UnidaysDiscountChallenge example = new UnidaysDiscountChallenge(pricingRules);

        example.addToBasket(ItemCatalogue.getItem(1));
        example.addToBasket(ItemCatalogue.getItem(2));

        TotalPrice result = example.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryCharge = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryCharge;

        System.out.println("Total price: " + totalPrice);
        System.out.println("Delivery charge: " + deliveryCharge);
        System.out.println("Overall total: " + overallTotal);
    }

    private static PricingRules generatePricingRules(){
        PricingRules pricingRules = new PricingRules();
        pricingRules.addPriceRule(new PriceRule(1, 8, new Discount(0, 0)));
        pricingRules.addPriceRule(new PriceRule(2, 12, new Discount(2, 20)));
        pricingRules.addPriceRule(new PriceRule(3, 4, new Discount(3, 10)));
        pricingRules.addPriceRule(new PriceRule(4, 7, new Discount(2, 7)));
        pricingRules.addPriceRule(new PriceRule(5, 5, new Discount(3, 10)));

        return pricingRules;
    }
}
