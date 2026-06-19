package com.quantity;

public class QuantityMeasurementApp {

    // -------- FEET CLASS --------
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // -------- INCH CLASS --------
    public static class Inch {
        private final double value;

        public Inch(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Inch other = (Inch) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // -------- STATIC METHODS --------

    public static boolean compareFeet(double value1, double value2) {
        Feet f1 = new Feet(value1);
        Feet f2 = new Feet(value2);
        return f1.equals(f2);
    }

    public static boolean compareInch(double value1, double value2) {
        Inch i1 = new Inch(value1);
        Inch i2 = new Inch(value2);
        return i1.equals(i2);
    }

    // -------- MAIN METHOD --------

    public static void main(String[] args) {
        System.out.println("Feet Comparison: " + compareFeet(1.0, 1.0));
        System.out.println("Inch Comparison: " + compareInch(1.0, 1.0));
    }
}