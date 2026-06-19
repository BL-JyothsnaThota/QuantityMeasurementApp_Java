package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // -------- FEET TESTS --------

    @Test
    void givenSameFeetValue_whenCompared_shouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void givenDifferentFeetValue_whenCompared_shouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    // -------- INCH TESTS --------

    @Test
    void givenSameInchValue_whenCompared_shouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.compareInch(1.0, 1.0));
    }

    @Test
    void givenDifferentInchValue_whenCompared_shouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.compareInch(1.0, 2.0));
    }

    // -------- COMMON TESTS --------

    @Test
    void givenFeet_whenComparedWithNull_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(null));
    }

    @Test
    void givenInch_whenComparedWithNull_shouldReturnFalse() {
        QuantityMeasurementApp.Inch inch = new QuantityMeasurementApp.Inch(1.0);
        assertFalse(inch.equals(null));
    }

    @Test
    void givenFeet_whenComparedWithDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(new QuantityMeasurementApp.Inch(1.0)));
    }

    @Test
    void givenSameFeetReference_shouldReturnTrue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    void givenSameInchReference_shouldReturnTrue() {
        QuantityMeasurementApp.Inch inch = new QuantityMeasurementApp.Inch(1.0);
        assertTrue(inch.equals(inch));
    }
}