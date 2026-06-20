package com.quantity;

/**
 * UC5: Unit-to-Unit Conversion (Length)
 * Supports FEET, INCHES, YARDS, CENTIMETERS
 */
public class QuantityMeasurementApp {

    // ---------------- ENUM ----------------
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    // ---------------- QUANTITY CLASS ----------------
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid numeric value");
            }
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        // Convert to base unit (feet)
        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        // ---------------- UC5: INSTANCE METHOD ----------------
        public Quantity convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double valueInFeet = this.toBaseUnit();
            double convertedValue = targetUnit.fromFeet(valueInFeet);

            return new Quantity(convertedValue, targetUnit);
        }

        // ---------------- EQUALITY (UC3/UC4) ----------------
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double epsilon = 0.0001;
            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < epsilon;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // ---------------- UC5: STATIC CONVERT API ----------------
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        // Step 1: Convert to base (feet)
        double valueInFeet = source.toFeet(value);

        // Step 2: Convert to target
        return target.fromFeet(valueInFeet);
    }

    // ---------------- DEMO METHODS ----------------

    // Method Overloading 1
    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = convert(value, from, to);
        System.out.println("Convert(" + value + ", " + from + " → " + to + ") = " + result);
    }

    // Method Overloading 2
    public static void demonstrateLengthConversion(Quantity quantity, LengthUnit to) {
        Quantity converted = quantity.convertTo(to);
        System.out.println("Convert(" + quantity + " → " + to + ") = " + converted);
    }

    public static void demonstrateLengthEquality(Quantity q1, Quantity q2) {
        System.out.println(q1 + " == " + q2 + " ? " + q1.equals(q2));
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        // Static conversion
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES); // 12
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET); // 9
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS); // 1

        // Instance conversion
        Quantity q = new Quantity(1.0, LengthUnit.YARDS);
        demonstrateLengthConversion(q, LengthUnit.INCHES); // 36

        // Equality check
        Quantity q1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);
        demonstrateLengthEquality(q1, q2);
    }
}