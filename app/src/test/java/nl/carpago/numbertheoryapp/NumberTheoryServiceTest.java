package nl.carpago.numbertheoryapp;


import org.junit.Test;

import nl.carpago.numbertheoryapp.tools.NumberTheoryService;

import static org.junit.Assert.*;

public class NumberTheoryServiceTest {


    private NumberTheoryService service;

    public NumberTheoryServiceTest() {
        this.service = new NumberTheoryService();
    }

    @Test
    public void testIsEven() {
        assertTrue(this.service.isEven(2));
        assertFalse(this.service.isEven(3));
        assertTrue(this.service.isEven(4));
    }

    @Test
    public void testIsPrime() {
        assertTrue(this.service.isPrime(2));
        assertTrue(this.service.isPrime(3));
        assertFalse(this.service.isPrime(8));
    }
}
