import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static String getComputerChoice() {
        Random rand = new Random();
        int choice = rand.nextInt(3);
        
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
    
    static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        }
        
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }
    
    static String[][] calculateStats(int playerWins, int computerWins, int total) {
        String[][] stats = new String[2][2];
        
        double playerPercent = (playerWins * 100.0) / total;
        double computerPercent = (computerWins * 100.0) / total;
        
        stats[0][0] = "Player";
        stats[0][1] = playerPercent + "%";
        stats[1][0] = "Computer";
        stats[1][1] = computerPercent + "%";
        
        return stats;
    }
    
    static void displayResults(String[] playerChoices, String[] computerChoices, String[] winners, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tPlayer\t\tComputer\tWinner");
        System.out.println("----\t------\t\t--------\t------");
        
        for (int i = 0; i < playerChoices.length; i++) {
            System.out.println((i + 1) + "\t" + playerChoices[i] + "\t\t" + computerChoices[i] + "\t\t" + winners[i]);
        }
        
        System.out.println("\nStats:");
        System.out.println("Player\t\tComputer");
        System.out.println("Player wins: " + stats[0][1] + "\t\tComputer wins: " + stats[1][1]);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of games: ");
        int numGames = sc.nextInt();
        sc.nextLine();
        
        String[] playerChoices = new String[numGames];
        String[] computerChoices = new String[numGames];
        String[] winners = new String[numGames];
        
        int playerWins = 0;
        int computerWins = 0;
        
        for (int i = 0; i < numGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = sc.nextLine();
            
            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);
            
            playerChoices[i] = playerChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;
            
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }
        
        String[][] stats = calculateStats(playerWins, computerWins, numGames);
        displayResults(playerChoices, computerChoices, winners, stats);
        
        sc.close();
    }
}
