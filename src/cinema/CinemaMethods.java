package cinema;

import java.util.Scanner;

public class CinemaMethods {
    /**
     * Method used at program start that takes the user chosen integers for rows and seats to fill a 2d array with "S"
     * that represents seat. This creates a row x seats sized seating map.
     *
     * @param array represents the initial seating array created in main.
     * @param row represents the number of rows chosen in main.
     * @param seat represents the number of seats in a row chosen in main.
     **/

    public static void createSeats(String[][] array, int row, int seat) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                array[i][j] = "S";
            }
        }
    }

    /**
     * Method to chose a seat based off of the initial seating arrangement size of rows x seats. Outputs the price
     * of the chosen seat and updates the initial array to replace the "S" in the chosen position with a "B" for bought.
     *
     * @param array represents the initial seating array created in main.
     * @param row represents the number of rows chosen in main.
     * @param seats represents the number of seats in a row chosen in main.
     * */
    public static int buyTicket(String[][] array, int row, int seats) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a row number: ");
        int rowBuy = sc.nextInt();
        System.out.print("Enter a seat number in that row: ");
        int seatBuy = sc.nextInt();
        int profits = 0;


        //If total amount of seats is less than or equal to 60 then seats are 10$ each.
        if (row * seats <= 60) {
            System.out.println("Ticket price: $10");
            array[rowBuy-1][seatBuy-1] = "B";
            profits += 10;
        }

        //More than 60 seats and even, then front half 10$ per seat, back half 8$ per seat.
        else if (row * seats > 60 && row % 2 == 0) {
            if (rowBuy <= row/2){
                System.out.println("Ticket price: $10");
                profits += 10;

            }

            else {
                System.out.println("Ticket price: $8");
                profits += 8;

            }
            array[rowBuy-1][seatBuy-1] = "B";



        }

        //More than 60 seats and odd, then the even front half 10$ and the odd back half 8$.
        else if (row * seats > 60 && row % 2 != 0) {
            if (rowBuy <= row/2) {
                System.out.println("Ticket price: $10");
                profits += 10;
            }

            else {
                System.out.println("Ticket price: $8");
                profits += 8;
            }
            array[rowBuy-1][seatBuy-1] = "B";
        }

        printSeats(array, row, seats);
        return profits;
    }
}
