public class Main {

    public static void main (String ... args){


//        Game.game();
            Rules rules = new Rules(new Deal());

        System.out.println("Top card: "+rules.getStockTopCard().getCard());

            for (Card el: rules.possibleMove()){
                System.out.println(el.getCard());
            }


    }

}
