

/**
 * Comment ME!
 *
 * @Authur Elijah McCray
 * @Authur Matt Clifton
 * Project 1
 */

public enum WinHand{
    STRAIGHT_FLUSH("straight flush"), // contains five cards of sequential rank, one of them is a high card.
    FOUR_OF_A_KIND("four of a kind"), // four cards of one rank and one card of another rank.
    FULL_HOUSE("full house"), // three cards of one rank and two cards of another rank.
    FLUSH("flush"), // contains five cards all of the same suit.
    STRAIGHT("straight"), // contains five cards of sequential rank.
    THREE_OF_A_KIND("three of a kind"), // three cards of one rank.
    TWO_PAIR("two pair"), // two cards of one rank, two cards of another rank and one card of a third rank.
    PAIR("pair"), // contains two cards of one rank and three cards of three other ranks.
    HIGH_CARD("high card"); // no pair.

    /**
     * feld
     */
    private final String name;

    /**
     * connstuctor
     * @param name
     */
    private WinHand(String name){
        this.name = name;
    }
    /**
     * gets name
     * @return name
     */
    public String getName(){
        return this.name;
    }
    /**
     * to string
     */
    public String toString(){
        return "";
    }

}
