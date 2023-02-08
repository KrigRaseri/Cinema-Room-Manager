package cinema;

public class cinemaUtility {
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
}
