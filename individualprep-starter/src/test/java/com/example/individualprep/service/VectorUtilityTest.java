package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    // <----- Person C ----->
    @Test
    void multiply_scalesVector() {
        assertArrayEquals(
                new double[] {2.0, 4.0, 6.0},
                vectorUtility.multiply(new double[] {1.0, 2.0, 3.0}, 2),
                1e-12
        );
    }

    @Test
    void multiply_withNegativeScalar() {
        assertArrayEquals(
                new double[] {-2.0, 4.0, -6.0},
                vectorUtility.multiply(new double[] {1.0, -2.0, 3.0}, -2),
                1e-12
        );
    }

    @Test
    void multiply_withZeroScalar() {
        assertArrayEquals(
                new double[] {0.0, 0.0, 0.0},
                vectorUtility.multiply(new double[] {1.0, -2.0, 3.0}, 0),
                1e-12
        );
    }

    @Test
    void multiply_emptyVector() {
        assertArrayEquals(
                new double[] { },
                vectorUtility.multiply(new double[] { }, 5),
                1e-12
        );
    }

    // Person D
    @Test
    void testDotProductValid() {
        double[] v1 = {1.0, 2.0, 3.0};
        double[] v2 = {4.0, 5.0, 6.0};
        assertEquals(32.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductZeroVector() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {0.0, 0.0};
        assertEquals(0.0, vectorUtility.dotProduct(v1, v2), 0.0001);
    }

    @Test
    void testDotProductDifferentLengthThrowsException() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0, 2.0, 3.0};
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(v1, v2);
        });
        
        assertEquals("Both vectors must have the same length!", exception.getMessage());
    }

    @Test
    void testDotProductNullVectorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.dotProduct(null, new double[]{1.0});
        });
    }

    // <----- Person ? (add vector) ----->

    @Test
    void add_addsVector() {
        double[] v1 = new double[] {1.0, 2.0, 3.0};
        double[] v2 = new double[] {4.0, 5.0, 6.0};

        double[] expected = new double[] {5.0, 7.0, 9.0};

        double[] actual = vectorUtility.add(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void add_withNegativeNumber() {
        double[] v1 = new double[] {1.0, -2.0, 3.0};
        double[] v2 = new double[] {-4.0, 5.0, -6.0};

        double[] expected = new double[] {-3.0, 3.0, -3.0};

        double[] actual = vectorUtility.add(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void add_withZeroVector() {
        double[] v1 = new double[] {1.0, 2.0, 3.0};
        double[] v2 = new double[] {0.0, 0.0, 0.0};

        double[] expected = new double[] {1.0, 2.0, 3.0};

        double[] actual = vectorUtility.add(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void add_emptyVector() {
        double[] v1 = new double[] {};
        double[] v2 = new double[] {};

        double[] expected = new double[] {};

        double[] actual = vectorUtility.add(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void add_v1Null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(null, new double[] {1.0});
        });

        assertEquals("v1 cannot be null", ex.getMessage());
    }

    @Test
    void add_v2Null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(new double[] {1.0}, null);
        });

        assertEquals("v2 cannot be null", ex.getMessage());
    }

    @Test
    void add_differentLength() {
        double[] v1 = new double[] {1.0, 2.0};
        double[] v2 = new double[] {1.0, 2.0, 3.0};

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.add(v1, v2);
        });

        assertEquals("v1 and v2 have to be the same length", ex.getMessage());
    }

    // Person B (subtract)
    @Test
    void subtract_subtractsVector() {
        double[] v1 = new double[] {5.0, 7.0, 9.0};
        double[] v2 = new double[] {1.0, 2.0, 3.0};

        double[] expected = new double[] {4.0, 5.0, 6.0};

        double[] actual = vectorUtility.subtract(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void subtract_withNegativeNumber() {
        double[] v1 = new double[] {5.0, -7.0, 9.0};
        double[] v2 = new double[] {-1.0, 2.0, -3.0};

        double[] expected = new double[] {6.0, -9.0, 12.0};

        double[] actual = vectorUtility.subtract(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void subtract_withZeroVector() {
        double[] v1 = new double[] {1.0, 2.0, 3.0};
        double[] v2 = new double[] {0.0, 0.0, 0.0};

        double[] expected = new double[] {1.0, 2.0, 3.0};

        double[] actual = vectorUtility.subtract(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void subtract_emptyVector() {
        double[] v1 = new double[] {};
        double[] v2 = new double[] {};

        double[] expected = new double[] {};

        double[] actual = vectorUtility.subtract(v1, v2);

        assertArrayEquals(expected, actual, 1e-12);
    }

    @Test
    void subtract_v1Null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(null, new double[] {1.0});
        });

        assertEquals("v1 cannot be null", ex.getMessage());
    }

    @Test
    void subtract_v2Null() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(new double[] {1.0}, null);
        });

        assertEquals("v2 cannot be null", ex.getMessage());
    }

    @Test
    void subtract_differentLength() {
        double[] v1 = new double[] {1.0, 2.0};
        double[] v2 = new double[] {1.0, 2.0, 3.0};

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(v1, v2);
        });

        assertEquals("v1 and v2 have to be the same length", ex.getMessage());
    }

}
