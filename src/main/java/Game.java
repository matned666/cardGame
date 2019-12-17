import java.util.Scanner;

public class Game {


    private static boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void game(){
        Deal deal = new Deal();
        boolean choiceBool;
        Scanner keys = new Scanner(System.in);
        String choice = "";
        CompIQ iq = new CompIQ(deal,deal.getComputerPlayer1());
        boolean action = false;

        System.out.println();
        Menu.menuStandard();
        System.out.print("Your cards: ");
        deal.printHand(deal.getHumanPlayer());

        System.out.println("The top card is: " + deal.getTopCard().getCard());

        while(!choice.toUpperCase().equals("Q") || deal.getHumanPlayer().getHand().isEmpty() || deal.getComputerPlayer1().getHand().isEmpty()) {

            choiceBool = false;
            do {
                System.out.print("What to do: ");
                choice = keys.nextLine();

                if (isNumeric(choice)){
                    try {
                        if ((Integer.parseInt(choice) < deal.getHumanPlayer().getHand().size() && Double.parseDouble(choice) >= 0)
                              && (deal.getHumanPlayer().getHand().get(Integer.parseInt(choice)).getFigure() == deal.getTopCard().getFigure()
                                   || deal.getHumanPlayer().getHand().get(Integer.parseInt(choice)).getColor() == deal.getTopCard().getColor())) {

                            deal.putCardOnStock(deal.getHumanPlayer(), Integer.parseInt(choice));
                            System.out.print("Your cards: ");
                            deal.printHand(deal.getHumanPlayer());

                            System.out.println("The top card is: " + deal.getTopCard().getCard());
                            choiceBool = true;


                        } else {
                            Menu.errorMessage1();
                        }
                    }catch(NumberFormatException ex){
                         Menu.errorMessage1();
                    }
                }else {
                    if (choice.toUpperCase().equals("D")) {
                        deal.getCardFromDeck(deal.getHumanPlayer(), 1);
                        System.out.print("Your cards: ");
                        deal.printHand(deal.getHumanPlayer());
                        choiceBool = true;
                    } else if (choice.toUpperCase().equals("S")) {
                        System.out.println("The top card is: " + deal.getTopCard().getCard());
                    } else if (choice.toUpperCase().equals("I")) {
                        Menu.menuInfo(deal.getDeck().size(), deal.getStock().getStockSize(), deal.getComputerPlayer1().getHand().size());
                    } else if (choice.toUpperCase().equals("Y")) {
                        System.out.print("Your cards: ");
                        deal.printHand(deal.getHumanPlayer());
                    } else if (choice.toUpperCase().equals("M")) {
                        Menu.menuStandard();
                    }else if (choice.toUpperCase().equals("Q")) break;
                    else{
                        Menu.errorMessage1();
                    }
                }
            }while(choiceBool != true);
            if(deal.getHumanPlayer().getHand().isEmpty()) break;
            iq.play();
            if(deal.getComputerPlayer1().getHand().isEmpty()) break;
        }
        if(deal.getHumanPlayer().getHand().isEmpty()) System.out.println("$$$$$$$$$$ WYGRAŁEŚ $$$$$$$$$$");
        if(deal.getComputerPlayer1().getHand().isEmpty()) System.out.println("********** PRZEGRAŁEŚ **********");
    }

}
