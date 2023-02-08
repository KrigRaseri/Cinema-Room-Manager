package cinema;

import java.util.Scanner;

/**
 * This class is used for all methods that are interacted with by the user, any methods that are not directly
 * interaction with bu user belong in cinema utility's.
 *
 * @author Krig Raseri
 */

public class cinemaMethods {

    /**
     * Initializes the program by calling createSeats to use the user chosen rows and seats to build the seating
     * arrangement, and then keeps asking the user for input to perform various tasks, or to end the program.
     *
     * @param array represents the initial seating array created in main.
     * @param row represents the number of rows chosen in main.
     * @param seat represents the number of seats in a row chosen in main.
     *
     * */
    public static void initialize(String[][] array, int row, int seat) {
        cinemaUtility.createSeats(array, row, seat);
        int profits = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Show the seats
                    2. Buy a ticket
                    3. Statistics
                    0. Exit""");

            int input = sc.nextInt();
            if (input == 0) {break;}

            switch (input) {
                case 1 -> cinemaUtility.printSeats(array, row, seat);
                case 2 -> profits += cinemaMethods.buyTicket(array, row, seat);
                case 3 -> cinemaUtility.statistics(array, row, seat, profits);
                default -> System.out.println("Try again");
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

        while (cinemaUtility.wrongInput(array, rowBuy, seatBuy)) {
            System.out.println("Wrong input!");

            System.out.print("Enter a row number: ");
            rowBuy = sc.nextInt();
            System.out.print("Enter a seat number in that row: ");
            seatBuy = sc.nextInt();

        }


        while (cinemaUtility.checkSeat(array, rowBuy, seatBuy)) {
                System.out.println("That ticket has already been purchased");

                System.out.print("Enter a row number: ");
                rowBuy = sc.nextInt();
                System.out.print("Enter a seat number in that row: ");
                seatBuy = sc.nextInt();
            }




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

        cinemaUtility.printSeats(array, row, seats);
        return profits;
    }


}
