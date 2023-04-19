package org.example;

public class Main {

    public static void main(String[] args) {


        StringCalculator Calculator = new StringCalculator();

        System.out.println("sum " + Calculator.add("")); //0s1
        System.out.println("sum " + Calculator.add("1")); //1s1
        System.out.println("sum " + Calculator.add("1,2")); //3s1
    }
}
