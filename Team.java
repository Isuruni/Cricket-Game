package com.Isuruni;

import java.util.ArrayList;

public  class Team {
    public static final String BATTING = "Batting";
    private String team_name;
    private int total_score;
    private int total_wickets;
    private ArrayList<Player> players=new ArrayList<>();
    private int current_batsman;
    private int current_score;
    private Boolean toss;
    private int status;

    Team(String team_name, int n0_of_players){
        setTeam_name(team_name);
        setTotal_score(0);
        setCurrent_score(0);
        setTotal_wickets(-1);
        setCurrent_batsman(-1);
        setToss(false);
        setPlayers( n0_of_players);

    }
    Team(){

    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_name() {
        return this.team_name;
    }

    public void setTotal_score(int total_score) {
        this.total_score += total_score;
    }

    public int getTotal_score() {
        return this.total_score;
    }

    public void setTotal_wickets(int total_wickets) {
        this.total_wickets += total_wickets;
    }

    public int getTotal_wickets() {
        return this.total_wickets;
    }

    public void setCurrent_batsman(int current_batsman) {
        this.current_batsman += current_batsman;
    }

    public int getCurrent_batsman() {
        return this.current_batsman;
    }

    public void setCurrent_score(int current_score) {
        this.current_score += current_score;
    }

    public int getCurrent_score() {
        return this.current_score;
    }

    public void setToss(Boolean toss) {
        this.toss = toss;
    }

    public Boolean getToss() {
        return this.toss;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus(){
        return status;
    }

    public void setPlayers(int no_of_players) {

        for(int i=0;i<(no_of_players/2);i++){
            Player player=new Player("Player "+(i+1));
            players.add(player);
        }
        for(int i=(no_of_players/2);i<no_of_players;i++){
            Player player=new SuperPlayer("Player "+(i+1), 4);
            players.add(player);
        }

    }


    public Player getNextPlayer(){
        setCurrent_batsman(1);
        if (getCurrent_batsman()>=this.players.size()){
            return null;
        }
        setTotal_wickets(1);
        Player nextPlayer=players.get(getCurrent_batsman());
        nextPlayer.setStatus(BATTING);
        return nextPlayer;
    }
    public String getSummary(){
        return "Total score now : "+ getCurrent_score()+ "\n"+"Total wickets now : "+ getTotal_wickets();
    }
    
}
