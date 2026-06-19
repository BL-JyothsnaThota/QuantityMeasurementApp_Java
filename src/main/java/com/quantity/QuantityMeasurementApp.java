package com.quantity;

public class QuantityMeasurementApp {

    // -------- ENUM --------
    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // -------- GENERIC QUANTITY CLASS --------
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj)
                return true;

            // Null & type check
            if (obj == null || getClass() != obj.getClass())
                return false;

            Quantity other = (Quantity) obj;

            // Compare after conversion
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println("Are equal: " + q1.equals(q2));
    }
}