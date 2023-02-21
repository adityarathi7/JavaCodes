import java.util.Scanner;

/**
 * A class representing a game where contestants are eliminated based on song stop times
 */
public class CircularGame {

    /**
     * Returns the index of the winner in a circular elimination game
     * @param contestants An array of contestant names
     * @param songStops An array of song stop times in seconds
     * @return The index of the winner
     */
    public static int getWinnerIndex(String[] contestants, int[] songStops) {
        int contestantsLeft = contestants.length;

        int contestantIndex = 0;
        int timeIndex = 0;
        int currCount = 0;

        while (contestantsLeft > 1) {
            contestantIndex = (contestantIndex + 1) % contestants.length;

            if (contestants[contestantIndex] != null) {
                currCount++;
            }
            if (currCount == songStops[timeIndex]) {
                System.out.println("Contestant: " + contestants[contestantIndex] + " at index: " + timeIndex + " has been eliminated");
                contestants[contestantIndex] = null;
                currCount = -1;
                contestantsLeft--;
                timeIndex = (timeIndex + 1) % songStops.length;
            }
            if (contestantsLeft == 1) {
                break;
            }
        }

        int result = -1;
        for (int i = 0; i < contestants.length; i++) {
            if (contestants[i] != null) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * The main function that accepts user inputs and runs the game
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Contestants:");
        int contestantLen = sc.nextInt();
        sc.nextLine();

        String[] contestants = new String[contestantLen];
        for (int i = 0; i < contestantLen; i++) {
            contestants[i] = sc.nextLine();
        }

        System.out.println("Enter number of StopTimes:");
        int stopLen = sc.nextInt();
        sc.nextLine();

        int[] songStops = new int[stopLen];
        for (int i = 0; i < stopLen; i++) {
            songStops[i] = sc.nextInt();
        }

        int winnerIndex = getWinnerIndex(contestants, songStops);
        System.out.println("Winner Index: " + winnerIndex);

        sc.close();
    }
}
