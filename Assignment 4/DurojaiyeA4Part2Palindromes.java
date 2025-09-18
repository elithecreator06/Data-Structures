// Name: Emmanuel Durojaiye
// Class: CS 3305/ W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment:  04-Part-2-Palindromes

import java.util.Scanner;
import java.util.Stack;

public class DurojaiyeA4Part2Palindromes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scan.nextLine().toLowerCase(); // Convert to lowercase

        // Create a char array to hold only the letters
        StringBuilder filteredInput = new StringBuilder();

        // Transfer the string into a char array, filtering out non-letter characters
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // Check if the character is a lowercase letter
                filteredInput.append(ch);
            }
        }

        char[] charArray = new char[filteredInput.length()];
        for (int i = 0; i < filteredInput.length(); i++) {
            charArray[i] = filteredInput.charAt(i);
        }

        // Stacks for original and reversed characters
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();

        // Push characters onto stack1 and stack2
        for (char ch : charArray) {
            stack1.push(ch);
            stack2.push(ch);
        }

        // Pop from stack1 and push onto stack3 to reverse
        while (!stack1.isEmpty()) {
            stack3.push(stack1.pop());
        }

        // Compare stack2 (original) and stack3 (reversed)
        boolean isPalindrome = true;
        while (!stack2.isEmpty()) {
            char originalChar = stack2.pop();
            char reversedChar = stack3.pop();
            if (originalChar != reversedChar) {
                isPalindrome = false;
                break;
            }
        }

        // Output the result
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}