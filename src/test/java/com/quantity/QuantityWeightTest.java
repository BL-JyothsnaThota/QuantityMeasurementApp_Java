package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    // ✅ Equality tests

    @Test
    void testEquality_KgAndGram() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    void testEquality_KgAndPound() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertEquals(w1, w2);
    }

    @Test
    void testInequality_DifferentWeights() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(500, WeightUnit.GRAM);

        assertNotEquals(w1, w2);
    }

    // ✅ Conversion tests

    @Test
    void testConvert_KgToGram() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);

        assertEquals(new QuantityWeight(1000, WeightUnit.GRAM), result);
    }

    @Test
    void testConvert_PoundToKg() {
        QuantityWeight result = new QuantityWeight(2.20462, WeightUnit.POUND)
                .convertTo(WeightUnit.KILOGRAM);

        assertEquals(new QuantityWeight(1, WeightUnit.KILOGRAM), result);
    }

    // ✅ Addition tests (implicit unit)

    @Test
    void testAddition_KgPlusGram() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(500, WeightUnit.GRAM));

        assertEquals(new QuantityWeight(1.5, WeightUnit.KILOGRAM), result);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertEquals(w1.add(w2), w2.add(w1));
    }

    // ✅ Addition with explicit target

    @Test
    void testAddition_ExplicitTarget_Gram() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(500, WeightUnit.GRAM), WeightUnit.GRAM);

        assertEquals(new QuantityWeight(1500, WeightUnit.GRAM), result);
    }

    @Test
    void testAddition_ExplicitTarget_Pound() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1, WeightUnit.KILOGRAM), WeightUnit.POUND);

        assertEquals(new QuantityWeight(4.40925, WeightUnit.POUND), result);
    }

    // ✅ Edge cases

    @Test
    void testAdd_Null_ThrowsException() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> w1.add(null));
    }

    @Test
    void testConvert_Null_ThrowsException() {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> w1.convertTo(null));
    }

    // ✅ Category safety (VERY IMPORTANT UC8 requirement)

    @Test
    void testLengthAndWeight_NotEqual() {
        QuantityLength length = new QuantityLength(1, LengthUnit.FEET);
        QuantityWeight weight = new QuantityWeight(1, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }
}