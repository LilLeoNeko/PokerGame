//Author: Leo, Haohua Wu
//login id: haohuaw
//University of Melbourne

/*              Java Course Project
*             This is the Game of Poker
*        This programme is the simple version
*  Which aims to classify the 5 cards in a player hand
*/

/***************************************************************************
 This is the main class of this Poker Project
 The major functions of this class are obtaining input and showing result
 of poker game. Include classification of single hand and judgement of
 winner while multiple players are in the game
 **************************************************************************/

/***************************************************************************
 The ranks, in order of increasing value, are:
 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace.
 The suits are:
 C-Clubs (♣), D-Diamonds (♦), H-Hearts (♥), and S-Spades (♠)
 Can't be used to decide winner.
***************************************************************************/

//import java.util.Arrays;
public class Poker {
    //Main function
    public static void main(String args[]){

        /* First check the command line arguments are valid or not */
        /* Check the length of input is greater than 0 and 5's multiplier */
        int inputChecker = args.length;
        if (!checkInputNum(inputChecker)){
            System.out.println("Error: wrong number of arguments; "
                                + "must be a multiple of 5");
            System.exit(1);
        }

        /* Check whether the inputs can represent poker cards correctly
         * Check those inputs one by one */
        for (int i = 0; i < inputChecker; i++){

            //**********convert string to char array**********
            char[] tempCharArray = args[i].toCharArray();

            //**********If any one goes wrong, report it**********
            if (checkInputValid(tempCharArray) == false){
                System.out.printf("Error: invalid card name '%s'%n", args[i]);
                System.exit(1);
            }
        }

        /* If there is one player, start classification */
        if(inputChecker == 5){

            PokerCard [] setOfCards = new PokerCard[5];

            // In this iterative loop
            // obtain input information
            // and choose proper rank and suit to set up cards
            for (int i = 0; i < inputChecker; i++){
                char[] tempCharArray = args[i].toCharArray();
                char tempChar1 = Character.toUpperCase(tempCharArray[0]);
                char tempChar2 = Character.toUpperCase(tempCharArray[1]);
                PokerCard tempCard = new PokerCard(tempChar1,tempChar2);
                setOfCards[i] = tempCard;
            }

            PokerHand player1 = new PokerHand(setOfCards);
            player1.sortCard();

            //start classify and show result
            PokerClassifier singleClassify = new PokerClassifier(player1);
            singleClassify.handClassifier();
        }

        /* If multiple players */
        else{
            System.out.println("NOT UNDERTAKEN");
        }
        //test1();
}

    /* This is the function to check the length of input is valid or not */
    // Return true if Input number is valid, false if is not
    private static boolean checkInputNum(int a){
        return a % 5 == 0 && a > 0 ;
    }

    /* This is the function to check single card input is valid or not */
    private static boolean checkInputValid(char strArray[]) {
        char ranks[] = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
        char suits[] = {'D','C','H','S'};

        //********** Check the first char is in ranks **********
        for (int i = 0; i < 13; i++){
            //test codes
            char tempChecker1 = Character.toUpperCase(strArray[0]);
            if (tempChecker1 == ranks[i]){

                //********** AND second char is in suits **********
                for (int j = 0; j < 4; j++){
                    char tempChecker2 = Character.toUpperCase(strArray[1]);
                    if (tempChecker2 == suits[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //*********************** TEST CODES ************************
    /*
    public static void test1(){
        PokerCard[] cards = {new PokerCard(PokerProperties.ranks.Five,
                                           PokerProperties.suits.Diamonds),
                new PokerCard(PokerProperties.ranks.Three,
                              PokerProperties.suits.Diamonds),
                new PokerCard(PokerProperties.ranks.Four,
                              PokerProperties.suits.Diamonds)};
        Arrays.sort(cards);
        System.out.printf("%c%c %c%c %c%c",cards[0].getPcRank().getRankType(),
                            cards[0].getPcSuit().getSuitValue(),
                            cards[1].getPcRank().getRankType(),
                            cards[1].getPcSuit().getSuitValue(),
                            cards[2].getPcRank().getRankType(),
                            cards[2].getPcSuit().getSuitValue());
    }*/
    //********** End of this class **********
}
