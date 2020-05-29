public class Card
{
    // INSTANCE VARIABLES
    private String suit;
    private String rank;
    private int pointValue;
    
    // GETTERS
    public String suit() {
        return this.suit;
    }
    
    public String rank() {
        return this.rank;
    }
    
    public int pointValue() {
        return this.pointValue;
    }
    
    // CONSTRUCTOR
    public Card(final String cardRank, final String cardSuit, final int cardPointValue) {
        this.rank = cardRank;
        this.suit = cardSuit;
        this.pointValue = cardPointValue;
    }
    // This method checks if a card matches another card by comparing their point value, suit, and rank.
    public boolean matches(final Card otherCard) {
        return this.suit.equals(otherCard.suit) && this.pointValue == otherCard.pointValue && this.rank.equals(otherCard.rank);
    }
    
    // This method takes the suit and rank of the card and changes it to a 
    @Override
    public String toString() {
        return String.valueOf(this.rank) + " of " + this.suit;
    }
}
