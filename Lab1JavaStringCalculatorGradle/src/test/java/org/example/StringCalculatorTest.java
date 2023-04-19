package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private StringCalculator Calculator;

    @BeforeEach
    public void SetUp() {
        Calculator = new StringCalculator();
    }

    @Test
    public void Step1() { //підтримка 2 доданків//
        assertEquals(0, Calculator.add(""));
        assertEquals(0, Calculator.add("0"));
        assertEquals(5, Calculator.add("5"));
        assertEquals(4, Calculator.add("1,3"));

    }

    @Test
    public void Step2 () { //підтримка довільної кількості доданків//
        assertEquals(9, Calculator.add("1,3,5"));
        try {
            Calculator.add("1,3%5");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect Delimiter Input", e.getMessage());
        }
    }
}

