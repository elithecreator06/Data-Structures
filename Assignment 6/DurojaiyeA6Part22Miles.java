// Name: Emmanuel Durojaiye
// Class: CS 3305/W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 06-Part-2.2-Miles

public class DurojaiyeA6Part22Miles{
    public static void main(String[] args){
        // Array of miles to convert
        int[] milesArray = {0, 10, 20, 30, 40 , 50, 60, 70, 80, 90};
        double kilometersPerMile = 1.6;

        // Convert mile to kilometers and display the result
        for (int miles : milesArray){
            double kilometers = miles *  kilometersPerMile;
            System.out.println(miles + " miles = " + kilometers + " kilometers");
        }
    }
}
