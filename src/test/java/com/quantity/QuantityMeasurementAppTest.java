package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // -------- SAME UNIT TESTS --------

    @Test
    void givenFeetToFeet_sameValue_shouldReturnTrue() {
        QuantityMeasurementApp.Quantity q1 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity q2 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void givenInchToInch_sameValue_shouldReturnTrue() {
        QuantityMeasurementApp.Quantity q1 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity q2 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    // -------- CROSS UNIT TESTS --------

    @Test
    void givenFeetAndInch_equivalent_shouldReturnTrue() {
        QuantityMeasurementApp.Quantity feet =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity inch =
                new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void givenInchAndFeet_equivalent_shouldReturnTrue() {
        QuantityMeasurementApp.Quantity inch =
                new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity feet =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(inch.equals(feet));
    }

    // -------- NEGATIVE CASES --------

    @Test
    void givenDifferentFeet_shouldReturnFalse() {
        QuantityMeasurementApp.Quantity q1 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity q2 =
                new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void givenDifferentInch_shouldReturnFalse() {
        QuantityMeasurementApp.Quantity q1 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity q2 =
                new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertFalse(q1.equals(q2));
    }

    // -------- EDGE CASES --------

    @Test
    void givenSameReference_shouldReturnTrue() {
        QuantityMeasurementApp.Quantity q =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q.equals(q));
    }

    @Test
    void givenNullComparison_shouldReturnFalse() {
        QuantityMeasurementApp.Quantity q =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q.equals(null));
    }

    @Test
    void givenDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Quantity q =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q.equals("invalid"));
    }
}