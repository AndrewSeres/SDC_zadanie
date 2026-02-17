package com.andrej.validators;

import java.math.BigInteger;

/**
 * Checks if number is prime - for large numbers uses BigInteger method isProbablePrime
 * impl. Andrej Seres
 */
public class PrimeNumberValidator {
    private static final long BIG_NUMBER_THRESHOLD = 2_147_483_647L;
    private static final int CERTAINTY = 100;


    public boolean isValidPrime(long number) {
        if (number <= 1) {
            return false;
        }

        if (number > BIG_NUMBER_THRESHOLD) {
            return checkLargeNumber(number);
        } else {
            return checkSmallNumber(number);
        }
    }

    private boolean checkSmallNumber(long number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLargeNumber(long number) {
        return BigInteger.valueOf(number).isProbablePrime(CERTAINTY);
    }
}