package com.quantity;

public class QuantityMeasurementApp {

    // Inner class for Feet measurement
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {

            // Same reference check (Reflexive)
            if (this == obj)
                return true;

            // Null or type check
            if (obj == null || getClass() != obj.getClass())
                return false;

            // Type casting
            Feet other = (Feet) obj;

            // Compare double values safely
            return Double.compare(this.value, other.value) == 0;
        }
    }
}