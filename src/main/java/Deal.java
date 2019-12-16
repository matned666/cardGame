import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deal {

    private CardDeck cardDeck;
    private Stock stock;
    private Hand player1;
    private Hand player2;

    public Deal() {
        cardDeck = new CardDeck();
        stock = new Stock();
        player1 = new Hand(PlayerType.PLAYER);
        player2 = new Hand(PlayerType.COMPUTER);
        firstDeal();
    }

    public List getDeck(){
        return this.cardDeck.deck();
    }

    public void firstDeal() {
        int max = 52;
        List temp = new LinkedList();
        int counter = 1;
        for (int i = 1; i <= 10; i++) {
            if (player1.getHand().size() < 5 && counter % 2 == 1) {
                Random randomGenerator = new Random();
                int randomizer = Math.abs(randomGenerator.nextInt(max));

                player1.addCard((Card) cardDeck.deck().get(randomizer));
                cardDeck.deck().remove(randomizer);
                max -= 1;
                counter++;

            }
            if (player2.getHand().size() < 5 && counter % 2 == 0) {
                Random randomGenerator = new Random();
                int randomizer = Math.abs(randomGenerator.nextInt(max));

                player2.addCard((Card) cardDeck.deck().get(randomizer));
                cardDeck.deck().remove(randomizer);
                max -= 1;
                counter++;

            }

        }
        Random randomGenerator = new Random();
        int randomizer = Math.abs(randomGenerator.nextInt(max));

        stock.push((Card) cardDeck.deck().get(randomizer));
        cardDeck.deck().remove(randomizer);
    }


    public void geCardFromDeck(Hand player){
        Random randomGenerator = new Random();
        int randomizer = Math.abs(randomGenerator.nextInt(cardDeck.deck().size())+1);

        player.addCard((Card) cardDeck.deck().get(randomizer));
        cardDeck.deck().remove(randomizer);
        System.out.println("\nYour cards: ");
        printHand(player);

    }




    public Card getTopCard() {
        return (Card) stock.peek();
    }

    public void printHand(Hand player){
        player.getHand().stream().map(x -> x.getCard()+" , ").forEach(System.out::print);
        System.out.println();
    }

    public void printCardDeck(){
            cardDeck.deck().stream().map(x-> x.getCard()).forEach(System.out::println);
    }

    public Hand getPlayer1() {
        return player1;
    }

    public Hand getPlayer2() {
        return player2;
    }
}
