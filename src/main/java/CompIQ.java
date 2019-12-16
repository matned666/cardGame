import java.util.*;

public class CompIQ {

    private Deal deal;
    private Hand hand;

    public CompIQ(Deal deal, Hand hand) {
        this.hand = hand;
        this.deal = deal;
    }

    public List<Card> tempHand() {
        List<Card> tempHand = new LinkedList<>();
        for (Card el : this.hand.getHand()) {
            tempHand.add(el);
        }
        return tempHand;
    }


    public List<Card> possibleThrows() {
        List<Card> possibleThrows = new LinkedList<>();
        Card currentTopStockCard = deal.getTopCard();

        for (Card el : tempHand()) {
            if (el.getColor().equals(currentTopStockCard.getColor()) || el.getFigure().equals(currentTopStockCard.getFigure())) {
                possibleThrows.add(el);
                tempHand().remove(el);
            }
        }
        return possibleThrows;
    }

    public int[] priorities() {
        int[] priorities = new int[possibleThrows().size()];
        for (int i = 0; i < priorities.length; i++) {
            if (possibleThrows().get(i).getFigure().equals(CardFigure.N2)
                    || possibleThrows().get(i).getFigure().equals(CardFigure.N3)
                    || ((possibleThrows().get(i).getFigure().equals(CardFigure.K))
                    && (possibleThrows().get(i).getColor().equals(CardColor.HEARTS)
                    || possibleThrows().get(i).getColor().equals(CardColor.SPADES)))) {
                if (deal.getHumanPlayer().getHand().size() < 5)
                    priorities[i] = possibleThrows().get(i).getPriority() * (5 - deal.getHumanPlayer().getHand().size());
                else priorities[i] = possibleThrows().get(i).getPriority();
            } else priorities[i] = possibleThrows().get(i).getPriority();
        }

        for (int i = 0; i < possibleThrows().size(); i++) {
            for (Card el2 : tempHand()) {
                if (possibleThrows().get(i).getFigure().equals(el2.getFigure()))
                    priorities[i] += el2.getPriority();
            }
        }

        for (int i = 0; i < possibleThrows().size(); i++) {
            for (Card el : tempHand()) {
                if ((el.getFigure().equals(possibleThrows().get(i).getFigure())) || (el.getColor().equals(possibleThrows().get(i).getColor())))
                    priorities[i] += el.getPriority();
            }
        }
        return priorities;
    }

    public int findIndex(int[] arr, int searched) {
        int counter = 0;
        for (int el : arr) {
            if (searched == el) break;
            counter++;
        }
        return counter;
    }

    public int findIndex(List<Card> arr, Card searched) {
        int counter = 0;
        for (Card el : arr) {
            if (searched.equals(el)) break;
            counter++;
        }
        return counter;
    }

    public Card chooseBestCard() {
        int max = priorities()[0];
        for (int i = 0; i < priorities().length; i++) {
            if (priorities()[i] > max) max = priorities()[i];
        }
        return possibleThrows().get(findIndex(priorities(), max));
    }

    public void play() {
        if (possibleThrows().size() == 0) {
            deal.getCardFromDeck(hand, 1);
            if(hand.getHand().get(hand.getHand().size()-1).getColor()!=deal.getTopCard().getColor()
                    || hand.getHand().get(hand.getHand().size()-1).getFigure()!=deal.getTopCard().getFigure())
                                                 deal.getCardFromDeck(hand, 1);
            System.out.println("*******  Oponent takes cards, he has now "+hand.getHand().size()+" cards  *******");
        }else{
            deal.putCardOnStock(hand, findIndex(hand.getHand(),chooseBestCard()));
            System.out.println("*******  Oponent throws: " + deal.getTopCard().getCard()+" on TOP, he has now "+hand.getHand().size()+" cards  *******");
        }
    }
}


