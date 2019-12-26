public class Menu {

    public static void menuInfo(int deckSize, int stockSize, int oponentHand){
        System.out.println("Number of cards in the deck: "+deckSize+", number of cards on stock: "+stockSize+", oponent's hand: "+oponentHand+" cards.");
    }

    public static void menuStandard(){
        System.out.println("1,2,3,... - choose a card from hand,\n" +
                           "'S' - show top stock card, 'I' - game informations,\n" +
                           "'Y' - show your hand, 'M' - repeat game menu,\n" +
                           "'D' - take a card from deck, 'Q' - quit the game");
    }

    public static void menuJ(){
        System.out.println("Choose which figure would you demand from your hand (1,2,3,...)(no usable cards) or 'A' - for no demand: ");
    }

    public static void menuA(){
        System.out.println("Choose which color would you demand from your hand (1,2,3,...) or 'A' - for no demand: ");
    }

    public static void manyCardChoice(){
        System.out.println("Choose another card of the same color or choose 'E' to continue: ");
    }

    public static void errorMessage1(){
        System.out.println("Invalid choice.");
    }


}
