package com.andrej.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PrimeNumberValidatorTest {

    private final PrimeNumberValidator validator = new PrimeNumberValidator();

    @Test
    void test_basic_cases_and_edges() {
        assertTrue(validator.isValidPrime(2L));
        assertTrue(validator.isValidPrime(3L));
        assertTrue(validator.isValidPrime(5L));
        assertTrue(validator.isValidPrime(9973L));

        assertFalse(validator.isValidPrime(4L));
        assertFalse(validator.isValidPrime(9L));
        assertFalse(validator.isValidPrime(100L));

        //Edge cases
        assertFalse(validator.isValidPrime(1L));
        assertFalse(validator.isValidPrime(0L));
        assertFalse(validator.isValidPrime(-17L));
    }

    @Test
    void test_numbers_around_int_max_boundary() {
        long intMax = Integer.MAX_VALUE;
        assertTrue(validator.isValidPrime(intMax), "Integr.MAX_VALUE should be prime");

        long biggerPrime = 2_147_483_659L;
        assertTrue(validator.isValidPrime(biggerPrime));

        long notAPrime = 2_147_483_648L;
        assertFalse(validator.isValidPrime(notAPrime));
    }

    @Test
    void test_some_random_large_number() {
        long largeComposite = 982_451_653L * 2;
        assertFalse(validator.isValidPrime(largeComposite));
    }
}