public class Main {

    public static void main (String ... args){


        GamePlay.game();
//            Rules rules = new Rules(new Deal());
//
//        System.out.println("Top card: "+rules.getStockTopCard().getCard());
//
//            for (Card el: rules.possibleMove()){
//                System.out.println(el.getCard());
//            }
//
//            rules.possibleMove().add(new Card(CardColor.HEARTS,CardFigure.A));
//        System.out.println(rules.isCorrect(new Card(CardColor.HEARTS,CardFigure.A)));

        System.out.println(new Card(CardColor.HEARTS,CardFigure.A).getColor().equals(new Card(CardColor.HEARTS,CardFigure.A).getColor() )&& new Card(CardColor.HEARTS,CardFigure.A).getFigure().equals(new Card(CardColor.HEARTS,CardFigure.A).getFigure()));

    }

}
