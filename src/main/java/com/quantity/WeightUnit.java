package com.quantity;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKgFactor;

    WeightUnit(double toKgFactor) {
        this.toKgFactor = toKgFactor;
    }

    public double toBase(double value) {
        return value * toKgFactor; // convert to KG
    }

    public double fromBase(double baseValue) {
        return baseValue / toKgFactor; // convert from KG
    }
}