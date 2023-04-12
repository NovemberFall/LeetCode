package OO_Design.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    Functionalities:
    1. shuffle()   洗牌
    2. dealHand()  发牌
 */
public class Deck { // 牌堆
    private static final Random random = new Random();

    private final List<Card> cards = new ArrayList<>(); // or Card[]
    private int dealtIndex = 0;

    public Deck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i <= cards.size() - 1; i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    private int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public Card[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        Card[] cards = new Card[number];
        for (int i = 0; i < number; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    private Card dealCard() { // 看看有没有剩余的牌，有的话就往下摸排，否则null
        return remainingCards() == 0 ? null : cards.get(dealtIndex++);
    }
}
