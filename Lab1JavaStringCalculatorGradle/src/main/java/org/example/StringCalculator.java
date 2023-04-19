package org.example;




public class StringCalculator {

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] inputSplit = numbers.split(",");
        if (inputSplit.length > 2) {
            throw new IllegalArgumentException("Input String Error");
        }
        int sum = 0;
        for (String num : inputSplit) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
