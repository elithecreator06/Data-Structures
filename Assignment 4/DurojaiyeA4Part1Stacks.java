// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 04-Part-1-Stacks

import java.util.Scanner;

public class DurojaiyeA4Part1Stacks {

    private final int[] stackArray;
    private int topA;
    private int topB;
    private final int capacity;

    // Constructor to initialize stack pair
    public DurojaiyeA4Part1Stacks(int size) {
        capacity = size;
        stackArray = new int[capacity];
        topA = -1;             // StackA starts from the left side
        topB = capacity;       // StackB starts from the right side
    }

    // Push onto StackA
    public void push_a(int value) {
        if (is_full()) {
            System.out.println("Error: Stack Overflow! No more space available.");
            return;
        }
        topA++;
        stackArray[topA] = value;
    }

    // Push onto StackB
    public void push_b(int value) {
        if (is_full()) {
            System.out.println("Error: Stack Overflow! No more space available.");
            return;
        }
        topB--;
        stackArray[topB] = value;
    }

    // Pop from StackA
    public int pop_a() {
        if (is_empty_a()) {
            System.out.println("Error: StackA is empty.");
            return -1;
        }
        int value = stackArray[topA];
        topA--;
        return value;
    }

    // Pop from StackB
    public int pop_b() {
        if (is_empty_b()) {
            System.out.println("Error: StackB is empty.");
            return -1;
        }
        int value = stackArray[topB];
        topB++;
        return value;
    }

    // Check if StackA is empty
    public boolean is_empty_a() {
        return topA == -1;
    }

    // Check if StackB is empty
    public boolean is_empty_b() {
        return topB == capacity;
    }

    // Check if both stacks are full
    public boolean is_full() {
        return topA + 1 == topB;
    }

    // Print the elements in StackA
    public void printStackA() {
        if (is_empty_a()) {
            System.out.println("StackA is empty.");
        } else {
            System.out.print("StackA: ");
            for (int i = 0; i <= topA; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Print the elements in StackB
    public void printStackB() {
        if (is_empty_b()) {
            System.out.println("StackB is empty.");
        } else {
            System.out.print("StackB: ");
            for (int i = capacity - 1; i >= topB; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the stack operations
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create a pair of stacks with a size of 10
        DurojaiyeA4Part1Stacks stacks = new DurojaiyeA4Part1Stacks(10);

        // Push values onto StackA
        System.out.print("Enter values to push onto StackA (comma separated): ");
        String[] valuesA = scan.nextLine().split(",");
        for (String val : valuesA) {
            stacks.push_a(Integer.parseInt(val.trim()));
        }
        stacks.printStackA();

        // Push values onto StackB
        System.out.print("Enter values to push onto StackB (comma separated): ");
        String[] valuesB = scan.nextLine().split(",");
        for (String val : valuesB) {
            stacks.push_b(Integer.parseInt(val.trim()));
        }
        stacks.printStackB();

        // Pop one element from each stack and print the results
        System.out.println("\nPopping one element from StackA: " + stacks.pop_a());
        stacks.printStackA();

        System.out.println("Popping one element from StackB: " + stacks.pop_b());
        stacks.printStackB();
    }
}
