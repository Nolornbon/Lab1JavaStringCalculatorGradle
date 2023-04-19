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

        List<String> delimiters = new ArrayList<>();

        delimiters.add (",");
        delimiters.add ("\n");

        String input = numbers;
        if (numbers.startsWith("//")) {
            int endIndex = numbers.indexOf('\n');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Incorrect Input Format"); //помилка відсутності символу нового рядка//
            }
            if (endIndex != 3) {
                throw new IllegalArgumentException("Incorrect Input Format");//помилка задання кастомного роздільника//
            }
            delimiters.add(numbers.substring(2, endIndex));
            input = numbers.substring(endIndex+ 1);
        }
        String delimiterList = String.join("|", delimiters);

        String[] inputSplit = input.split(delimiterList);

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