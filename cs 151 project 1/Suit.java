
/**
 * Comment ME!
 *
 * @Authur Elijah McCray
 * @Authur Matt Clifton
 * Project 1
 */

/**
 * constuctor
 */
public enum Suit{
    HEARTS("hearts"),
    DIAMONDS("diamonds"),
    CLUBS("clubs"),
    SPADES("spades");

    /**
     * feld
     */
    private final String type;

    /**
     * gets Suit
     * @param type
     */
    private Suit(String type){
        this.type = type;
    }
    /**
     * gets Type
     * @return type
     */
    public String getType(){
        return this.type;
    }
    /**
     * to string
     */
    public String toString(){
        return this.type;
    }
}

