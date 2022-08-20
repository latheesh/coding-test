package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */

    private final HashMap<Furniture, Integer> orderMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {

        orderMap = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        if (orderMap.get(type) == null) {
            orderMap.put(type, furnitureCount);
        } else {
            Integer integer = orderMap.get(type);
            orderMap.put(type, integer + furnitureCount);
        }
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return orderMap;
    }

    public float getTotalOrderCost() {
        Set<Furniture> furnitures = orderMap.keySet();
        float cost = 0.0f;
        for (Furniture furniture : furnitures) {
            int count = orderMap.get(furniture);
            cost = cost + furniture.cost() * count;
        }
        return cost;
    }

    public int getTypeCount(Furniture type) {
        return orderMap.get(type);
    }

    public float getTypeCost(Furniture type) {
        float cost = 0;
        if (type != null) {
            Integer count = orderMap.get(type);
            Furniture[] values = type.values();
            for (Furniture furniture : values) {
                cost +=furniture.cost() ;
            }
        }
        return cost;

    }

    public int getTotalOrderQuantity() {
        return orderMap.values().stream().reduce((integer, integer2) -> integer + integer2).orElse(0);
    }
}