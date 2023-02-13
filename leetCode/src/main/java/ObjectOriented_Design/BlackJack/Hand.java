package ObjectOriented_Design.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    如何表示手牌（玩家手中的牌）？
    Hand: Card[] or List<Card>
        - int score()
        - void addCard(card)
 */
public class Hand {
    protected final List<Card> cards = new ArrayList<>();
    // 这里的final 是保持 reference不变，cards的内容随便改
    // protect => 包类，和子类 可见

    public int score() { // or we can define an abstract method here, i.e. no implementation for score()
        int score = 0;
        for (Card card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }

    public int size() {
        return cards.size();
    }
}
