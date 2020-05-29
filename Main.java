import java.awt.Component;
import javax.swing.JOptionPane;

// 
// Decompiled by Procyon v0.5.36
// 

public class Main
{
    private static int loss;
    private static int wins;
    private static Card card;
    private static Card card2;
    private static int cardCount;
    static String[] Rank;
    static int[] pointValue;
    static String[] Suit;
    static String[] option1;
    
    static {
        Main.Rank = new String[] { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        Main.pointValue = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        Main.Suit = new String[] { "Clubs", "Diamond", "Spades", "Hearts" };
        Main.option1 = new String[] { "Higher", "Lower", "Exit" };
    }
    
    public static void main(final String[] args) {
        Main.loss = 0;
        Main.wins = 0;
        Main.cardCount = 0;
        JOptionPane.showMessageDialog(null, "                      Welcome to High-LO!\n                        The game is real simple\nJust check if the current card is higher or lower than the next card.\n             If you get five guesses wrong it's curtains for you\n              If you clear the deck, you win the whole game \n                                        Lets play!");
        final Deck deck = new Deck(Main.Rank, Main.Suit, Main.pointValue);
        while (Main.cardCount < 26 && Main.loss < 5) {
            Main.card = deck.deal();
            Main.card2 = deck.deal();
            final int x = Window.option(Main.option1, "Do you think this card will be higher or lower than the next one?\nCorrect guesses: " + Main.wins + "\n" + Main.card);
            if (x == 0) {
                if (Main.card.pointValue() == Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "ULTRA RARE! SAME CARD VALUE!!!!\nNothing happens lol");
                    Main.wins = Main.wins;
                }
                else if (Main.card.pointValue() > Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Right :D ! Other card is " + Main.card2);
                    ++Main.wins;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong ;( . Other card is " + Main.card2);
                    ++Main.loss;
                }
            }
            if (x == 1) {
                if (Main.card.pointValue() == Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "ULTRA RARE! SAME CARD VALUE!!!!\nNothing happens lol");
                }
                if (Main.card.pointValue() < Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Right :D ! Other card is " + Main.card2);
                    ++Main.wins;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong ;( . Other card is " + Main.card2);
                    ++Main.loss;
                }
            }
            if (x == 2) {
                System.exit(0);
            }
        }
        if (Main.loss == 5) {
            JOptionPane.showMessageDialog(null, "You got Five Wrong, You lose! \n Do better next time kid \nCorrect guesses: " + Main.wins);
        }
        if (Main.cardCount == 26) {
            JOptionPane.showMessageDialog(null, "You done did it! You went through all 52 cards and got " + Main.loss + " wrong! \n" + "                             Good job");
        }
    }
}
