import java.util.List;
import java.util.stream.Collectors;

public class Rules {

    private int amoundOfCardsToTake;
    private Card stockTopCard;
    private Deal deal;
    private CardColor claimedColor;
    private CardFigure claimedFigure;

    public Rules(Deal deal) {
        this.deal = deal;
        this.stockTopCard = this.deal.getTopCard();
    }

    public Rules(Deal deal, CardColor claimedColor) {
        this.deal = deal;
        this.claimedColor = claimedColor;
    }

    public Rules(Deal deal, CardFigure claimedFigure) {
        this.deal = deal;
        this.claimedFigure = claimedFigure;
    }

    public Card getStockTopCard() {
        return stockTopCard;
    }

    public Deal getDeal() {
        return deal;
    }

    public List<Card> possibleMove_23K (){
        return new CardDeck().deck()
                .stream()
                .filter(x->x.getFigure()==this.stockTopCard.getFigure()
                        ||(x.getColor()==this.stockTopCard.getColor()
                        && (x.getFigure()==CardFigure.N2
                        || x.getFigure()==CardFigure.N3))
                        || (x.getColor()==this.stockTopCard.getColor() && x.getFigure()==CardFigure.K && x.getColor()==CardColor.HEARTS)
                        || (x.getColor()==this.stockTopCard.getColor() && x.getFigure()==CardFigure.K && x.getColor()==CardColor.SPADES))
                .collect(Collectors.toList());
    }

    private List<Card> possibleMove_J(){
        return new CardDeck().deck()
                .stream()
                .filter(x->x.getFigure()==CardFigure.J || x.getFigure() == this.claimedFigure)
                .collect(Collectors.toList());
    }

    private List<Card> possibleMove_A(){
        return new CardDeck().deck()
                .stream()
                .filter(x->x.getFigure()==CardFigure.A || x.getColor() == this.claimedColor)
                .collect(Collectors.toList());
    }

    private List<Card> possibleMove_4(){
        return new CardDeck().deck()
                .stream()
                .filter(x->x.getFigure()==CardFigure.N4)
                .collect(Collectors.toList());
    }

    private List<Card> possibleMove_All(){
        return new CardDeck().deck()
                .stream()
                .filter(x->x.getFigure()==this.stockTopCard.getFigure()
                        ||x.getColor()==this.stockTopCard.getColor())
                .collect(Collectors.toList());
    }

    public List<Card> possibleMove(){
        if(deal.getTopCard().getFigure()==CardFigure.N2
           || deal.getTopCard().getFigure()==CardFigure.N3
           || (deal.getTopCard().getFigure()==CardFigure.K && deal.getTopCard().getColor()==CardColor.HEARTS)
           || (deal.getTopCard().getFigure()==CardFigure.K && deal.getTopCard().getColor()==CardColor.SPADES))
            return possibleMove_23K();
        else if(deal.getTopCard().getFigure()==CardFigure.J) return possibleMove_J();
        else if(deal.getTopCard().getFigure()==CardFigure.A) return possibleMove_A();
        else if(deal.getTopCard().getFigure()==CardFigure.N4) return possibleMove_4();
        else  return possibleMove_All();
    }

    public int getAmoundOfCardsToTake(){
        if(deal.getTopCard().getFigure()==CardFigure.N2) return 2;
        if(deal.getTopCard().getFigure()==CardFigure.N3) return 3;
        if(deal.getTopCard().getFigure()==CardFigure.N4) return 0;
        if(deal.getTopCard().getFigure()==CardFigure.K && deal.getTopCard().getColor()==CardColor.SPADES) return 5;
        if(deal.getTopCard().getFigure()==CardFigure.K && deal.getTopCard().getColor()==CardColor.HEARTS) return 5;
        else return 1;
    }

    public boolean isPaused(){
        if(deal.getTopCard().getFigure()==CardFigure.N4) return true;
        else return false;
    }



}
