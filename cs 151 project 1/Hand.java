import java.util.Arrays;


/**
 * Comment ME!
 *
 * @Authur Elijah McCray
 * @Authur Matt Clifton
 * Project 1
 */




public class Hand {

    // FIELDS
    private int NUMBEROFCARDS = 5;
    Card[] cards;


    //Constuctor
    public Hand(int NUMBEROFCARDS){
        this.NUMBEROFCARDS = NUMBEROFCARDS;
    }
    // default Constuctor
    public Hand(){
        cards = new Card[this.NUMBEROFCARDS];
    }

    // sets the card.
    public void setCard(int index, Card card){
        cards[index] = card;
    }

    //Get card
    public Card getCard(int index){
        return cards[index];
    }

    /*
     * Return a pair that is of the same value
     * Return: Int value
     */
    public int getPair(){
        int numValue = 0;

        for(int i = 0; i < cards.length - 1; i++) {  
            for(int j = i + 1; j < cards.length - 1; j++) {  
                if(cards[i] == cards[j]){
                    numValue = cards[i].value();
                }  
            }  
        }  
        return numValue;
    }

    /**
     * Return a three of a kind that is of the same value
     * Return: Int value
     */
    public int getThreeKind(){
        int numValue = 0;
        int k = 0;

        for(int i = 0; i < cards.length - 1; i++) {  
            for(int j = i + 1; j < cards.length - 1; j++) {  
                if(cards[i] == cards[j]){
                    k++;
                    if (k == 3){
                        numValue = cards[i].value();
                }   }
            }  
        }  
        return numValue;
    }  

    /**
     * Return a four of a kind that is of the same value
     * Return: Int value
     */
    public int getFourKind(){
        int numValue = 0;
        int k = 0;

        for(int i = 0; i < cards.length - 1; i++) {  
            for(int j = i + 1; j < cards.length - 1; j++) {  
                if(cards[i] == cards[j]){
                    k++;
                    if (k == 4){
                        numValue = cards[i].value();
                }   }
            }  
        }  
        return numValue;
    }  

    /**
     * Return a gets the high card
     * Return: Int value
     */
    public int getHighestCard(){
        int numValue = 0;
        numValue = cards[0].value();

        for(int i = 0; i < cards.length - 1; i++) {  
            for(int j = i + 1; j < cards.length - 1; j++) {  
                if(cards[i] == cards[j]){
                    numValue = cards[i].value();
                }
            }  
        }  
        return numValue;
    }  

    /**
     * if statement to find what kind of deck the cards are
     * Return: WinHand enum
     */
    public WinHand getHandType(){
        if (straightFlush()) {
            return WinHand.STRAIGHT_FLUSH;
        } 
        
        else if (fourOfAKind()) {
            return WinHand.FOUR_OF_A_KIND;
        } 
        
        else if (fullHouse()) {
            return WinHand.FULL_HOUSE;
        } 
        
        else if (flush()) {
            return WinHand.FLUSH;
        } 
        
        else if (straight()) {
            return WinHand.STRAIGHT;
        } 
        
        else if (threeOfAKind()) {
            return WinHand.THREE_OF_A_KIND;
        } 
        
        else if (twoPair()) {
            return WinHand.TWO_PAIR;
        } 
        
        else if (pair()) {
            return WinHand.PAIR;
        } 
        
        else {
            return WinHand.HIGH_CARD;
        }
    }

    /**
     * Cheacks if the cards is a strightflush
     * @return boolean
     */
    public boolean straightFlush(){
        if (cards[0].getName() == Face.ACE && cards[1].getName().getRank() == 2
                    && cards[2].getName().getRank() == 3 && 
                    cards[3].getName().getRank() == 4
                    && cards[4].getName().getRank() == 5) {
                return true;
        }

        /**
         * Check for a regular straight
         * 
         */ 
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getName().getRank() !=
             cards[i - 1].getName().getRank() + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Cheacks if the cards is a stright
     * @return boolean
     */
    public boolean straight(){
        for (int i = 0; i <= cards.length - 3; i++) {
            if (cards[i].getName() == cards[i + 1].getName() &&
             cards[i].getName() ==
                    cards[i + 2].getName()) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * Cheacks if the cards is a three of a kind
     * @return boolean
     */
    public boolean threeOfAKind(){
        for (int i = 0; i <= cards.length - 4; i++) {
            if (cards[i].getName() == cards[i + 1].getName() &&
             cards[i].getName() == cards[i + 2].getName() &&
              cards[i].getName() == cards[i + 3].getName()) {
                return true;
            }
        }
        return false;
    }
    

    /**
     * Cheacks if the cards is a  four of a kind
     * @return boolean
     */
    public boolean fourOfAKind(){
        for (int i = 0; i <= cards.length - 2; i++) {
            if (cards[i].getName() == cards[i + 1].getName()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cheacks if the cards is a pair
     * @return 
     */
    public boolean pair(){
        for (int i = 0; i <= cards.length - 2; i++) {
            if (cards[i].getName() == cards[i + 1].getName()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cheacks if the cards is a two pair
     * @return
     */
    public boolean twoPair(){
        int pairsFound = 0;
        for (int i = 0; i <= cards.length - 2; i++) {
            if (cards[i].getName() == cards[i + 1].getName()) {
                pairsFound++;
                i++; // Move to the next pair
            }
        }
    
        return pairsFound == 2;
    }

    /**
     * Cheacks if the cards is a full house
     * @return
     */
    public boolean fullHouse(){
        if ((cards[0].getName() == cards[1].getName() && cards[0].getName() ==
         cards[2].getName()
        && cards[3].getName() == cards[4].getName())
        || (cards[0].getName() == cards[1].getName() && cards[2].getName() ==
         cards[3].getName()
                && cards[2].getName() == cards[4].getName())) {
            
                return true;
            }

        return false;
    }

    /**
     * Cheacks if the cards is a flush
     * @return
     */
    public boolean flush(){
        for (int i = 1; i < cards.length - 1; i++) {
            if (cards[i].getSuit() != cards[i - 1].getSuit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * to string
     */
    public String toString(){
        return ("0: " + cards[0].value() + "1: " + cards[1].value()  + "2: " +
         cards[2].value() + 
            "3: " + cards[3].value() + "4: " + cards[4].value());
    }

    /**
     * This method will sort a hand into ascending order. Will only work in Java 8 or higher.
     * It makes the assumption that you have an array of N Card elements named 'cards'; cards
     * is a field within this class.
     */
    public void sort() {
        Arrays.sort(cards, (Card u1, Card u2) -> u1.compareTo(u2)); 
    }

}

