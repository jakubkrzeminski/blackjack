import java.util.ArrayList;

public class UsedCards {

    static private ArrayList<Card> usedCards = new ArrayList<>();

    public static ArrayList getUsedCards() {
        return usedCards;
    }

    public static void add(Card card) {
        usedCards.add(card);
    }

    public static boolean contains(Rank rank, Suit suit) {
        boolean result = false;
        if (rank == null && suit == null) {
            result = true;
        } else {
            for (Card card : usedCards) {
                if (card.getRank() == rank && card.getSuit() == suit) {
                    result = true;
                }
            }
        }
        return result;

    }

}
