// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 7-Part-2-Heaps


import java.util.PriorityQueue;
import java.util.Scanner;

public class DurojaiyeA7Part2Heaps{
    public static void main(String[] args){
        // Creating the heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Scanner scan = new Scanner(System.in);

        // 5 numbers are entered and add to the heap
        System.out.println("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++){
            int num = scan.nextInt();
            heap.add(num);
        }

        // Remove numbers for the heap and prints them one at a time
        System.out.println("Numbers in sorted order: ");
        while(!heap.isEmpty()){
            // Poll removes the smallest element
            System.out.println(heap.poll());
        }
    }
}
