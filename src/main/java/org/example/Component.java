package org.example;

import java.util.ArrayList;
import java.util.List;

public class Component {
    private String brand;
    private String model;
    private float cost;

    private static final List<Component> components;

    static {
        components = new ArrayList<Component>();
    }

    Component(String brand, String model, float cost) {
        this.brand = brand;
        this.model = model;
        this.cost = cost;

        components.add(this);
    }

    public static float countTotalPrice(){
        float totalPrice = 0;
        for (Component component : components) {
            totalPrice += component.cost;
        }
        return totalPrice;
    }

    public static int countBrand(String brand){
        int count = 0;
        for (Component component : components) {
            if (component.brand.equalsIgnoreCase(brand)) {
                count++;
            }
        }
        if(count == 0){
            throw new RuntimeException("Брэнд не найден");
        }
        return count;
    }

    public static List<Component> getComponents(){
        return components;
    }

    public float getCost() {
        return cost;
    }

    public float computeDiscount(float percents){
        return this.cost * percents / 100;
    }
}
