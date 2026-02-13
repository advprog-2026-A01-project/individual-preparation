package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtility {
    
    public double add(double o1, double o2) {
        return o1 + o2;
    }

    public double subtract(double o1, double o2) {
        return o1 - o2;
    }

    public double multiply(double o1, double o2) {
        return o1 * o2;
    }

    public double divide(double o1, double o2) {
        if (o2 == 0.0) {
            throw new IllegalArgumentException("cannot divide by zero");
        }
        return o1 / o2;
    }

    public double exponent(double o1, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (o1 == 0.0 && n < 0) {
            throw new IllegalArgumentException("cannot raise 0 to a negative number");
        }

        boolean negativeExp = false;
        if (n < 0) {
            negativeExp = true;
        }

        int exp = n;
        if (negativeExp) {
            exp = -exp;
        }

        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result = result * o1;
        }

        if (negativeExp) {
            result = 1.0 / result;
        }

        return result;
    }
}
