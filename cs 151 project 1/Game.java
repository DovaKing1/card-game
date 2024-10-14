
/**
 * Comment ME!
 *
 * @Authur Elijah McCray
 * @Authur Matt Clifton
 * Project 1
 */

/**
 * Imports.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    
        /**
         * type of cards, color, and card number.
         * Felds 
         */
    private static final int NUMCARD = 5;
    private static final int NUM_CARDS_IN_HAND = 5;
    private static final int Deck_Size = 53;
    private Card [] deck;
    private static Hand CardPLayer;
    private static Hand cardComputer;
    private Random rand;

    /**
     * Construtor for the class.
     * @param cardPLayer
     * @param cardComputer
     */
    public Game(Hand cardPLayer, Hand cardComputer){
        this.CardPLayer = cardPLayer;
        this.cardComputer = cardComputer;
        this.deck = new Card[Deck_Size];
        this.rand = new Random();
    }

    /**
     * Shuffles the card deck
     */
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

        
            Card temp = deck[i]; 
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Builds the card deck.
     */
    private void buildDeck(){
        int index = 0;
        for (Suit suit : Suit.values()){
            for (Face face : Face.values()){
                deck[index] = new Card(face,suit);
                index++;
            }
        }
    }
    /**
     * Displays the cards on the screen.
     * @param currentHand
     * 
     */
    public void displayDeck(Hand currentHand) {

        for(int i = 0; i < NUM_CARDS_IN_HAND; i++){
            Card card = currentHand.getCard(i);
            System.out.print(i + ": " + card.toString()+  "\n");
        }
    }
    /**
     * Deals the cards to the player and computer.
     */
    public void deal() {
        for (int i = 0; i < NUMCARD; i++) {
            CardPLayer.setCard(i, deck[i]);
            cardComputer.setCard(i, deck[i + NUM_CARDS_IN_HAND]);
        }
    }
    /**
     * calls all the needed methods.
     * @param index
     * @param Hand
     */
    public void dealOne(int index, Hand Hand) {
        Hand.setCard(index, deck[index + NUM_CARDS_IN_HAND]);
    }
    public void go() {
        buildDeck();
        shuffle();
        deal();
        System.out.println("Player:");
        displayDeck(CardPLayer);
    }

    /**
     * Prints what type of win and prints the cards on the termonal. 
     */
    public void printWinner() {
        WinHand playerHandType = CardPLayer.getHandType();
        WinHand computerHandType = cardComputer.getHandType();

        System.out.println("\nPlayer:");
        displayDeck(CardPLayer);
        System.out.println("\nComputer:");
        displayDeck(cardComputer);

        if (playerHandType.ordinal() > computerHandType.ordinal()) {
            System.out.println("Player wins with a " + playerHandType.getName() + "!");
        } else if (playerHandType.ordinal() < computerHandType.ordinal()) {
            System.out.println("Computer wins with a " + computerHandType.getName() + "!");
        } else {
            int playerHighCard = CardPLayer.getHighestCard();
            int computerHighCard = CardPLayer.getHighestCard();

            if (playerHighCard > computerHighCard) {
                System.out.println("\nPlayer wins with a high card!");
            } else if (playerHighCard < computerHighCard) {
                System.out.println("\nComputer wins with a high card!");
            } else {
                System.out.println("\nIt's a tie!");
            }
        }
    }

    /**
     * Prints and takes the number and which cards to discard.
     */
    public static void main(String agrs[]) {
        Scanner scanner = new Scanner(System.in);
        Hand CardPLayer = new Hand();
        Hand cardComputer = new Hand();
        Game game = new Game(CardPLayer, cardComputer);
        game.go();
        System.out.print("\nHow many cards do you want to discard >");
        int numDiscards = scanner.nextInt();
        System.out.print("Which card do you want to discard >");
        for (int i = 0; i < numDiscards; i++) {
            int discardIndex = scanner.nextInt();
            game.dealOne(discardIndex, CardPLayer);
        }
        game.printWinner();

        scanner.close();
    }

}
