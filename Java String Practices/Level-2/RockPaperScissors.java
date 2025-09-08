import java.util.Scanner;

public class RockPaperScissors {
    public static String computerChoice() {
        String[] options = {"rock", "paper", "scissors"};
        return options[(int)(Math.random() * 3)];
    }
    public static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "User";
        return "Computer";
    }
    public static String[][] calculateStats(int userWins, int compWins, int draws, int total) {
        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", 100.0 * userWins / total) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", 100.0 * compWins / total) + "%";

        return stats;
    }
    public static void displayResults(String[] userMoves, String[] compMoves, String[] winners, String[][] stats) {
        System.out.println("Game | User Choice | Computer Choice | Winner");
        for (int i = 0; i < userMoves.length; i++) {
            System.out.printf("%4d | %11s | %15s | %6s\n", i+1, userMoves[i], compMoves[i], winners[i]);
        }
        System.out.println("Player   Wins  Win Percentage");
        System.out.println(stats[0][0] + "    " + stats[0][1] + "    " + stats[0][2]);
        System.out.println(stats[1][0] + "  " + stats[1][1] + "    " + stats[1][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] userMoves = new String[n];
        String[] compMoves = new String[n];
        String[] winners = new String[n];
        int userWins = 0, compWins = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your move (rock/paper/scissors) for game " + (i+1) + ": ");
            String user = sc.nextLine().toLowerCase();
            String comp = computerChoice();
            String win = findWinner(user, comp);
            userMoves[i] = user;
            compMoves[i] = comp;
            winners[i] = win;

            if (win.equals("User")) userWins++;
            else if (win.equals("Computer")) compWins++;
            else draws++;
        }

        String[][] stats = calculateStats(userWins, compWins, draws, n);
        displayResults(userMoves, compMoves, winners, stats);
    }
}
