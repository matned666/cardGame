import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Deal {

    private CardDeck cardDeck;
    private Stock stock;
    private Hand humanPlayer;
    private Hand computerPlayer1;

    public Deal() {
        cardDeck = new CardDeck();
        stock = new Stock();
        humanPlayer = new Hand(PlayerType.PLAYER);
        computerPlayer1 = new Hand(PlayerType.COMPUTER);
        firstDeal();
    }

    public List getDeck(){
        return this.cardDeck.deck();
    }

    public void firstDeal() {
        int max = 52;
        int counter = 1;
        for (int i = 1; i <= 10; i++) {
            if (humanPlayer.getHand().size() < 5 && counter % 2 == 1) {
                Random randomGenerator = new Random();
                int randomizer = Math.abs(randomGenerator.nextInt(max));

                humanPlayer.addCard(cardDeck.deck().get(randomizer));
                cardDeck.deck().remove(randomizer);
                max -= 1;
                counter++;

            }
            if (computerPlayer1.getHand().size() < 5 && counter % 2 == 0) {
                Random randomGenerator = new Random();
                int randomizer = Math.abs(randomGenerator.nextInt(max));

                computerPlayer1.addCard(cardDeck.deck().get(randomizer));
                cardDeck.deck().remove(randomizer);
                max -= 1;
                counter++;

            }

        }
        do {
            Random randomGenerator = new Random();
            int randomizer = Math.abs(randomGenerator.nextInt(max));

            stock.push(cardDeck.deck().get(randomizer));
            cardDeck.deck().remove(randomizer);
        }while(getTopCard().getFigure() == CardFigure.A
                || getTopCard().getFigure() == CardFigure.K
                || getTopCard().getFigure() == CardFigure.J
                || getTopCard().getFigure() == CardFigure.N4
                || getTopCard().getFigure() == CardFigure.N3
                || getTopCard().getFigure() == CardFigure.N2);


    }

    public void getCardFromDeck(Hand player, int cardsAmound){
        for(int i = 1 ; i <= cardsAmound; i++) {
            Random randomGenerator = new Random();
            int randomizer = Math.abs(randomGenerator.nextInt(cardDeck.deck().size()));
            player.addCard(cardDeck.deck().get(randomizer));
            cardDeck.deck().remove(randomizer);
            if (getDeck().size() == 0) {
                getDeck().addAll(stock.leaveOnlyTop());
            }
        }
    }

    public void putCardOnStock(Hand player, int cardId){
            stock.push(player.getHand().get(cardId));
            player.getHand().remove(cardId);
    }



    public Card getTopCard() {
        return (Card) stock.peek();
    }

    public void printHand(Hand player){
        AtomicInteger y= new AtomicInteger();
        player.getHand().stream().map(x -> x.getCard()+(y.getAndIncrement())+" , ").forEach(System.out::print);
        System.out.println();
    }

    public void printCardDeck(){
            cardDeck.deck().stream().map(x-> x.getCard()).forEach(System.out::println);
    }

    public Stock getStock() {
        return stock;
    }

    public Hand getHumanPlayer() {
        return humanPlayer;
    }

    public Hand getComputerPlayer1() {
        return computerPlayer1;
    }
}
