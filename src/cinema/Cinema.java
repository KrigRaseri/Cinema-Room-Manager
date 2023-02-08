package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        //Sets up an array for seating and asks for user input for rows and seats.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        final int row = sc.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        final int seat = sc.nextInt();
        String[][] arr = new String[row][seat];



        //Method calls
        cinemaMethods.initialize(arr, row, seat);


    }
}
