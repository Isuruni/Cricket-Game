package com.Isuruni;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game_Manager1 extends Game_Manager{
     public static final String OUT = "out";
     public static final String BOWLED = "BOWLED";
     public static final String CAUGHT = "CAUGHT";
     static final int no_of_overs=5;
     static final int no_of_balls_per_over=3;
     Random random = new Random();
     
     protected void  batting(Team batting_team, int target_score, Scanner input) {
          System.out.println();
          System.out.println("Team " + batting_team.getTeam_name() + " is batting.");
          batting_team.setStatus(1);

          int total_balls = no_of_overs * no_of_balls_per_over;

          Player player = batting_team.getNextPlayer();

          for (int i = 1; i <= total_balls; i++) {
               if(target_score>0&&batting_team.getTotal_score()>target_score){
                   break;
               }
               orderToPlay(input);

               int result = player.bat(random);

               if (result == 5 || result == 7) {
                    System.out.println(player.getName() + " is out.");
                    player.setStatus(OUT);
                    player.setGotOutBy(result == 5 ? BOWLED : CAUGHT);

                    player = batting_team.getNextPlayer();

                    if (player== null) {
                         System.out.println();
                         System.out.println("All players of the team " + batting_team.getTeam_name() + " is out");

                         if (team.get(0).getStatus() == 1 && team.get(1).getStatus() == 1) {
                              break;
                         }
                         else if (batting_team.getTeam_name().equals(team.get(0).getTeam_name())) {
                              batting(team.get(1), team.get(0).getTotal_score(), input);
                         } else
                              batting(team.get(0), team.get(1).getTotal_score(), input);
                         break;
                         }
               }
               else {
                    System.out.println(result == 0 ? "Dot ball" : player.getName() + " obtained " + result + " runs.");
                    player.setScore(result);
                    batting_team.setCurrent_score(result);
                    batting_team.setTotal_score(result);
                    }

               String overs;
                    if (i == 0 && (i % 3 == 0)) {
                         overs = "( " + "1 " + "/" + "1" + " )";
                    } else {
                         overs = "( " + (((i % 3) == 0) ? i / 3 : (i / 3) + 1) + "/" + ((i % 3) == 0 ? 3 : (i % 3)) + " )";
                    }
                    System.out.println(overs);

                    if (i != 0 && i % 3 == 0) {
                    System.out.println();
                    System.out.println("End of over");

                    }

                    String summary = batting_team.getSummary();
                    System.out.println();
                    System.out.println("Summary of the team \n" + summary);

               if(i==total_balls){
                    if (team.get(0).getStatus()==1 && team.get(1).getStatus()==1) {
                         break;
                    }
                    else {
                         if (batting_team.getTeam_name().equals(team.get(0))) {
                              batting(team.get(1), team.get(0).getTotal_score(), input);
                         } else
                              batting(team.get(0), team.get(1).getTotal_score(), input);
                    }
               }

               }
     }

     public void winning(){
          System.out.println();
          System.out.println("Total score of " + team.get(0).getTeam_name()+" is "+team.get(0).getTotal_score());
          System.out.println("Total score of " + team.get(1).getTeam_name()+" is "+team.get(1).getTotal_score());
          System.out.println();
          if(team.get(0).getTotal_score()>team.get(1).getTotal_score()){
               System.out.println("Team "+ team.get(0).getTeam_name() + " won the match." );
          }
          else if(team.get(0).getTotal_score()<team.get(1).getTotal_score()){
               System.out.println("Team "+ team.get(1).getTeam_name() + " won the match." );
          }
          else{
               System.out.println("Match draw.");
          }
     }

}

