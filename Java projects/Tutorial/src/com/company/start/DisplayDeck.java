package com.company.start;

/**
 * Created by zik on 10.02.16.
 */
public class DisplayDeck {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++){
                Card card = deck.getCard(suit, rank);
                System.out.println(card.rankToString(card.getRank()) + " of " + card.suitToString(card.getSuit()));
            }
            System.out.println();
        }
    }
}
