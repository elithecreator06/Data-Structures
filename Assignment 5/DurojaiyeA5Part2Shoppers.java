// Name: Emmanuel Durojaiye
// Class: CS 3305 / W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 05-Part-2-Shoppers

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Class representing a Customer with a name and a transaction time
class Customer {
    private final String name; // The name of the customer
    private final int transactionTime; // Time taken for the customer's transaction

    // Constructor for creating a customer with a name
    public Customer(String name) {
        this.name = name;
        // Random transaction time between 1 and 10
        this.transactionTime = new Random().nextInt(10) + 1;
    }

    // Getter method to get the customer's name
    public String getName() {
        return name;
    }

    // Getter method to get the transaction time of the customer
    public int getTransactionTime() {
        return transactionTime;
    }

    // Method to convert customer detail into a string
    @Override
    public String toString() {
        return name + " (Transaction Time: " + transactionTime + ")";
    }
}

public class DurojaiyeA5Part2Shoppers {
    public static void main(String[] args) {
        // Initialise 5 checkout lines (queues), using an array of Queues
        Queue<Customer>[] queues = new LinkedList[5];
        for (int i = 0; i < queues.length; i++) {
            // Each queue is implemented using a LinkedList
            queues[i] = new LinkedList<>();
        }

        // Generate 5 initial customers and assign one customer to each queue
        for (int i = 0; i < 5; i++) {
            // Create new customer
            Customer Cus = new Customer("Customer " + (i + 1));
            // Add the customer to the respective queue
            queues[i].add(Cus);
            System.out.println(Cus + " added to Queue " + (i + 1));
        }

        // Simulate adding new customers and processing the checkout queues
        for (int i = 6; i <= 15; i++) { // Add 10 more customers to the queues
            // Create a new customer
            Customer newCus = new Customer("Customer " + i);
            // Find the shortest queue among the 5 queues
            int shortestQueue = findShortestQueue(queues);
            // Add the new customer to the shortest queue
            queues[shortestQueue].add(newCus);

            System.out.println(newCus + " added to Queue " + (shortestQueue + 1));
            // Process the queue
            processQueue(queues[shortestQueue], shortestQueue);
        }

        // Ensure all customers in all queues are processed after all customers are added
        boolean queuesNotEmpty = true;
        while (queuesNotEmpty) {
            queuesNotEmpty = false;
            // Process each queue
            for (int i = 0; i < queues.length; i++) {
                if (!queues[i].isEmpty()) {
                    // If any queue still has customers, continue processing
                    processQueue(queues[i], i);
                    queuesNotEmpty = true;
                }
            }
        }

        System.out.println("All customers have been processed, and the queues are now empty.");
    }

    // Method to find the shortest queue (with the fewest customers)
    private static int findShortestQueue(Queue<Customer>[] queues) {
        // Assume the first queue is the shortest initially
        int shortestQueue = 0;
        // Loop through all queues to find the actual shortest queue
        for (int i = 1; i < queues.length; i++) {
            if (queues[i].size() < queues[shortestQueue].size()) {
                // Update if a shorter queue is found
                shortestQueue = i;
            }
        }
        return shortestQueue;
    }

    // Method to process a customer in the queue, simulating transaction time
    private static void processQueue(Queue<Customer> queue, int queueNum) {
        // Check if the queue has customers
        if (!queue.isEmpty()) {
            // Peek the customer at the front of the queue
            Customer currentCus = queue.peek();
            System.out.println("Processing " + currentCus + " at Queue " + (queueNum + 1));

            // Simulate the transaction time by making the program wait
            try {
                // Wait for the transaction time in ms
                Thread.sleep(currentCus.getTransactionTime() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // After the transaction, remove the customer from the queue
            queue.poll();
            System.out.println(currentCus + " completed at Queue " + (queueNum + 1));
        }
    }
}
