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

        System.out.println();
        Menu.menuStandard();
        System.out.print("Your cards: ");
        deal.printHand(deal.getPlayer1());
        System.out.println("The top card is: " + deal.getTopCard().getCard());

        while(!choice.toUpperCase().equals("Q")) {

            choiceBool = false;
            do {
                System.out.print("What to do: ");
                choice = keys.nextLine();

                if (isNumeric(choice)){
                    try {
                        if (Integer.parseInt(choice) < deal.getPlayer1().getHand().size() && Double.parseDouble(choice) >= 0) {

                            deal.putCardOnStock(deal.getPlayer1(), Integer.parseInt(choice));
                            System.out.print("Your cards: ");
                            deal.printHand(deal.getPlayer1());
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
                        deal.getCardFromDeck(deal.getPlayer1());
                        System.out.print("Your cards: ");
                        deal.printHand(deal.getPlayer1());
                        choiceBool = true;
                    } else if (choice.toUpperCase().equals("S")) {
                        System.out.println("The top card is: " + deal.getTopCard().getCard());
                    } else if (choice.toUpperCase().equals("I")) {
                        Menu.menuInfo(deal.getDeck().size(), deal.getStock().getStockSize(), deal.getPlayer2().getHand().size());
                    } else if (choice.toUpperCase().equals("Y")) {
                        System.out.print("Your cards: ");
                        deal.printHand(deal.getPlayer1());
                    } else if (choice.toUpperCase().equals("M")) {
                        Menu.menuStandard();
                    }else if (choice.toUpperCase().equals("Q")) break;
                    else{
                        Menu.errorMessage1();
                    }
                }
            }while(choiceBool != true);
        }
    }

}
