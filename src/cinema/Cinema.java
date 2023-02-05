package cinema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinema {
    public static void main(String[] args) {

        //Prints a 8x7 grid representing seats in a cinema.
        System.out.println("Cinema:");
        System.out.println(" 1 2 3 4 5 6 7 8");
        for (int i = 1; i < 8; i++) {
            System.out.println(i + " S S S S S S S S");

        }

        ticketIncome();


    }

    /*
    * Method that prompts the user the number of rows, and the number of seats per row. It then will calculate the
    * amount of total income from all seats based on certain parameters.
    *
    * */
    public static void ticketIncome() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows;
        int nSeats;

        try {
            System.out.print("Enter the number of rows: ");
            rows = Integer.parseInt(reader.readLine());

            System.out.print("Enter the number of seats in each row: ");
            nSeats = Integer.parseInt(reader.readLine());

            //If total amount of seats is less than or equal to 60 then seats are 10$ each.
            if (rows * nSeats <= 60) {
                System.out.println("Total income:");
                System.out.println("$" + rows * nSeats * 10);
            }

            //More than 60 seats and even, then front half 10$ per seat, back half 8$ per seat.
            else if (rows % 2 == 0) {
                System.out.println("Total income:");
                int total = rows/2 * nSeats;
                System.out.println("$" + ((total * 10) + (total * 8)));

            }

            //More than 60 seats and odd, then the even front half 10$ and the odd back half 8$.
            else {
                System.out.println("Total income:");
                int totalFront = (rows/2 * nSeats) * 10;
                int totalBack = ((rows/2 + 1) * nSeats) * 8;
                System.out.println("$" + (totalFront + totalBack));

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
