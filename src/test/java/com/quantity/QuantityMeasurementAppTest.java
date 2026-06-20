package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testYardToYard() {
        var q1 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(q1, q2);
    }

    @Test
    void testYardToFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.Quantity(3, QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    @Test
    void testYardToInches() {
        var q1 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.Quantity(36, QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(q1, q2);
    }

    @Test
    void testCentimeterToInches() {
        var q1 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.CENTIMETERS);
        var q2 = new QuantityMeasurementApp.Quantity(0.393701, QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(q1, q2);
    }

    @Test
    void testCentimeterToFeet_NotEqual() {
        var q1 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.CENTIMETERS);
        var q2 = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    @Test
    void testTransitiveProperty() {
        var yard = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        var feet = new QuantityMeasurementApp.Quantity(3, QuantityMeasurementApp.LengthUnit.FEET);
        var inches = new QuantityMeasurementApp.Quantity(36, QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

    @Test
    void testSameReference() {
        var q = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        assertEquals(q, q);
    }

    @Test
    void testNullComparison() {
        var q = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        assertNotEquals(q, null);
    }

    @Test
    void testInvalidType() {
        var q = new QuantityMeasurementApp.Quantity(1, QuantityMeasurementApp.LengthUnit.YARDS);
        assertNotEquals(q, "invalid");
    }
}