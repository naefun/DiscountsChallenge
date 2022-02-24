package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnidaysDiscountChallenge {
    Map<Integer, Integer> basket;

    public UnidaysDiscountChallenge(PricingRules pricingRules){
        basket = new HashMap<>();
        addItemsToCatalogue(pricingRules);
    }

    public void addToBasket(Item item) {
        Set<Integer> keys = basket.keySet();

        if(!keys.contains(item.id)){
            basket.put(item.id, 1);
        }else {
            int itemCount = basket.get(item.id);
            basket.put(item.id, itemCount +1);
        }
    }

    public TotalPrice calculateTotalPrice(){
        TotalPrice totalPrice = new TotalPrice();

        //get basket id's
        Set<Integer> basketIds = basket.keySet();
        //for each id in the basket
        for(Integer id : basketIds){
            //get the item for that id
            Item item = ItemCatalogue.getItem(id);
            //get the price for that id
            float itemPrice = item.getPrice();
            //get the discount for that id
            Discount discount = item.getDiscount();
            //get the amount of items
            int itemCount = basket.get(id);
            //work out how many times the discount takes effect
            int discountActivations = discount.itemsNeeded > 0 ? itemCount / discount.itemsNeeded : 0;


            //find the cost of the discounted items
            float discountItemsTotalCost = discountActivations * discount.discountPrice;
            //work out the remaining cost using the regular price * remaining items
            float nonDiscountCost = (itemCount - (discountActivations * discount.itemsNeeded)) * itemPrice;

            totalPrice.addToTotal(discountItemsTotalCost + nonDiscountCost);
        }

        return totalPrice;
    }

    private void addItemsToCatalogue(PricingRules pricingRules){
        // for each price in pricelist
            // create an item using prices
            // add item to catalogue
        for(PriceRule priceRule : pricingRules.getPriceList()){
            ItemCatalogue.addItem(new Item(priceRule.id, priceRule.price, priceRule.discount));
        }
    }

    public Map<Integer, Integer> getBasket() {
        return basket;
    }
}
