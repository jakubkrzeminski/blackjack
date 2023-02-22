import java.util.Random;

public class BlackjackEngine {

    private int handValue = 0;
    private int mode = 0;

    private String playerCardsInfo = "";
    private String dealerCardsInfo = "";

    private Card currentCard = null;
    private Random random = new Random();

    private void generalHit() {
        Rank rank = null;
        Suit suit = null;
        while (UsedCards.contains(rank, suit)) {
            int rankIndex = random.nextInt(13);
            rank = Rank.values()[rankIndex];
            int suitIndex = random.nextInt(4);
            suit = Suit.values()[suitIndex];
        }
        Card card = new Card(rank, suit);
        UsedCards.add(card);
        currentCard = card;

        if (rank == Rank.ACE && handValue < 11) {
            handValue += 11;
        } else {
            handValue += card.getCardValue();
        }
    }

    private void dealerTurn() {
        BlackjackEngine dealer = new BlackjackEngine();
        boolean playerWin;
        while (true) {
            int dealerHandValue = dealer.getHandValue();
            int playerHandValue = this.getHandValue();

            if (dealerHandValue < playerHandValue) {
                dealer.generalHit();
                dealerCardsInfo += String.format("%s\n", dealer.getCurrentCard());
                continue;
            } else if (dealerHandValue == playerHandValue) {
                mode = 2;
            } else {
                if (dealerHandValue > 21) {
                    mode = 2;
                } else {
                    mode = 1;
                }
            }
            dealerCardsInfo += String.format("Dealer's hand value: %d", dealer.getHandValue());
            break;
        }
    }

    public int getHandValue() {
        return handValue;
    }

    public int getMode() {
        return mode;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public String getPlayerCardsInfo() {
        return playerCardsInfo;
    }

    public String getDealerCardsInfo() {
        return dealerCardsInfo;
    }

    public void hit() {
        generalHit();
        if (handValue > 21) {
            mode = 1;
        } else if (handValue == 21) {
            mode = 2;
        }
        playerCardsInfo = String.format("%s\nYour hand value: %d", this.getCurrentCard(), this.getHandValue());
    }

    public void stand() {
        dealerTurn();
    }

}
