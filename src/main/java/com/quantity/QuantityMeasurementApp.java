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
    }
}