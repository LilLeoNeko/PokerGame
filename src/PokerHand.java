//Author: Leo, Haohua Wu
//login id: haohuaw
//University of Melbourne

/*              Java Course Project
*             This is the Game of Poker
*        This programme is the simple version
*  Which aims to classify the 5 cards in a player hand
*/

import java.util.Arrays;

/* This class is used to describe poker cards that player holds in hand */
/*            As each player can only hold 5 cards           */

public class PokerHand {

    //pokerHand variable is use to store info of those cards each player holds
    private PokerCard [] pokerHand;

    /***** PokerHand constructor *****/
    public PokerHand(PokerCard [] input){
        setPokerHand(input);
    }
    /* This Function is provided to sort Poker Cards
     * As comparable interface was implemented in PokerCard Class
     * And compareTo method has been override */

    public void sortCard(){
        Arrays.sort(this.pokerHand);
    }

    // Function to get all 5 poker cards in player's hand

    public PokerCard[] getPokerHand() {
        return pokerHand;
    }

    // Private function
    // Function to set 5 poker cards to player's hand

    private void setPokerHand(PokerCard [] input){
        this.pokerHand = input;
    }
}
