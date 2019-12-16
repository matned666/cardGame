import java.util.LinkedList;
import java.util.List;

public class Hand extends Player{

    private List<Card> hand;

    public Hand(PlayerType player) {
        super(player);
        this.hand = new LinkedList<>();
    }

    public void addCard (Card card){
        hand.add(card);
    }

    public void removeCard (Card card){
        hand.remove(card);
    }

    public List<Card> getHand() {
        return hand;
    }
}
