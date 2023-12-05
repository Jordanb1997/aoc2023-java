package org.example;

import java.util.ArrayList;
import java.util.List;

public class DayOne {

    public static void main(String[] args) {
        List<String> input = AocInputs.InputAsList("src/main/inputs/dayOne");
        List<Integer> digits = new ArrayList<>();

        int sum = 0;

        for (String inputLine : input) {
            char firstDigit = findDigit(inputLine);
            char lastDigit =  findDigit(new StringBuilder(inputLine).reverse().toString());

            digits.add(Integer.valueOf(""+firstDigit+lastDigit));
        }

        for(Integer digit : digits){
           sum += digit;
        }
        System.out.println(sum);
    }

    public static char findDigit(String s) {
        char digit = '\0';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digit = (s.charAt(i));
                break;
            }
        }
        return digit;
    }

    public static int digitCount(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
