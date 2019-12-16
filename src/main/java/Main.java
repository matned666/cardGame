public class Main {

    public static void main (String ... args){


        Deal deal = new Deal();
        System.out.println("Your cards:");
        deal.printHand(deal.getPlayer1());
        System.out.println("\nThe top card is: "+deal.getTopCard().getCard());
        System.out.println("\nYour oponent's cards:");
        deal.printHand(deal.getPlayer2());
        System.out.println(deal.getDeck().size());
//        System.out.println("\nThe next top card is: "+deal.getTopCard().getCard());
        deal.geCardFromDeck(deal.getPlayer1());
        System.out.println(deal.getDeck().size());

    }

}
