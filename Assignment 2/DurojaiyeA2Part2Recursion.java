// Name: Emmanuel Durojaiye
//Class: CS 3305/W04
//Term: Fall 2024
//Instructor: Carla McManus
//Assignment: 2 – Part 2 Recursion

import java.util.Scanner;

public class DurojaiyeA2Part2Recursion{
    public static void main(String[] args){
        // Creating a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);

        // Prompting the user to enter an integer
        System.out.print("Enter a positive integer: ");
        int number = scan.nextInt();

        // Start the recursive function if the input is valid
        if (number > 0) {
            printRecursively(number, 1);
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }

    // Recursive method to print the required output
    public static void printRecursively(int n, int currentLevel) {
        // If the currentLevel is greater than n, stop recursion
        if (currentLevel > n) {
            return;
        }

        // Printing the statement before the recursive call
        System.out.println("This was written by call number " + currentLevel + ".");

        // Recursive call to proceed to the next level
        printRecursively(n, currentLevel + 1);

        // Print the statement after the recursive call
        System.out.println("This was ALSO written by call number " + currentLevel + ".");
    }
}
