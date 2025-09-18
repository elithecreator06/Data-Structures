// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 3 – Part 2 Capitals

import java.util.Scanner;
import java.util.Random;

public class DurojaiyeA3Part2Capitals {
    public static void main(String[] args) {
        // Array of states and capitals
        String[][] statesAndCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Maryland", "Annapolis"},
                {"Minnesota", "Saint Paul"},
                {"Iowa", "Des Moines"},
                {"Maine", "Augusta"},
                {"Kentucky", "Frankfort"},
                {"Indiana", "Indianapolis"},
                {"Kansas", "Topeka"},
                {"Louisiana", "Baton Rouge"},
                {"Oregon", "Salem"},
                {"Oklahoma", "Oklahoma City"},
                {"Ohio", "Columbus"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"New Jersey", "Trenton"},
                {"New Hampshire", "Concord"},
                {"Nevada", "Carson City"},
                {"Nebraska", "Lincoln"},
                {"Montana", "Helena"},
                {"Missouri", "Jefferson City"},
                {"Mississippi", "Jackson"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        // Initialize Scanner and Random
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int correctAnswers = 0;
        int rounds = 5; // Minimum number of rounds

        // Run the game for the specified number of rounds
        for (int i = 0; i < rounds; i++) {
            // Randomly pick a state and its capital
            int randomIndex = random.nextInt(statesAndCapitals.length);
            String state = statesAndCapitals[randomIndex][0];
            String capital = statesAndCapitals[randomIndex][1];

            // Ask user to guess the capital
            System.out.println("What is the capital of " + state + "?");
            String userAnswer = input.nextLine().trim();

            // Check if the answer is correct
            if (userAnswer.equalsIgnoreCase(capital)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect. The capital of " + state + " is " + capital + ".");
            }
        }

        // Display the total number of correct answers
        System.out.println("You got " + correctAnswers + " correct out of " + rounds + " guesses.");
    }
}

