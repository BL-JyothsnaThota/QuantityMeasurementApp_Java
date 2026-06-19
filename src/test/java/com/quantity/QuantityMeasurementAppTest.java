package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void givenSameFeetValue_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    void givenDifferentFeetValue_whenCompared_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void givenFeetValue_whenComparedWithNull_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void givenFeetValue_whenComparedWithDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals("1.0"));
    }

    @Test
    void givenSameReference_whenCompared_shouldReturnTrue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet));
    }
}