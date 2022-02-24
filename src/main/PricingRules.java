package main;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class PricingRules {
    private ArrayList<PriceRule> priceList;

    public PricingRules(){
        priceList = new ArrayList<>();
    }

    public void addPriceRule(PriceRule priceRule) throws InvalidParameterException{
        priceList.add(priceRule);
    }

    public ArrayList<PriceRule> getPriceList() {
        return priceList;
    }
}
