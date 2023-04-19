package org.example;

public class Main {

    public static void main(String[] args) {


        StringCalculator Calculator = new StringCalculator();

        System.out.println("sum " + Calculator.add("")); //0s1
        System.out.println("sum " + Calculator.add("1")); //1s1
        System.out.println("sum " + Calculator.add("1,2")); //3s1
        System.out.println("sum " + Calculator.add("1,2,95,8,5,8,10")); //129s2
        System.out.println("sum " + Calculator.add("1\n2,95,8,5")); //111s3
        System.out.println("sum " + Calculator.add("//;\n1;2")); //3s4
        //System.out.println("sum " + Calculator.add("//;\n-1;2;8,7,-7")); //exceptions5
        System.out.println("sum " + Calculator.add("1,2,5000\n7")); //10s6
        System.out.println("sum " + Calculator.add("//[*]\n1*2**3***6"));//12s7
    }
}
