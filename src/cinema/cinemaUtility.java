package cinema;

public class cinemaUtility {
    public static int getTickets(String [][] array) {
        int count = 0;

        for (String[] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("B")) {
                    count++;
                }
            }
        }

        return count;

    }
}
