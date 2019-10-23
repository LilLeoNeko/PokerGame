//Author: Leo, Haohua Wu
//login id: haohuaw
//University of Melbourne

/*              Java Course Project
*             This is the Game of Poker
*        This programme is the simple version
*  Which aims to classify the 5 cards in a player hand
*/

// This class is used to represent the Card object in real life

public class PokerCard implements Comparable<PokerCard> {
    private PokerProperties.ranks pcRank;
    private PokerProperties.suits pcSuit;

    /* The first constructor, use card properties set cards up */
    public PokerCard(PokerProperties.ranks curRank,
                     PokerProperties.suits curSuit){
        this.pcRank = curRank;
        this.pcSuit = curSuit;
    }
    /* The second constructor of object PokerCard use char to set card  */
    public PokerCard(char charRank, char charSuit){
        setCardRank(charRank);
        setCardSuit(charSuit);
    }
    /* Provide basic functions let PokerCard's properties readable */
    public PokerProperties.ranks getPcRank() {
        return pcRank;
}
    public PokerProperties.suits getPcSuit() {
        return pcSuit;
    }

    /* Override compareTo Method to achieve comparable interface
     * to complete sort function for multiple PokerCards */
    public int compareTo(PokerCard compareCard){
        int compareCost = compareCard.getPcRank().getRankCost();
        return this.pcRank.getRankCost() - compareCost;
    }

    /* This set PokerCard rank function */
    /* output: PokerCard rank. According input: char */
    private void setCardRank(char charRank){
        switch (charRank){
            case '2':
                this.pcRank = PokerProperties.ranks.Two;
                break;
            case '3':
                this.pcRank = PokerProperties.ranks.Three;
                break;
            case '4':
                this.pcRank = PokerProperties.ranks.Four;
                break;
            case '5':
                this.pcRank = PokerProperties.ranks.Five;
                break;
            case '6':
                this.pcRank = PokerProperties.ranks.Six;
                break;
            case '7':
                this.pcRank = PokerProperties.ranks.Seven;
                break;
            case '8':
                this.pcRank = PokerProperties.ranks.Eight;
                break;
            case '9':
                this.pcRank = PokerProperties.ranks.Nine;
                break;
            case 'T':
                this.pcRank = PokerProperties.ranks.Ten;
                break;
            case 'J':
                this.pcRank = PokerProperties.ranks.Jack;
                break;
            case 'Q':
                this.pcRank = PokerProperties.ranks.Queen;
                break;
            case 'K':
                this.pcRank = PokerProperties.ranks.King;
                break;
            case 'A':
                this.pcRank = PokerProperties.ranks.Ace;
                break;
        }
    }
    /* This set PokerCard suit function */
    /* output: PokerCard suit. According input: char */
    private void setCardSuit(char charSuit){
        switch (charSuit){
            case'D':
                this.pcSuit = PokerProperties.suits.Diamonds;
                break;
            case'C':
                this.pcSuit = PokerProperties.suits.Clubs;
                break;
            case'H':
                this.pcSuit = PokerProperties.suits.Hearts;
                break;
            case'S':
                this.pcSuit = PokerProperties.suits.Spades;
                break;
        }
    }
}