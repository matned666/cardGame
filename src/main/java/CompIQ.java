import java.util.LinkedList;
import java.util.List;

public class CompIQ {

    private Deal deal;

    public CompIQ(Deal deal) {
        this.deal = deal;
    }

    public List<Card> tempHand(){
        List<Card> tempHand = new LinkedList<>();
        for(Card el: this.deal.getPlayer2().getHand()){
            tempHand.add(el);
        }
        return tempHand;
    }


    public List<Card> possibleThrows(){
        List<Card> possibleThrows = new LinkedList<>();
        Card currentTopStockCard = deal.getTopCard();

        for(Card el: tempHand()) {
            if (el.getColor().equals(currentTopStockCard.getColor()) || el.getFigure().equals(currentTopStockCard.getFigure())) {
                possibleThrows.add(el);
                tempHand().remove(el);
            }
        }
        return possibleThrows;
    }

    public int[] priorities(){
        int[] priorities = new int[possibleThrows().size()];
        for(int i = 0 ; i < priorities.length ; i++){
            if(possibleThrows().get(i).getFigure().equals(CardFigure.N2)
            || possibleThrows().get(i).getFigure().equals(CardFigure.N3)
            || ((possibleThrows().get(i).getFigure().equals(CardFigure.K) )
                    &&  (possibleThrows().get(i).getColor().equals(CardColor.HEARTS)
                    || possibleThrows().get(i).getColor().equals(CardColor.SPADES)))){
                if(deal.getPlayer1().getHand().size()<5)
                    priorities[i] = possibleThrows().get(i).getPriority()*(5-deal.getPlayer1().getHand().size());
                else priorities[i] = possibleThrows().get(i).getPriority();
            }else priorities[i] = possibleThrows().get(i).getPriority();
        }

        for(int i = 0; i < possibleThrows().size() ; i++){
            for(Card el2: tempHand()){
                if(possibleThrows().get(i).getFigure().equals(el2.getFigure()))
                    priorities[i] += el2.getPriority();
            }
        }

        for(int i = 0; i < possibleThrows().size(); i++ ){
            for(Card el: tempHand()){
                if ((el.getFigure().equals(possibleThrows().get(i).getFigure()))||(el.getColor().equals(possibleThrows().get(i).getColor())))
                    priorities[i] += el.getPriority();
            }
        }
       return priorities;
    }

    public Card chooseBestCard(){
        Card temp = new Card(CardColor.HEARTS,CardFigure.A);
        for(int i = 0; i < possibleThrows().size(); i++){

        }
        return temp;
    }
}
