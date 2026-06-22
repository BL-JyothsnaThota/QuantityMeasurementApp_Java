package com.quantity;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        System.out.println(q1.add(q2, LengthUnit.FEET));       // 2 FEET
        System.out.println(q1.add(q2, LengthUnit.INCHES));     // 24 INCHES
        System.out.println(q1.add(q2, LengthUnit.YARDS));      // ~0.667 YARDS

        System.out.println(
            new QuantityLength(36, LengthUnit.INCHES)
                .add(new QuantityLength(1, LengthUnit.YARDS), LengthUnit.FEET)
        );
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        System.out.println(w1.equals(w2)); // true

        System.out.println(w1.add(w2)); // 2 KG

        System.out.println(w1.add(w2, WeightUnit.GRAM)); // 2000 GRAM
    }
}