package cinema;

/**
 * This class is used for all methods that automatically do a task without direct user interaction. Any methods
 * that has direct user interaction belongs in cinema methods.
 *
 * @author Krig Raseri
 */

public class cinemaUtility {

    /**
     * Method that returns true if "B" is found in the seating area array. This shows if the seat was bought.
     *
     * @param array represents the initial seating array created in main.
     * @param row represents the row number chosen by user when using buyTicket.
     * @param seat represents the number of the seat chosen by user when using buyTicket.
     * @return returns true if "B" is found in the array(which stands for bought).
     */
    public static Boolean checkSeat(String[][] array, int row, int seat) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == "B") {
                    return true;
                }
            }
        }

        return false;
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
     * Gets the number of tickets sold and returns it as in integer.
     *
     * @param array represents the seating arrangement matrix.
     * @return returns the number of tickets sold.
     */
    public static int getTickets(String [][] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals("B")) {
                    count++;
                }
            }
        }

        return count;

    }

    /**
     * A method that calculates some statistics based on the seating arrangement size(array), the number of rows,
     * seats per row, and total profit from ticket sales.
     *
     * @param array represents the seating arrangement of rows * seats per row.
     * @param rows represents the number of rows of seats picked by user when building the seating arrangement.
     * @param seats represents the number of seats in each row that was already picked by the user at start.
     * @param profits represents the total profits from each ticket sold which is automatically updated per sale.
     *
     * */
    public static void statistics(String[][] array, int rows, int seats, int profits) {
        int nTickets = cinemaUtility.getTickets(array);
        double per = (((float)nTickets / (rows * seats)) * 100.0) ;

        System.out.printf("Percentage:  %.2f%% \n", per);
        System.out.printf("Number of purchased tickets: %d \n", nTickets);
        System.out.println("Total income: $" + profits );

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
