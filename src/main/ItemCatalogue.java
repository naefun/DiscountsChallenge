package main;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalogue {
    public static Map<Integer, Item> catalogue = new HashMap<>();

    public static Item getItem(int itemId){
        return catalogue.get(itemId);
    }

    public static void addItem(Item item){
        catalogue.put(item.getId(), item);
    }
}
