package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {
    public  int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        if (!Character.isDigit(numbers.charAt(numbers.length() - 1))) {
            throw new IllegalArgumentException("Incorrect Input Format");
        }

        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add("\n");

        String input = numbers;
        if (numbers.startsWith("//")) {
            int endIndex = numbers.indexOf('\n');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Incorrect Input Format");
            }
            if (!numbers.startsWith("//[") && endIndex != 3) {
                throw new IllegalArgumentException("Incorrect Input Format");
            }
            String customDelimiter = numbers.substring(2, endIndex);
            List<String> customDelimiters = new ArrayList<>();
            if (customDelimiter.startsWith("[")) {
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(customDelimiter);
                while (matcher.find()) {
                    String delimiter = matcher.group(1);
                    customDelimiters.add(delimiter);
                }
            } else {
                delimiters.add(numbers.substring(2, endIndex));
            }

            for (String delimiter : customDelimiters) {
                delimiters.add(Pattern.quote(delimiter));
            }
            input = numbers.substring(endIndex + 1);
        }

        String delimiterList = String.join("|", delimiters);
        String[] inputSplit = input.split(delimiterList);

        List<Integer> numList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        for (String num : inputSplit) {
            if (num.isEmpty() && !numbers.startsWith("//[")) {
                throw new IllegalArgumentException("Incorrect Input Format");
            }
            if (!num.isEmpty()) {
                int n;
                try {
                    n = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect Delimiter Input");
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