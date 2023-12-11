package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayTwo {
    public static void main(String[] args) {
        List<String> games = AocInputs.InputAsList("src/main/inputs/dayTwo");
        List<String> validGames = new ArrayList<>();

        List<String> example = new ArrayList<>();
        example.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        example.add("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        example.add("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        example.add("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        example.add("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        int idSum = 0;
        int powerSum = 0;

        for(String g : games){
            if(isPossible(g)){
                validGames.add(g);
            }
        }

        //part 1
        for(String g : validGames){
            idSum += idSum(g);
        }
        System.out.println("Part 1:" + idSum);

        //part 2
        for(String g : games){
            powerSum += power(g);
        }
        System.out.println("Part 2: " + powerSum);
    }

    static int idSum(String game){
        String[] gameSplit = game.split(":");
        String[] gameId = gameSplit[0].trim().split("\s");

        return Integer.parseInt(gameId[1]);
    }
    static boolean isPossible(String game){
        int red = 12;
        int green = 13;
        int blue = 14;

        boolean possibility = false;

        String[] splitGame = game.split(":");
        String[] cubes = splitGame[1].split("[,;]");

        for(String c : cubes){
            String[] cube =  c.trim().split("\s");

            //entire structure can probably be simplified to a switch statement
            if(cube[1].contains("red")){
                if (Integer.parseInt(cube[0]) <= red){
                    possibility = true;
                } else{
                    return false;
                }
            } else if(cube[1].contains("green")){
                if (Integer.parseInt(cube[0]) <= green){
                    possibility = true;
                } else{
                    return false;
                }
            } else if(cube[1].contains("blue")){
                if (Integer.parseInt(cube[0]) <= blue){
                    possibility = true;
                } else{
                    return false;
                }
            }
        }
        return possibility;
    }

    static int power(String game){
        int red = 0;
        int green = 0;
        int blue = 0;

        String[] splitGame = game.split(":");
        String[] cubes = splitGame[1].split("[,;]");

        List<Integer> redCubes = new ArrayList<>();
        List<Integer> greenCubes = new ArrayList<>();
        List<Integer> blueCubes = new ArrayList<>();

        for(String c : cubes){
            String[] cubeNumber = c.trim().split("\s");

            if (cubeNumber[1].contains("red")){
                redCubes.add(Integer.parseInt(cubeNumber[0]));
            } else if(cubeNumber[1].contains("green")) {
                greenCubes.add(Integer.parseInt(cubeNumber[0]));
            } else if(cubeNumber[1].contains("blue")){
                blueCubes.add(Integer.parseInt(cubeNumber[0]));
            }
        }

        red = Collections.max(redCubes);
        green = Collections.max(greenCubes);
        blue = Collections.max(blueCubes);

        return red * green * blue;
    }
}
