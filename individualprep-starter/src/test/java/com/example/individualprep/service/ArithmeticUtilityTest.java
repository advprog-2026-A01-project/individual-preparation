package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    // <----- Person C ----->
    @Test
    void multiply_twoPositiveNumbers() {
        assertEquals(12.0, arithmeticUtility.multiply(4.0, 3.0), 1e-12);
    }

    @Test
    void multiply_withNegativeNumber() {
        assertEquals(-12.0, arithmeticUtility.multiply(-4.0, 3.0), 1e-12);
    }

    @Test
    void multiply_withZero() {
        assertEquals(0.0, arithmeticUtility.multiply(0.0, 999.0), 1e-12);
    }

    @Test
    void multiply_decimals() {
        assertEquals(10.0, arithmeticUtility.multiply(2.5, 4.0), 1e-12);
    }

    // Person D
    @Test
    void testSubtractPositiveNumbers() {
        assertEquals(10.0, arithmeticUtility.subtract(15.5, 5.5), 0.0001);
    }

    @Test
    void testSubtractNegativeNumbers() {
        assertEquals(-2.0, arithmeticUtility.subtract(-5.0, -3.0), 0.0001);
    }

    @Test
    void testSubtractResultingInZero() {
        assertEquals(0.0, arithmeticUtility.subtract(10.0, 10.0), 0.0001);
    }
}
