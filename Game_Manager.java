package com.Isuruni;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract  class Game_Manager {
    private final static int N0_OF_TEAMS=2;
    abstract protected void batting(Team batting_team, int target_score, Scanner input);
     List<Team> team= new ArrayList<>();
     Scanner input=new Scanner(System.in);
    public String t;

    public void play_Game(){

            create_teams(team,input);

    }

    public void create_teams(List<Team> team,Scanner input) {
        for(int i=0;i<N0_OF_TEAMS;i++){
            System.out.print("Provide The name of the team  "+(i+1) +" : ");
            String name=input.nextLine();

            while(name==null||name.isEmpty()) {
                System.out.println("Please enter a valid name.");
                name=input.nextLine();
            }
            Team team1=new Team(name,6);
            team.add(team1);



        }
    }

    protected void orderToPlay(Scanner input){
        System.out.println();
        System.out.println("Press p if you want to play");
        String play=input.next();
        while(!play.equalsIgnoreCase("p")){
            System.out.println("PLease enter p to continue.");
            play=input.next();

        }
    }
    public void toss(Random random){
        int t=random.nextInt(2);
        if(t==0){
            team.get(0).setToss(true);
        }
        else{
            team.get(1).setToss(true);
        }
    }

}