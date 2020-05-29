import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

// 
// Decompiled by Procyon v0.5.36
// 

public class Deck
{
    private List<Card> cards;
    private int size;
    
    public Deck(final String[] ranks, final String[] suits, final int[] pointValues) {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < ranks.length; ++i) {
            for (int s = 0; s < suits.length; ++s) {
                ++this.size;
                final Card obj = new Card(ranks[i], suits[s], pointValues[i]);
                this.cards.add(obj);
            }
        }
        Collections.shuffle(this.cards);
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public void shuffle() {
    }
    
    public void randomShuffle() {
        Collections.shuffle(this.cards);
    }
    
    public Card deal() {
        if (this.size > 0) {
            --this.size;
            Collections.shuffle(this.cards);
            return this.cards.get(this.size);
        }
        return null;
    }
    
    @Override
    public String toString() {
        String rtn = "size = " + this.size + "\nUndealt cards: \n";
        for (int k = this.size - 1; k >= 0; --k) {
            rtn = String.valueOf(rtn) + this.cards.get(k);
            if (k != 0) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((this.size - k) % 2 == 0) {
                rtn = String.valueOf(rtn) + "\n";
            }
        }
        rtn = String.valueOf(rtn) + "\nDealt cards: \n";
        for (int k = this.cards.size() - 1; k >= this.size; --k) {
            rtn = String.valueOf(rtn) + this.cards.get(k);
            if (k != this.size) {
                rtn = String.valueOf(rtn) + ", ";
            }
            if ((k - this.cards.size()) % 2 == 0) {
                rtn = String.valueOf(rtn) + "\n";
            }
        }
        rtn = String.valueOf(rtn) + "\n";
        return rtn;
    }
}
