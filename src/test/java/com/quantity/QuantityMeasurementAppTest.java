package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    double epsilon = 0.0001;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                epsilon);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityMeasurementApp.convert(24.0,
                        QuantityMeasurementApp.LengthUnit.INCHES,
                        QuantityMeasurementApp.LengthUnit.FEET),
                epsilon);
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                epsilon);
    }

    @Test
    void testCentimeterToInches() {
        assertEquals(1.0,
                QuantityMeasurementApp.convert(2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                0.01);
    }

    @Test
    void testRoundTrip() {
        double original = 5.0;

        double converted = QuantityMeasurementApp.convert(
                original,
                QuantityMeasurementApp.LengthUnit.FEET,
                QuantityMeasurementApp.LengthUnit.INCHES
        );

        double back = QuantityMeasurementApp.convert(
                converted,
                QuantityMeasurementApp.LengthUnit.INCHES,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertEquals(original, back, epsilon);
    }

    @Test
    void testZero() {
        assertEquals(0.0,
                QuantityMeasurementApp.convert(0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                epsilon);
    }

    @Test
    void testNegative() {
        assertEquals(-12.0,
                QuantityMeasurementApp.convert(-1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES),
                epsilon);
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0,
                QuantityMeasurementApp.convert(5.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.FEET),
                epsilon);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null,
                        QuantityMeasurementApp.LengthUnit.FEET));
    }

    @Test
    void testNaN() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCHES));
    }
}