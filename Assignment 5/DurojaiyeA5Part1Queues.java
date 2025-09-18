// Name: Emmanuel Durojaiye
// Class: CS 3305/ W04
// Term: Fall 2024
//	Instructor: Carla McManus
//	Assignment: 05-Part-1-Queues

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Chore{
    String name; // Name of the chore
    int priority; // Priority of the chore (lower number means higher priority)

    // Constructor to initialise the chore name and priority
    public Chore(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    // toString method to return a formatted string for the chore
    public String toString(){
        return name + " (Priority: " + priority + ")";
    }
}

// Custom comparator to compare Chores by their priority
class ChoreComparator implements Comparator<Chore>{
    // Compare two Chore objects by their priority value
    public int compare(Chore c1, Chore c2){
        // Lower priority number means higher priority
        return Integer.compare(c1.priority, c2.priority);
    }
}

public class DurojaiyeA5Part1Queues {
    public static void main(String[] args){
        // Create a priority queue with the custom ChoreComparator to prioritise by the 'priority' field
        PriorityQueue <Chore> queue = new PriorityQueue<>(new ChoreComparator());

        Scanner scan = new Scanner(System.in);

        // Ask the user for the number of chores to add
        System.out.print("How many chores would you like to add? ");
        int numChores = scan.nextInt();
        scan.nextLine();

        // Loop to input chores from the user
        for (int i = 0; i < numChores; i++){
            // Input the name of the chore
            System.out.print("Enter the name of chore " + (i + 1) + ": ");
            String choreName = scan.nextLine();

            // Input the priority of the chore
            System.out.print("Enter the priority of '" + choreName + "': ");
            int chorePriority = scan.nextInt();
            scan.nextLine();

            // Add the new chore to the priority queue
            queue.add(new Chore(choreName, chorePriority));
        }

        // Display all chores currently in the queue
        System.out.println("\nAll chores in the queue:");
        // Make a temporary copy of the queue
        PriorityQueue<Chore> tempQueue = new PriorityQueue<>(queue);
        while(!tempQueue.isEmpty()){
            // Remove and return the chore with the highest priority
            Chore currentChore = tempQueue.poll();
            System.out.println(currentChore);
        }

        // Remove and display the highest priority chore from the queue
        System.out.println("\nRemoving the highest priority chore: " + queue.poll());

        // Display the queue after removing the highest priority chore
        System.out.println("\nQueue after removal:");
        for(Chore c : queue){
            System.out.println(c);
        }

        // Add another chore to the queue
        System.out.print("\nEnter another chore to add: ");
        String addChoreName = scan.nextLine();
        System.out.print("Enter the priority for '" + addChoreName + "': ");
        int addChorePriority = scan.nextInt();
        queue.add(new Chore(addChoreName, addChorePriority));

        // Peek at the highest priority chore without removing it
        System.out.println("\nPeek at the highest priority chore: " + queue.peek());

        // Display the updated queue after peeking
        System.out.println("\nUpdated queue after peek:");
        for(Chore c : queue){
            System.out.println(c);
        }
    }
}
