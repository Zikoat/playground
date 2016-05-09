package com.mygdx.game;

/**
 * Created by zik on 09.02.16.
 */
public class Deck {
    public static int numOfSuits = 4;
    public static int numOfRanks = 13;
    public int numOfCards = numOfSuits * numOfRanks;

    private Card[][] cards;

    public Deck() {
        cards = new Card[numOfSuits][numOfCards];
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[suit-1][rank-1] = new Card(rank, suit);
            }
        }
    }

    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }

}
