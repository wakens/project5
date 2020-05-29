// 
// Decompiled by Procyon v0.5.36
// 

public class Card
{
    private String suit;
    private String rank;
    private int pointValue;
    
    public Card(final String cardRank, final String cardSuit, final int cardPointValue) {
        this.rank = cardRank;
        this.suit = cardSuit;
        this.pointValue = cardPointValue;
    }
    
    public String suit() {
        return this.suit;
    }
    
    public String rank() {
        return this.rank;
    }
    
    public int pointValue() {
        return this.pointValue;
    }
    
    public boolean matches(final Card otherCard) {
        return this.suit.equals(otherCard.suit) && this.pointValue == otherCard.pointValue && this.rank.equals(otherCard.rank);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.rank) + " of " + this.suit;
    }
}
