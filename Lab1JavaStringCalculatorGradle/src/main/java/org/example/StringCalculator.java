package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        if (!Character.isDigit(numbers.charAt(numbers.length() - 1))) {
            throw new IllegalArgumentException("Incorrect Input Format"); //помилка роздільник є останнім символом//
        }

        String delimiter = ",|\n";
        String[] inputSplit = numbers.split(delimiter);
        List<Integer> numList = new ArrayList<>();

        for (String num : inputSplit) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Incorrect Input Format");//помилка використання роздільників//
            } else {
                int n;
                try {
                    n = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect Delimiter Input"); //помилка невизначеного роздільника//
                }
                numList.add(n);
            }
        }

        int sum = 0;
        for (int num : numList) {
            sum += num;
        }
        return sum;
    }
}
