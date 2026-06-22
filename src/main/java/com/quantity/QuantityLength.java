package com.quantity;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid number");
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

    // 🔥 UC6: ADD METHOD
    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        // Convert both to base (FEET)
        double thisInFeet = this.unit.toBase(this.value);
        double otherInFeet = other.unit.toBase(other.value);

        // Add
        double sumInFeet = thisInFeet + otherInFeet;

        // Convert back to THIS unit
        double resultValue = this.unit.fromBase(sumInFeet);

        return new QuantityLength(resultValue, this.unit);
    }

    // Optional static method (flexibility)
    //public static QuantityLength add(QuantityLength q1, QuantityLength q2) {
        //return q1.add(q2);
    //}

    // Equals (important for testing)
    private static final double TOLERANCE = 0.001;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityLength)) return false;

        QuantityLength that = (QuantityLength) o;

        double thisBase = this.unit.toBase(this.value);
        double thatBase = that.unit.toBase(that.value);

        return Math.abs(thisBase - thatBase) < TOLERANCE;
    }
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        // Convert both to base (FEET)
        double thisInFeet = this.unit.toBase(this.value);
        double otherInFeet = other.unit.toBase(other.value);

        // Add
        double sumInFeet = thisInFeet + otherInFeet;

        // Convert to TARGET unit (🔥 UC7 change)
        double resultValue = targetUnit.fromBase(sumInFeet);

        return new QuantityLength(resultValue, targetUnit);
    }
    @Override
    public int hashCode() {
        long rounded = Math.round(unit.toBase(value) / 0.001);
        return Objects.hash(rounded);
    }
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}