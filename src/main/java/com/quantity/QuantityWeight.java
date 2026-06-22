package com.quantity;

import java.util.Objects;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;
    private static final double TOLERANCE = 0.001;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid number");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // ✅ Convert
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit null");

        double base = unit.toBase(value);
        double result = targetUnit.fromBase(base);

        return new QuantityWeight(result, targetUnit);
    }

    // ✅ Add (default → this unit)
    public QuantityWeight add(QuantityWeight other) {
        if (other == null) throw new IllegalArgumentException("Other null");

        double sumBase =
                this.unit.toBase(this.value) +
                other.unit.toBase(other.value);

        double result = this.unit.fromBase(sumBase);

        return new QuantityWeight(result, this.unit);
    }

    // ✅ Add (explicit target)
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null) throw new IllegalArgumentException("Other null");
        if (targetUnit == null) throw new IllegalArgumentException("Target null");

        double sumBase =
                this.unit.toBase(this.value) +
                other.unit.toBase(other.value);

        double result = targetUnit.fromBase(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    // ✅ Equality (base KG comparison)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuantityWeight that = (QuantityWeight) o;

        double thisBase = this.unit.toBase(this.value);
        double thatBase = that.unit.toBase(that.value);

        return Math.abs(thisBase - thatBase) < TOLERANCE;
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(unit.toBase(value) / TOLERANCE);
        return Objects.hash(rounded);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}