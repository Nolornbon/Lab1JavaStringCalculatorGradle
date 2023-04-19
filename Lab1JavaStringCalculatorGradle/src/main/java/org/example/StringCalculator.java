package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        if (!Character.isDigit(numbers.charAt(numbers.length() - 1))) {
            throw new IllegalArgumentException("Incorrect Input Format"); //помилка роздільник є останнім символом//
        }

        List<String> delimiters = new ArrayList<>();

        delimiters.add(",");
        delimiters.add("\n");

        String input = numbers;

        if (numbers.startsWith("//")) {
            int endIndex = numbers.indexOf('\n');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Incorrect Input Format"); //помилка відсутності символу нового рядка//
            }
            if (!numbers.startsWith("//[") && endIndex != 3) {
                throw new IllegalArgumentException("Incorrect Input Format");//помилка задання кастомного роздільника//
            }
            String customDelimiter = numbers.substring(2, endIndex);
            if (customDelimiter.startsWith("[")) {
                customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
            }
            delimiters.add(Pattern.quote(customDelimiter));
            input = numbers.substring(endIndex+ 1);
        }

        String delimiterList = String.join("|", delimiters);

        String[] inputSplit = input.split(delimiterList);

        List<Integer> numList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        for (String num : inputSplit) {
            if (num.isEmpty() && !numbers.startsWith("//[")) {
                throw new IllegalArgumentException("Incorrect Input Format"); //помилка використання роздільників//
            } if (!num.isEmpty()) {
                int n;
                try {
                    n = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect Delimiter Input"); //помилка невизначеного роздільника//
                }
                if (n < 0) {
                    negList.add(n);
                } else if (n <= 1000) {
                    numList.add(n);
                }
            }
        }

        if (!negList.isEmpty()) {
            StringBuilder sb = new StringBuilder("Negatives are not allowed:");
            for (int neg : negList) {
                sb.append(" ").append(neg);
            }
            throw new IllegalArgumentException(sb.toString());
        }

        int sum = 0;
        for (int num : numList) {
            sum += num;
        }
        return sum;
    }
}
