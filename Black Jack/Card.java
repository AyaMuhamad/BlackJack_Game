package blackjack;
public class Card {
   private final int suit,rank,value;
    public Card(int s,int r,int v){
        suit=s;
        rank=r;
        value=v;
    }
   
    
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

   
    public Card(Card c){
        suit=c.suit;
        value=c.value;
        rank=c.rank;
    }
}
