//Author: Leo, Haohua Wu
//login id: haohuaw
//University of Melbourne

/*              Java Course Project
*             This is the Game of Poker
*        This programme is the simple version
*  Which aims to classify the 5 cards in a player hand
*/

/*This class contain all the properties of each poker card
* The ranks, in order of increasing value, are:
* 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, and Ace.
* The suits are:
* C-Clubs (♣), D-Diamonds (♦), H-Hearts (♥), and S-Spades (♠)
* Can't be used to decide winner */

public class PokerProperties {

    /* For rank, each rank has specific cost,
    *  And a specific character is recognized as input
    *  And full string to show result as output*/
    public enum ranks {
        Two(1,'2',"2"),
        Three(2,'3',"3"),
        Four(3,'4',"4"),
        Five(4,'5',"5"),
        Six(5,'6',"6"),
        Seven(6,'7',"7"),
        Eight(7,'8',"8"),
        Nine(8,'9',"9"),
        Ten(9,'T',"10"),
        Jack(10,'J',"Jack"),
        Queen(11,'Q',"Queen"),
        King(12,'K',"King"),
        Ace(13,'A',"Ace");

        private final int cost;
        private final char type;
        private final String typeName;

        private ranks(final int cost, final char type, final String typeName){
            this.cost = cost;
            this.type = type;
            this.typeName = typeName;
        }
        public int getRankCost(){
            return cost;
        }
        public char getRankType(){
            return type;
        }
        public String getTypeName() {
            return typeName;
        }
    };

    /* For suits, only character information was stored
    *  As suits won't affect the result and do not have to be displayed*/
    public enum suits {
        Diamonds('D'),
        Clubs('C'),
        Hearts('H'),
        Spades('S');

        private final char name;

        private suits(final char name){
            this.name = name;
        }
        public char getSuitValue(){
            return name;
        }
    };
}
