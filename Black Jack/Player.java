package blackjack;

public class Player {
    private String name;
    public int score;
    private int count =0;
    public Card []hands=new Card[11];
    private boolean blackjack;
    private boolean lost;
    public Player(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Card[] getCards() {
        return hands;
    }

    public void setCards(Card[] cards) {
        this.hands = cards;
    }
    
    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void addCard(Card c){
        if(count<11){
    hands[count]=c;
    count ++;
    score +=c.getValue();
    }
    }
    
}
