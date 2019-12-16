import java.util.*;

public class CompIQ {

    private Deal deal;

    public CompIQ(Deal deal) {
        this.deal = deal;
    }

    public List<Card> tempHand() {
        List<Card> tempHand = new LinkedList<>();
        for (Card el : this.deal.getPlayer2().getHand()) {
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
                if (deal.getPlayer1().getHand().size() < 5)
                    priorities[i] = possibleThrows().get(i).getPriority() * (5 - deal.getPlayer1().getHand().size());
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
        Card temp;
        int max = priorities()[0];
        for (int i = 0; i < priorities().length; i++) {
            if (priorities()[i] > max) max = priorities()[i];
        }
        return possibleThrows().get(findIndex(priorities(), max));
    }

    public void play() {
        if (possibleThrows().size() == 0) {
            deal.getCardFromDeck(deal.getPlayer2(), 1);
            if(deal.getPlayer2().getHand().get(deal.getPlayer2().getHand().size()-1).getColor()!=deal.getTopCard().getColor()
                    || deal.getPlayer2().getHand().get(deal.getPlayer2().getHand().size()-1).getFigure()!=deal.getTopCard().getFigure())
                                                 deal.getCardFromDeck(deal.getPlayer2(), deal.getTopCard().getCardMultiplier()-1);
            System.out.println("*******  Oponent takes cards, he has now "+deal.getPlayer2().getHand().size()+" cards  *******");
        }else{
            deal.putCardOnStock(deal.getPlayer2(), findIndex(deal.getPlayer2().getHand(),chooseBestCard()));
            System.out.println("*******  Oponent throws: " + deal.getTopCard().getCard()+" on TOP, he has now "+deal.getPlayer2().getHand().size()+" cards  *******");
        }
    }
}


