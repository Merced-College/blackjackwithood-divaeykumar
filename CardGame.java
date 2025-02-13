// Name: Divaey Kumar, Maryam Badalyengejeh
// Professor: Kathleen Kanemoto
// Class: CPSC-39-10106
// Date: February 7, 2025

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {

    private static ArrayList<Card> deckOfCards = new ArrayList<>();
    private static ArrayList<Card> playerCards = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = null;
        try {
            input = new Scanner(new File("cards.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();
            return;
        }

        // Read file and populate deck
        while (input.hasNext()) {
            String[] fields = input.nextLine().split(",");
            Card newCard = new Card(fields[0], fields[1].trim(),
                    Integer.parseInt(fields[2].trim()), fields[3].trim());
            deckOfCards.add(newCard);
        }
        input.close();

        // Start game loop
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) { //Changed the shuffle deck feature and added some extra features to the shuffle, this feature is to have the option for the user to play again
            shuffleDeck();

            // Clear previous round's hand
            playerCards.clear();

            // Deal 
            if (deckOfCards.size() < 5) { //Instead of the deck size being only 4, now it is 5
                System.out.println("Not enough cards left! Game over."); //This command prevents the cards from running out
                break;
            }
            for (int i = 0; i < 5; i++) {
                playerCards.add(deckOfCards.remove(0)); // Take from top after shuffle and doesn't run into any complications when the shuffling deck
            }

            // Show player's hand
            System.out.println("\nPlayer's hand:");
            for (Card c : playerCards) {
                System.out.println(c);
            }

            // Check for a pair
            System.out.println("Pairs found: " + (checkFor2Kind() ? "Yes!" : "No"));

            // Gives a option the user to play again
            System.out.print("\nDraw a new hand? (yes/no): "); 
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static void shuffleDeck() {
        Collections.shuffle(deckOfCards);  //This is a method call using the Fisher-Yates algorithm and allows for a better random shuffle
    }

    public static boolean checkFor2Kind() {
        // Count occurrences of each rank
        ArrayList<String> seenRanks = new ArrayList<>();
        for (Card card : playerCards) {
            if (seenRanks.contains(card.getRank())) { //This helps to see if the player has two cards of the same rank in their hand when the cards are drawn
                return true; // Found a pair
            }
            seenRanks.add(card.getRank());
        }
        return false;
    }
}
