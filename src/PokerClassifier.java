//Author: Leo, Haohua Wu
//login id: haohuaw
//University of Melbourne

/*              Java Course Project
*             This is the Game of Poker
*        This programme is the simple version
*  Which aims to classify the 5 cards in a player hand
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//This class is used to classify the type of 5 cards in player's hand

public class PokerClassifier {

    private PokerHand playerHand;
    private basicTypeOfHands result;
    private String ftypeName; //First type name
    private String stypeName; //Second type name

    //Store different type of hands as enum type
    public enum basicTypeOfHands {
        StraightFlush,
        FourOfAKind,
        FullHouse,
        Flush,
        Straight,
        ThreeOfAKind,
        TwoPair,
        OnePair,
        HighCard;
    };

    // Constructor to create Pokerclassifier Object

    public PokerClassifier(PokerHand p1) {
        setPokerClassifier(p1);
    }
    /* This is the main function to achieve classification of cards' type
     *  */
    public void handClassifier() {

        //test code
        int [] manyChecker = checkManyOfAKind(playerHand);

        if (checkStraight(playerHand) && checkFlush(playerHand)) {
            this.result = basicTypeOfHands.StraightFlush;
            this.ftypeName = getHighTypeName(playerHand);
            System.out.println("Player 1: " + ftypeName + "-high "
                                + "straight flush");
        }
        /* Four of a kind
        *  Two types of Four of a kind for sorted card array
        *  smaller 4 and larger 4 */
        else if (manyChecker[0] == 4) {
            this.result = basicTypeOfHands.FourOfAKind;
            this.ftypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: " + "Four " + ftypeName + "s");
        }
        else if (manyChecker[1] == 4) {
            this.result = basicTypeOfHands.FourOfAKind;
            this.ftypeName = getPositionTypeName(playerHand,4);
            System.out.println("Player 1: " + "Four " + ftypeName + "s");
        }
        /* Full House
        *  Two types of Full house for sorted card array
        *  smaller 3 and larger 3 */
        else if (manyChecker[0] == 3 && manyChecker[1] == 2){
            this.result = basicTypeOfHands.FullHouse;
            this.ftypeName = getPositionTypeName(playerHand,0);
            this.stypeName = getPositionTypeName(playerHand,4);
            System.out.println("Player 1: "+ftypeName
                                +"s full of "+stypeName +"s");
        }
        else if (manyChecker[0] == 2 && manyChecker[1] == 3){
            this.result = basicTypeOfHands.FullHouse;
            this.ftypeName = getPositionTypeName(playerHand,4);
            this.stypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: "+ftypeName
                    +"s full of "+stypeName +"s");
        }
        /* Flush */
        else if (checkFlush(playerHand)) {
            this.result = basicTypeOfHands.Flush;
            this.ftypeName = getHighTypeName(playerHand);
            System.out.println("Player 1: "+ ftypeName + "-high "+"flush");
        }
        /* Straight */
        else if (checkStraight(playerHand)) {
            this.result = basicTypeOfHands.Straight;
            this.ftypeName = getHighTypeName(playerHand);
            System.out.println("Player 1: "+ ftypeName +"-high "+ "straight");
        }
        /* Three of a kind
        *  Three types of Three of a kind for sorted card array
        *  smaller 3, medium 3 and larger 3*/
        else if (manyChecker[0] == 3){
            this.result = basicTypeOfHands.ThreeOfAKind;
            this.ftypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: "+ "Three " + ftypeName +"s");
        }
        else if (manyChecker[1] == 3){
            this.result = basicTypeOfHands.ThreeOfAKind;
            this.ftypeName = getPositionTypeName(playerHand,1);
            System.out.println("Player 1: "+ "Three " + ftypeName +"s");
        }
        else if (manyChecker[2] == 3){
            this.result = basicTypeOfHands.ThreeOfAKind;
            this.ftypeName = getPositionTypeName(playerHand,2);
            System.out.println("Player 1: "+ "Three " + ftypeName +"s");
        }
        /* Two Pairs
        *  Three types of two pairs for sorted card array
        *  smaller 2 and medium 2, medium 2 and larger 2, smaller 2 and larger 2*/
        else if (manyChecker[0] == 2 && manyChecker[1] == 2){
            this.result = basicTypeOfHands.TwoPair;
            this.ftypeName = getPositionTypeName(playerHand,2);
            this.stypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: "+ ftypeName +"s over "
                                + stypeName + "s");
        }
        else if (manyChecker[0] == 2 && manyChecker[2] == 2){
            this.result = basicTypeOfHands.TwoPair;
            this.ftypeName = getPositionTypeName(playerHand,4);
            this.stypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: "+ ftypeName +"s over "
                    + stypeName + "s");
        }
        else if (manyChecker[1] == 2 && manyChecker[2] == 2){
            this.result = basicTypeOfHands.TwoPair;
            this.ftypeName = getPositionTypeName(playerHand,4);
            this.stypeName = getPositionTypeName(playerHand,2);
            System.out.println("Player 1: "+ ftypeName +"s over "
                    + stypeName + "s");
        }
        /* One Pair
        *  Four types of one pair for sorted card array
        *  [2,1,1,1]; [1,2,1,1]; [1,1,2,1]; [1,1,1,2] */
        else if (manyChecker[0] == 2){
            this.result = basicTypeOfHands.OnePair;
            this.ftypeName = getPositionTypeName(playerHand,0);
            System.out.println("Player 1: " + "Pair of " + ftypeName +"s");
        }
        else if (manyChecker[1] == 2){
            this.result = basicTypeOfHands.OnePair;
            this.ftypeName = getPositionTypeName(playerHand,1);
            System.out.println("Player 1: " + "Pair of " + ftypeName +"s");
        }
        else if (manyChecker[2] == 2){
            this.result = basicTypeOfHands.OnePair;
            this.ftypeName = getPositionTypeName(playerHand,2);
            System.out.println("Player 1: " + "Pair of " + ftypeName +"s");
        }
        else if (manyChecker[3] == 2){
            this.result = basicTypeOfHands.OnePair;
            this.ftypeName = getPositionTypeName(playerHand,3);
            System.out.println("Player 1: " + "Pair of " + ftypeName +"s");
        }
        // besides all other types, only high card remains
        else {
            this.result = basicTypeOfHands.HighCard;
            this.ftypeName = getHighTypeName(playerHand);
            System.out.println("Player 1: " + ftypeName + "-high");
        }
    }
    /************************* Private functions *****************************/
    private void setPokerClassifier(PokerHand p1) {
        this.playerHand = p1;
    }

    //This function return the highest rank of 5 cards
    private String getHighTypeName(PokerHand p1) {
        PokerCard[] readCards = p1.getPokerHand();
        return readCards[4].getPcRank().getTypeName();
    }

    //This function return rank of specific position card in 5 cards
    private String getPositionTypeName(PokerHand p1, int i){
        PokerCard[] readCards = p1.getPokerHand();
        return readCards[i].getPcRank().getTypeName();
    }

    //This function check 5 cards is straight or not
    //Straight return true, not return false
    private boolean checkStraight(PokerHand p1) {
        //read card information and check
        PokerCard[] readCards = p1.getPokerHand();
        for (int i = 0; i < (readCards.length - 1); i++) {
            if(readCards[i + 1].getPcRank().getRankCost()
               -readCards[i].getPcRank().getRankCost()!=1) {
                return false;
            }
        }
        return true;
    }

    //This function check 5 cards is flush or not
    //flush return true, not return false
    private boolean checkFlush(PokerHand p1) {
        //read card information and check
        PokerCard[] readCards = p1.getPokerHand();
        return readCards[0].getPcSuit().equals(readCards[1].getPcSuit())
                && readCards[1].getPcSuit().equals(readCards[2].getPcSuit())
                && readCards[2].getPcSuit().equals(readCards[3].getPcSuit())
                && readCards[3].getPcSuit().equals(readCards[4].getPcSuit());
    }

    //This function consider 5 cards(sorted) in player's hand as input
    //And return an integer array which represent
    //how many times a rank has occured in 5 cards

    private int[] checkManyOfAKind(PokerHand p1) {

        HashMap<Integer, Integer> mapChecker = new HashMap<Integer, Integer>();
        PokerCard[] readCards = p1.getPokerHand();

        // This iterative loop use hashmap to count how many times
        // a rank has present in 5 cards

        for (int i = 0; i < readCards.length; i++){
            int tempInt = readCards[i].getPcRank().getRankCost();
            Integer num = mapChecker.get(tempInt);
            int count = 1;
            if (num != null){
                count = num + 1;
            }
            mapChecker.put(tempInt,count);
        }

        // get the counter information
        // from hashmap object to an integer array
        //

        int [] storeInfo = new int[5];
        int numIterator = 0;
        Iterator<Integer> mapIterator = mapChecker.keySet().iterator();
        while(mapIterator.hasNext()){
            Integer rankCost = mapIterator.next();
            Integer rankAmount = mapChecker.get(rankCost);
            storeInfo[numIterator] = rankAmount;
            //System.out.println(storeInfo[numIterator]);
            numIterator++;
        }
        /*for (int i = 0; i < storeInfo.length; i = i + 2){
            storeInfo[i] = mapChecker.
        }*/
        return storeInfo;
    }
}