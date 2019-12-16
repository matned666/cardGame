public class Card {

    private CardColor color;
    private CardFigure figure;
    private int priority;
    private int wage;
    private int cardMultiplier;
    private CardFunc function;


    public Card(CardColor color, CardFigure figure) {
        this.color = color;
        this.figure = figure;
        this.wage = 0;
        this.cardMultiplier = 0;

    }

    public CardColor getColor() {
        return color;
    }

    public CardFigure getFigure() {
        return figure;
    }

    public String getColorStr(){
        String color="";
        if(this.color == CardColor.HEARTS) {color = "\u2764";this.wage+=3;}
        if(this.color == CardColor.SPADES) {color = "\u2660";this.wage+=2;}
        if(this.color == CardColor.DIAMONDS) {color = "\u2666";this.wage+=1;}
        if(this.color == CardColor.CLUBS) {color = "\u2663";this.wage+=0;}
        return color;
    }

    public String getFigureStr(){
        String figure="";

        if(this.figure == CardFigure.A) {figure = "A";this.priority = 5;this.wage+=49;this.cardMultiplier =1;this.function = CardFunc.COLOR;}
        if(this.figure == CardFigure.K) {figure = "K";this.priority = 1;this.wage+=45;this.cardMultiplier =5;this.function = CardFunc.TAKE;}
        if(this.figure == CardFigure.Q) {figure = "Q";this.priority = 7;this.wage+=41;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.J) {figure = "J";this.priority = 5;this.wage+=37;this.cardMultiplier =1;this.function = CardFunc.FIGURE;}
        if(this.figure == CardFigure.N10) {figure = "10";this.priority = 7;this.wage+=33;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N9) {figure = "9";this.priority = 7;this.wage+=29;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N8) {figure = "8";this.priority = 7;this.wage+=25;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N7) {figure = "7";this.priority = 7;this.wage+=21;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N6) {figure = "6";this.priority = 7;this.wage+=17;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N5) {figure = "5";this.priority = 7;this.wage+=13;this.cardMultiplier =1;this.function = CardFunc.NORMAL;}
        if(this.figure == CardFigure.N4) {figure = "4";this.priority = 9;this.wage+=9;this.cardMultiplier =1;this.function = CardFunc.PAUSE;}
        if(this.figure == CardFigure.N3) {figure = "3";this.priority = 3;this.wage+=5;this.cardMultiplier =3;this.function = CardFunc.TAKE;}
        if(this.figure == CardFigure.N2) {figure = "2";this.priority = 2;this.wage+=1;this.cardMultiplier =2;this.function = CardFunc.TAKE;}

        return figure;
    }

    public int getPriority() {
        return priority;
    }

    public int getWage() {
        return wage;
    }

    public int getCardMultiplier() {
        return cardMultiplier;
    }

    public String getCard(){
        return "["+getFigureStr()+" "+getColorStr()+"]";
    }

}
