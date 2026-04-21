import java.util.Scanner;

public class DeckOfCards {
    static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        
        return deck;
    }
    
    static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        
        return deck;
    }
    
    static String[][] distributeDeck(String[] deck, int numCards, int numPlayers) {
        if (numCards > deck.length || numCards <= 0) {
            System.out.println("Invalid number of cards");
            return null;
        }
        
        if (numCards % numPlayers != 0) {
            System.out.println("Cannot distribute " + numCards + " cards equally among " + numPlayers + " players");
            return null;
        }
        
        int cardsPerPlayer = numCards / numPlayers;
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        
        return players;
    }
    
    static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);
        
        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        
        System.out.print("Enter number of cards to distribute: ");
        int numCards = sc.nextInt();
        
        String[][] players = distributeDeck(deck, numCards, numPlayers);
        
        if (players != null) {
            System.out.println();
            printPlayers(players);
        }
        
        sc.close();
    }
}
