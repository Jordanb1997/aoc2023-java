package org.example;

import java.util.*;

public class DayFour {
    public static void main(String[] args){
        int finalScore = 0;

        List<String> input = AocInputs.InputAsList("src/main/inputs/dayFour");

        for(String card : input){
            finalScore += cardScore(card);
        }
        System.out.println("part 1 - full score: " + finalScore);


    }

    static int cardScore(String card){
        int matchingNumbers = 0;

        String[] cardNumbers = card.split(":");
        String[] splitNumbers = cardNumbers[1].split("\\|");

        String[] scratchedArray = splitNumbers[0].trim().split("\\s+");
        String[] winningArray = splitNumbers[1].trim().split("\\s+");

        List<Integer> winningNumbers = new ArrayList<>();

        for(String s : winningArray){
           winningNumbers.add(Integer.parseInt(s));
        }

        for(String num : scratchedArray){
            if(winningNumbers.contains(Integer.parseInt(num))){
                matchingNumbers++;
            }
        }

        return (int) Math.pow(2, matchingNumbers - 1 );
    }

    static int totalCards(List<String> cards){
        Map<Integer, Integer> cardMap = new HashMap<>();




        return 0;
    }
}
