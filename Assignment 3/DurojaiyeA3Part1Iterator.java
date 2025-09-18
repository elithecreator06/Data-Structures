// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 3 – Part 1 Iterator

import java.util.LinkedList;

public class DurojaiyeA3Part1Iterator {

    public static void main(String[] args) {
        // Create and populate the linked list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1); list.add(1); list.add(2); list.add(3);
        list.add(3); list.add(4); list.add(4); list.add(5);
        list.add(6); list.add(7);

        // Testing the removeRepetitions method
        removeRepetitions(list);
        System.out.println("List after removing repetitions: " + list +"\n");

        // Testing the printRange method
        System.out.print("List [1,2,3,4,5,6,7] \nprints "); // x = 2 y = 5
        printRange(list, 2, 5);

        System.out.print("List [1,2,3,4,5,6,7] \nprints "); // x = 2 y = 78
        printRange(list, 2, 78);

        System.out.print("List [1,2,3,4,5,6,7] \nprints "); // x = 2 y = 1
        printRange(list, 2, 1);

        System.out.print("List [1,2,3,4,5,6,7] \nprints "); // x = 8 y = 5
        printRange(list, 8, 5);



    }

    // Method to print values between x and y (x inclusive, y exclusive)
    public static void printRange(LinkedList<Integer> list, int x, int y) {
        boolean foundX = false;

        for (int value : list) {
            if (value == x) {
                foundX = true; // Start printing from the first occurrence of x
            }
            if (foundX) {
                if (value == y) {
                    break; // Stop printing before the first occurrence of y
                }
                System.out.print(value + " ");
            }
        }
        System.out.println(); // Print a new line after all values are printed
    }

    // Method to remove duplicate values from the linked list
    public static void removeRepetitions(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == current) {
                    list.remove(j); // Remove duplicate and adjust the index
                    j--; // Stay at the same index after removal
                }
            }
        }
    }
}


