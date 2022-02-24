package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UnidaysDiscountChallengeTest {

    UnidaysDiscountChallenge unidaysDiscountChallenge;

    @BeforeEach
    public void setup(){
        PricingRules pricingRules = generateTestPriceList();
        unidaysDiscountChallenge = new UnidaysDiscountChallenge(pricingRules);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("", 0, 0, 0),
                Arguments.of("A", 1, 8, 7),
                Arguments.of("B", 1, 12, 7),
                Arguments.of("C", 1, 4, 7),
                Arguments.of("D", 1, 7, 7),
                Arguments.of("E", 1, 5, 7),
                Arguments.of("BB", 1, 20, 7),
                Arguments.of("BBB", 1, 32, 7),
                Arguments.of("BBBB", 1, 40, 7),
                Arguments.of("CCC", 1, 10, 7),
                Arguments.of("CCCC", 1, 14, 7),
                Arguments.of("DD", 1, 7, 7),
                Arguments.of("DDD", 1, 14, 7),
                Arguments.of("EE", 1, 10, 7),
                Arguments.of("EEE", 1, 10, 7),
                Arguments.of("EEEE", 1, 15, 7),
                Arguments.of("DDDDDDDDDDDDDD", 1, 49, 7),
                Arguments.of("BBBBCCC", 2, 50, 0),
                Arguments.of("ABBCCCDDEE", 5, 55, 0),
                Arguments.of("EDCBAEDCBC", 5, 55, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void addToBasketAndCalculateTotalTest(String items, int expectedSize, float expectedTotal, float expectedDelivery) {
        addItemsToBasket(items);
        TotalPrice totalPrice = unidaysDiscountChallenge.calculateTotalPrice();

        assertEquals(expectedSize, unidaysDiscountChallenge.getBasket().size());
        assertEquals(expectedTotal, totalPrice.getTotal());
        assertEquals(expectedDelivery, totalPrice.getDeliveryCharge());
    }

    private void addItemsToBasket(String items){
        for(char c : items.toCharArray()){
            unidaysDiscountChallenge.addToBasket(ItemCatalogue.getItem(ItemLetterToIdConverter.valueOf(String.valueOf(c).toUpperCase(Locale.ROOT)).label));
        }
    }

    public PricingRules generateTestPriceList(){
        PricingRules pricingRules = new PricingRules();
        pricingRules.addPriceRule(new PriceRule(1, 8, new Discount(0, 0)));
        pricingRules.addPriceRule(new PriceRule(2, 12, new Discount(2, 20)));
        pricingRules.addPriceRule(new PriceRule(3, 4, new Discount(3, 10)));
        pricingRules.addPriceRule(new PriceRule(4, 7, new Discount(2, 7)));
        pricingRules.addPriceRule(new PriceRule(5, 5, new Discount(3, 10)));

        return pricingRules;
    }
}
