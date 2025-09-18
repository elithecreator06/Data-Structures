// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 7-Part-1-Sorting

import java.util.LinkedList;

public class DurojaiyeA7Part1Sorting{
    public static void main(String[] args){
        // Creating a linked list of integers
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1009);
        list.add(21);
        list.add(3);
        list.add(55);
        list.add(2022);
        list.add(24);
        list.add(99);
        list.add(501);
        list.add(105);
        list.add(98);
        list.add(178);
        list.add(245);
        list.add(0);
        list.add(3305);
        list.add(990);
        list.add(76);
        list.add(373);
        list.add(1010);
        list.add(642);
        list.add(777);

        // Call mergeSort on the linked list
        list = mergeSort(list);

        // Print the sorted list
        System.out.println("Sorted linked List: " + list);
    }

    // Mergesort for the linked list
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list){

        // If list the is empty or has only one element, it's sorted
        if(list.size() <= 1){
            return list;
        }

        // Split the list into two halves
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        int middle = list.size() / 2;
        for (int i = 0; i < middle; i++){
            left.add(list.get(i));
        }
        for (int i = middle; i < list.size(); i++){
            right.add(list.get(i));
        }

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    // Merge two sorted linked lists into one sorted list
    public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right){
        LinkedList<Integer> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()){
            if (left.peek() <= right.peek()){
                result.add(left.poll());
            } else {
               result.add(right.poll());
            }
        }

        // Join the remaining elements back together
        result.addAll(left);
        result.addAll(right);

        return result;
    }
}
