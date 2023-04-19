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

    @Test
    public void Step3() { // підтримка нового роздільника "\n" //
        assertEquals(12, Calculator.add("2,4\n6"));
        try {
            Calculator.add("2,4,6,\n");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect Input Format", e.getMessage());
        }
    }

    @Test
    public void Step4() { // підтримка роздільника, що задається користувачем //
        assertEquals(8, Calculator.add("//;\n3;5"));
        assertEquals(10, Calculator.add("//;\n1,9"));
        assertEquals(100, Calculator.add("//@\n10@60,20\n10"));
        assertEquals(1000, Calculator.add("//;\n100;900"));
        try {
            Calculator.add("//;\n3;;5");
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect Input Format", e.getMessage());
        }
    }

    @Test
    public void Step5() { // опрацювання  від'ємних чисел//
        try {
            Calculator.add("1,-1");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -1", e.getMessage());
        }
        try {
            Calculator.add("-1");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -1", e.getMessage());
        }
        try {
            Calculator.add("-1,-2");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -1 -2", e.getMessage());
        }
        try {
            Calculator.add("-1,2\n-3");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -1 -3", e.getMessage());
        }
        try {
            Calculator.add("//;\n-3;2;8\n7,-7");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives are not allowed: -3 -7", e.getMessage());
        }
    }

}

