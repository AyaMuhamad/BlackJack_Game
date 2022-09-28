package blackjack;

import java.util.Scanner;

public class BlackJack {
   static Game g =new Game();
 

    public static void main(String[] args) {
          GUI gui = new GUI();
        g.generates_array();
        g.set_players_information();
        gui.runGUI( g.cards,g.players[0].hands ,g.players[1].hands , g.players[2].hands,g.players[3].hands  );
        players_turn(gui);
        dealers_turn (gui);
        winner();
        
    }
    public static void players_turn(GUI gui){
        Scanner s =new Scanner(System.in);
        for (int i=0;i<3;i++){
            String item="";
            while(!item.equals("stand")){
                System.out.println("the player ["+(i+1)+"] => (hit or stand)? : "+"his score is "+g.score[i]);
                item=s.next();
                if(g.score[i]<21&&g.score[i]!=0){
                    if (item.equals("hit")){
                       Card c= g.draws_a_card();
                        g.players[i].addCard(c);
                        g.update();
                        gui.updatePlayerHand(c,i);
                        if(g.score[i]==21){
                            break;
                            
                        }else if(g.score[i]==0){
                            System.out.println(" you busted");
                         break;
                        }     
                    }
                    else{
                        break;
                    }
                }
                
                else break;
            }
        }
    } 
    
  public static void dealers_turn (GUI gui){
      int maxScore=0;
        for(int i=0;i<4;i++){
            if(g.score[i]>maxScore){
                maxScore=g.score[i];
          }
        }
        if(maxScore<=21){
          while(g.score[3]<=maxScore){
              Card c=g.draws_a_card();
              g.players[3].addCard(c);
              g.update();
              gui.updateDealerHand(c,g.cards);
              if(g.players[3].score>=21){
                  break;
              }
              
              
          }
      }
  }  
  public static void winner(){
      int highScore=0;
      int winner=-1;
      boolean push=false;
      for(int i=0;i<4;i++){
          if(g.score[i]>highScore){
             highScore=g.score[i];
             winner=i;
          }
       }
      for(int j=0;j<4;j++){
         if(g.score[j]==highScore&&j!=winner){
                    push=true;

         }
             
        }if(push){
            System.out.println("push");
        }
        if(winner>=0){
           System.out.println("WINNER IS "+g.players[winner].getName()+" HIS SCORE IS "+highScore);
       }
  }
       
}

