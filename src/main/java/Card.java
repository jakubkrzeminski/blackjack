public class Card {
    Rank rank;
    Suit suit;
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getCardValue() {
        return rank.getValue();
    }

    public String toString() {
        return rank.getRank() + " " + suit.getSymbol();
    }

    public boolean equals(Rank rank, Suit suit) {
        return (this.rank == rank && this.suit == suit);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
