package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


    @Test
    void exponent_positiveExp() {
        double base = 3.0;
        int exp = 3;
        double actual = arithmeticUtility.exponent(base, exp);
        double expected = 27.0;
        assertEquals(expected, actual, 1e-12);
    }

    @Test
    void exponent_zeroExp() {
        double base = 987.0;
        int exp = 0;
        double actual = arithmeticUtility.exponent(base, exp);
        double expected = 1.0;
        assertEquals(expected, actual, 1e-12);
    }

    @Test
    void exponent_negativeExp() {
        double base = 2.0;
        int exp = -2;
        double actual = arithmeticUtility.exponent(base, exp);
        double expected = 0.25;
        assertEquals(expected, actual, 1e-12);
    }

    @Test
    void exponent_baseZero_posExp() {
        double base = 0.0;
        int exp = 6;
        double actual = arithmeticUtility.exponent(base, exp);
        double expected = 0.0;
        assertEquals(expected, actual, 1e-12);
    }

    @Test
    void exponent_baseZero_negativeExp_throwsException() {
        double base = 0.0;
        int exp = -1;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            arithmeticUtility.exponent(base, exp);
        });
        assertEquals("cannot raise 0 to a negative number", ex.getMessage());
    }

    // Person B (divide)
    @Test
    void divide_twoPositiveNumbers() {
        assertEquals(5.0, arithmeticUtility.divide(10.0, 2.0), 1e-12);
    }

    @Test
    void divide_withNegativeNumber() {
        assertEquals(-5.0, arithmeticUtility.divide(-10.0, 2.0), 1e-12);
    }

    @Test
    void divide_resultDecimal() {
        assertEquals(2.5, arithmeticUtility.divide(5.0, 2.0), 1e-12);
    }

    @Test
    void divide_byZero_throwsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            arithmeticUtility.divide(5.0, 0.0);
        });

        assertEquals("cannot divide by zero", ex.getMessage());
    }
}
