import java.awt.Component;
import javax.swing.JOptionPane;

public class Main
{
    // INSTANCE VARIABLES
    private static int loss;
    private static int wins;
    private static Card card;
    private static Card card2;
    private static int cardCount;
    static String[] Rank;
    static int[] pointValue;
    static String[] Suit;
    static String[] option1;
    // This is just a way to have all the variables inside be static.
    static {
        Main.Rank = new String[] { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        Main.pointValue = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        Main.Suit = new String[] { "Clubs", "Diamond", "Spades", "Hearts" };
        Main.option1 = new String[] { "Higher", "Lower", "Exit" };
    }
    
    // MAIN METHOD
    /*
     * This method begins the game with losses and wins at 0 before welcoming the user to high low.
     * The game begins and the player is told their card and they can select higher or lower.
     * The game tracks the correct amount of guesses, as well as the amount of mistakes.
     * At 5 mistakes, the player loses. If the player goes through all 52 cards, they win. 
     */
    public static void main(final String[] args) {
        Main.loss = 0;
        Main.wins = 0;
        Main.cardCount = 0;
        JOptionPane.showMessageDialog(null, "                      Welcome, player!\n             The game, High-Low is easy to play.\nYour job is to check if the current card is higher or lower than the next card.\n             If you get five wrong then you're out... so it's a little nicer than baseball.\n              If you clear the deck, you win the whole game... good luck! \n                                        Lets play!");
        final Deck deck = new Deck(Main.Rank, Main.Suit, Main.pointValue);
        while (Main.cardCount < 26 && Main.loss < 5) {
            Main.card = deck.deal();
            Main.card2 = deck.deal();
            final int x = Window.option(Main.option1, "Will this card be higher or lower? \nCorrect guesses: " + Main.wins + "\n" + Main.card);
            if (x == 0) {
                if (Main.card.pointValue() == Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Same card value... this counts as a miss... \n (It doesn't)");
                    Main.wins = Main.wins;
                }
                else if (Main.card.pointValue() > Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "You're correct! Other card is " + Main.card2);
                    ++Main.wins;
                }
                else {
                    JOptionPane.showMessageDialog(null, "You're wrong. Other card is " + Main.card2);
                    ++Main.loss;
                }
            }
            if (x == 1) {
                if (Main.card.pointValue() == Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Same card value... this counts as a miss... \n (It doesn't)");
                }
                if (Main.card.pointValue() < Main.card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "You're correct! Other card is " + Main.card2);
                    ++Main.wins;
                }
                else {
                    JOptionPane.showMessageDialog(null, "You're wrong. Other card is " + Main.card2);
                    ++Main.loss;
                }
            }
            if (x == 2) {
                System.exit(0);
            }
        }
        if (Main.loss == 5) {
            JOptionPane.showMessageDialog(null, "You got five wrong... it's the end of the line for you! \n Correct guesses: " + Main.wins);
        }
        if (Main.cardCount == 26) {
            JOptionPane.showMessageDialog(null, "Impossible! How'd you get through all 52 cards... and you only got " + Main.loss + " wrong! \n" + "                             Good job");
        }
    }
}
