import java.util.LinkedList;
import java.util.List;

public class CardDeck
{

    private List<Card> pack;

    public CardDeck() {
        this.pack = new LinkedList<>();
        for (int i = 1; i <=4 ; i++) {
            this.pack.add(new Card(getColor(i), CardFigure.A));
            this.pack.add(new Card(getColor(i), CardFigure.K));
            this.pack.add(new Card(getColor(i), CardFigure.Q));
            this.pack.add(new Card(getColor(i), CardFigure.J));
            this.pack.add(new Card(getColor(i), CardFigure.N10));
            this.pack.add(new Card(getColor(i), CardFigure.N9));
            this.pack.add(new Card(getColor(i), CardFigure.N8));
            this.pack.add(new Card(getColor(i), CardFigure.N7));
            this.pack.add(new Card(getColor(i), CardFigure.N6));
            this.pack.add(new Card(getColor(i), CardFigure.N5));
            this.pack.add(new Card(getColor(i), CardFigure.N4));
            this.pack.add(new Card(getColor(i), CardFigure.N3));
            this.pack.add(new Card(getColor(i), CardFigure.N2));
            }
    }

    private CardColor getColor(int i){
        if(i == 1) return CardColor.HEARTS;
        else if(i == 2) return CardColor.SPADES;
        else if(i == 3) return CardColor.DIAMONDS;
        else return CardColor.CLUBS;
    }

    public List<Card> deck(){
        return this.pack;
    }
}
