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
        initialize(arr, row, seat);


    }



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
        createSeats(array, row, seat);
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
                case 1 -> printSeats(array, row, seat);
                case 2 -> profits += ticketPrice(array, row, seat);
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
    public static int ticketPrice(String[][] array, int row, int seats) {
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

    /**
     * Prints out the seating arrangement that was setup at the program start.
     *
     * @param array represents the initial seating array created in main.
     * @param row represents the number of rows chosen in main.
     * @param seats represents the number of seats in a row chosen in main.
    * */
    public static void printSeats(String[][] array, int row, int seats) {
        //Prints out the seating arrangement.
        System.out.println("Cinema: ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

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
    * Method that calculates the total income if all seats are purchased based on the number of rows and seats.
    */
    public static String ticketIncome(int rows, int seats) {
            String result = "";

            //If total amount of seats is less than or equal to 60 then seats are 10$ each.
            if (rows * seats <= 60) {
                result = ("$" + (rows * seats * 10));
            }

            //More than 60 seats and even, then front half 10$ per seat, back half 8$ per seat.
            else if (rows % 2 == 0) {
                int total = rows/2 * seats;
                result = ("$" + ((total * 10) + (total * 8)));

            }

            //More than 60 seats and odd, then the even front half 10$ and the odd back half 8$.
            else {
                int totalFront = (rows/2 * seats) * 10;
                int totalBack = ((rows/2 + 1) * seats) * 8;
                result = ("$" + (totalFront + totalBack));

            }

            return result;
        }




}
