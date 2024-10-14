
/**
 * Comment ME!
 *
 * @Authur Elijah McCray
 * @Authur Matt Clifton
 * Project 1
 */

 /**
  * Holds the name, value, and rank of the cards.
  */
public enum Face{
    ACE("ace",1, 1),
    TWO("two",2, 2),
    THREE("three",3 , 3),
    FOUR("four", 4,4),
    FIVE("five",  5, 5),
    SIX("six", 6, 6),
    SEVEN("seven",7, 7),
    EIGHT("eight",8, 8),
    NINE("nine", 9, 9),
    TEN("ten",10,10),
    JACK("jack", 10, 11),
    QUEEN("queen",10, 12),
    KING("king",10, 13);


    /**
     * Felds
    */
    private final String name;
    private final int value;
    private final int rank;

    /**
     * Constuctor
     * @param name
     * @param value
     * @param rank
     */
    private Face(String name, int value, int rank){
        this.name = name;
        this.value = value;
        this.rank = rank;
    }
    /**
     * method to get name
     * @return name
     */
    public String getName(){
        return this.name;
    }
    /**
     * method to get value
     * @return value
     */
    public int value(){
        return this.value;
    }
    /**
     * method to get the rank
     * @return rank
     */
    public int getRank(){
         return this.rank;
    }
    /**
     * string.
     */
    public String toString(){
        return this.name;

    }

}
