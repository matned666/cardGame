public class Card {

    CardColor color;
    CardFigure figure;

    public Card(CardColor color, CardFigure figure) {
        this.color = color;
        this.figure = figure;
    }

    public String getCard(){
        String color="";
        String figure="";
        if(this.color == CardColor.HEARTS) color = "\u2764";
        if(this.color == CardColor.SPADES) color = "\u2660";
        if(this.color == CardColor.DIAMONDS) color = "\u2666";
        if(this.color == CardColor.CLUBS) color = "\u2663";

        if(this.figure == CardFigure.A) figure = "A";
        if(this.figure == CardFigure.K) figure = "K";
        if(this.figure == CardFigure.Q) figure = "Q";
        if(this.figure == CardFigure.J) figure = "J";
        if(this.figure == CardFigure.N10) figure = "10";
        if(this.figure == CardFigure.N9) figure = "9";
        if(this.figure == CardFigure.N8) figure = "8";
        if(this.figure == CardFigure.N7) figure = "7";
        if(this.figure == CardFigure.N6) figure = "6";
        if(this.figure == CardFigure.N5) figure = "5";
        if(this.figure == CardFigure.N4) figure = "4";
        if(this.figure == CardFigure.N3) figure = "3";
        if(this.figure == CardFigure.N2) figure = "2";


            return "["+figure+" "+color+"]";
    }

}
