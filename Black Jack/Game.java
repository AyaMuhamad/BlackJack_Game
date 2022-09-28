
package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {
        public Player[] players=new Player[4];
        public Card[]cards=new Card[52];
        public int[] score=new int[4];
            public void generates_array(){
                int value;
                int i=0;
                for(int suit=0; suit <=3; suit++){
                    for (int rank=0; rank<=12;rank++){
                      if(rank>=10){
                        value=10;
                      } 
                      else{
                          value=rank+1;
                        }
                       cards[i]=new Card(suit, rank,value);
                       i++;
                    }
                }

            }
       public Card draws_a_card(){
            Random rand=new Random();
            int ch=rand.nextInt(51);
            Card c;
           if(cards[ch]!=null){
            c=new Card(cards[ch]);
           cards[ch]=null;
           return c;
           }else 
            return draws_a_card();
       }
         
        public void set_players_information(){
            Scanner in=new Scanner(System.in);
             for(int i=0;i<players.length;i++){
                players[i]=new Player();
                System.out.println("Enter player"+(i+1));
                players[i].setName(in.next());
                players[i].addCard(draws_a_card());
                players[i].addCard(draws_a_card());
            }
                update();
             
      }
        public void update(){
        for (int i=0;i<4;i++){
            if(players[i].score<=21){
                score[i]=players[i].score;
            }else{
                score[i]=0;
            }
        }
      }
}
