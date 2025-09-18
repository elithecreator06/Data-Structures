// Name: Emmanuel Durojaiye
//Class: CS 3305/W04
//Term: Fall 2024
//Instructor: Carla McManus
//Assignment: 2 – Part 1 Factorial

import java.util.Scanner;

public class DurojaiyeA2Part1Factorial{
    public static void main(String[] args){
        // Creating a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);

        // Prompting the user to enter a nonnegative integer
        System.out.print("Enter a nonnegative integer: ");
        int num = scan.nextInt();

        // Check if the number is nonnegative
        if (num < 0){
            System.out.println("Please enter a nonnegative integer.");
        } else {
            // Calling the factorial method to calculate the factorial of the number
            long result = factorial(num);

            // Displaying the result
            System.out.println("Factorial of " + num + " is " + result);
        }
    }

    // Recursive method to compute the factorial of a number
    public static long factorial(int n){
        // If n is 0, return 1
        if (n == 0){
            return 1;
        }
        // Returns n * factorial of (n-1)
        return n * factorial(n - 1);
    }
}

