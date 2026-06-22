package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength result = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(2, LengthUnit.FEET));

        assertEquals(new QuantityLength(3, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength result = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(12, LengthUnit.INCHES), LengthUnit.FEET);

        assertEquals(new QuantityLength(2, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength result = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(12, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(new QuantityLength(24, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength result = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(12, LengthUnit.INCHES), LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), 0.001);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        assertEquals(
                q1.add(q2, LengthUnit.YARDS),
                q2.add(q1, LengthUnit.YARDS)
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTarget() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1, LengthUnit.FEET)
                    .add(new QuantityLength(12, LengthUnit.INCHES), null);
        });
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength result = new QuantityLength(1, LengthUnit.FEET)
                .add(new QuantityLength(12, LengthUnit.INCHES));

        assertEquals(new QuantityLength(2, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_InchesPlusFeet() {
        QuantityLength result = new QuantityLength(12, LengthUnit.INCHES)
                .add(new QuantityLength(1, LengthUnit.FEET));

        assertEquals(new QuantityLength(24, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_YardPlusFeet() {
        QuantityLength result = new QuantityLength(1, LengthUnit.YARDS)
                .add(new QuantityLength(3, LengthUnit.FEET));

        assertEquals(new QuantityLength(2, LengthUnit.YARDS), result);
    }

    @Test
    void testAddition_CentimeterPlusInch() {
        QuantityLength result = new QuantityLength(2.54, LengthUnit.CENTIMETERS)
                .add(new QuantityLength(1, LengthUnit.INCHES));

        assertEquals(new QuantityLength(5.08, LengthUnit.CENTIMETERS), result);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        double base1 = q1.add(q2).getUnit().convertToBaseUnit(q1.add(q2).getValue());
        double base2 = q2.add(q1).getUnit().convertToBaseUnit(q2.add(q1).getValue());

        assertEquals(base1, base2, 0.001);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength result = new QuantityLength(5, LengthUnit.FEET)
                .add(new QuantityLength(0, LengthUnit.INCHES));

        assertEquals(new QuantityLength(5, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength result = new QuantityLength(5, LengthUnit.FEET)
                .add(new QuantityLength(-2, LengthUnit.FEET));

        assertEquals(new QuantityLength(3, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1, LengthUnit.FEET).add(null);
        });
    }
}