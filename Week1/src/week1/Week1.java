
package week1;

import java.util.Scanner;


public class Week1 {

    
    public static void main(String[] args) {
        Scanner user= new Scanner(System.in);
        
        System.out.println("===== FIXTURE =====");
        System.out.println("Match 1: Team A VS Team B");
        System.out.println("Match 2: Team A VS Team C");
        System.out.println("Match 3: Team A VS Team D");
        System.out.println("Match 4: Team B VS Team C");
        System.out.println("Match 5: Team B VS Team D");
        System.out.println("Match 6: Team C VS Team D");
        System.out.println();
        
      // goals for  
      int[] goalsFor = new int[4];
        //goals against
      int[] goalsAgainst = new int[4]; 
      
        int[] goalsDifference=new int[4];
        int[] score=new int[12];
        int[] win=new int[4];
        int[] lose=new int[4];
        int[] draw=new int[4];
        int[] points = new int[4];
        
        
        
        System.out.println("Match 1 :Team A VS Team B"); 
        System.out.println("Team A goals:");  //A-B
         score[0]=user.nextInt();
        System.out.println("Team B goals:");
         score[1]=user.nextInt();
        
        System.out.println("Match 2 :Team A VS Team C");
         System.out.println("Team A goals:"); //A-C
         score[2]=user.nextInt();
         System.out.println("Team C goals:");
         score[3]=user.nextInt();
         
        System.out.println("Match 3 :Team A VS Team D"); 
        System.out.println("Team A goals:"); //A-D
         score[4]=user.nextInt();
        System.out.println("Team D goals:");
         score[5]=user.nextInt();
        
        
        System.out.println("Match 4 :Team B VS Team C"); 
        System.out.println("Team B goals:");
        score[6]=user.nextInt(); //B-C
        System.out.println("Team C goals:");
         score[7]=user.nextInt();
        
        System.out.println("Match 5 :Team B VS Team D"); 
        System.out.println("Team B goals:");
        score[8]=user.nextInt(); //B-D
        System.out.println("Team D goals:");
        score[9]=user.nextInt();
        
        
        System.out.println("Match 6 :Team C VS Team D"); 
        System.out.println("Team C goals:");
        score[10]=user.nextInt(); //C-D
        System.out.println("Team D goals:");
        score[11]=user.nextInt();
       
        
      
                
    for(int i = 0; i < 12; i += 2){
             
        if(i == 0){

        goalsFor[0] += score[i];
        goalsAgainst[0] += score[i + 1];

        goalsFor[1] += score[i + 1];
        goalsAgainst[1] += score[i];

    }

    else if(i == 2){

        goalsFor[0] += score[i];
        goalsAgainst[0] += score[i + 1];

        goalsFor[2] += score[i + 1];
        goalsAgainst[2] += score[i];

    }

    else if(i == 4){

        goalsFor[0] += score[i];
        goalsAgainst[0] += score[i + 1];

        goalsFor[3] += score[i + 1];
        goalsAgainst[3] += score[i];

    }

    else if(i == 6){

        goalsFor[1] += score[i];
        goalsAgainst[1] += score[i + 1];

        goalsFor[2] += score[i + 1];
        goalsAgainst[2] += score[i];

    }

    else if(i == 8){

        goalsFor[1] += score[i];
        goalsAgainst[1] += score[i + 1];

        goalsFor[3] += score[i + 1];
        goalsAgainst[3] += score[i];

    }

    else if(i == 10){

        goalsFor[2] += score[i];
        goalsAgainst[2] += score[i + 1];

        goalsFor[3] += score[i + 1];
        goalsAgainst[3] += score[i];

    }
     
    if(score[i] > score[i + 1]){

        if(i == 0){
            win[0]++;
            lose[1]++;
            points[0] += 3;
        }
        else if(i == 2){
            win[0]++;
            lose[2]++;
            points[0] += 3;
        }
        else if(i == 4){
            win[0]++;
            lose[3]++;
            points[0] += 3;
        }
        else if(i == 6){
            win[1]++;
            lose[2]++;
            points[1] += 3;
        }
        else if(i == 8){
            win[1]++;
            lose[3]++;
            points[1] += 3;
        }
        else if(i == 10){
            win[2]++;
            lose[3]++;
            points[2] += 3;
        }

    }
    
     else if(score[i] < score[i + 1]){

      if(i == 0){
        win[1]++;
        lose[0]++;
        points[1] += 3;
    }
      else if(i == 2){
        win[2]++;
        lose[0]++;
        points[2] += 3;
    }
      else if(i == 4){
        win[3]++;
        lose[0]++;
        points[3] += 3;
    }
    else if(i == 6){
        win[2]++;
        lose[1]++;
        points[2] += 3;
    }
    else if(i == 8){
        win[3]++;
        lose[1]++;
        points[3] += 3;
    }
     else if(i == 10){
        win[3]++;
        lose[2]++;
        points[3] += 3;
    }

    }else{

    if(i == 0){
        draw[0]++;
        draw[1]++;
        points[0]++;
        points[1]++;
    }
    else if(i == 2){
        draw[0]++;
        draw[2]++;
        points[0]++;
        points[2]++;
    }
    else if(i == 4){
        draw[0]++;
        draw[3]++;
        points[0]++;
        points[3]++;
    }
    else if(i == 6){
        draw[1]++;
        draw[2]++;
        points[1]++;
        points[2]++;
    }
    else if(i == 8){
        draw[1]++;
        draw[3]++;
        points[1]++;
        points[3]++;
    }
    else if(i == 10){
        draw[2]++;
        draw[3]++;
        points[2]++;
        points[3]++;
    }

 }
 
    } 
   
    for(int i = 0; i < 4; i++){
    goalsDifference[i] = goalsFor[i] - goalsAgainst[i];
    }
   
        // team with highest point
          

    int highestPoint = points[0];
      int champion = 0;

    for(int i = 1; i < 4; i++){

    if(points[i] > highestPoint){

        highestPoint = points[i];
        champion = i;

    }
    else if(points[i] == highestPoint){

        if(goalsDifference[i] > goalsDifference[champion]){

            champion = i;

             }
          }
      }

        String highestPoints = "";

         if(champion == 0){
            highestPoints = "A";
       
         }else if(champion == 1){
            highestPoints = "B";
         }
         else if(champion == 2){
           highestPoints = "C";
        }
          else if(champion == 3){
           highestPoints = "D";
            }
         
         
         
         System.out.println("===== STANDINGS =====");

         for(int i = 0; i < 4; i++){

         int matchesPlayed = win[i] + draw[i] + lose[i];

         System.out.println(
        "Team " + (char)('A' + i)
        + " | Played: " + matchesPlayed
        + " | Wins: " + win[i]
        + " | Draws: " + draw[i]
        + " | Losses: " + lose[i]
        + " | Points: " + points[i]
        + " | Goal Difference: " + goalsDifference[i]
        );
    }
        System.out.println("Match 1: Team A- Team B : "+score[0]+"-"+score[1]);
        System.out.println("Match 2: Team A- Team C : "+score[2]+"-"+score[3]);
        System.out.println("Match 3: Team A- Team D : "+score[4]+"-"+score[5]);
        System.out.println("Match 4: Team B- Team C : "+score[6]+"-"+score[7]);
        System.out.println("Match 5: Team B- Team D : "+score[8]+"-"+score[9]);
        System.out.println("Match 6: Team C- Team D : "+score[10]+"-"+score[11]);
        System.out.println("Tournament Champion: Team " + highestPoints);
        
        
    }
    
}
