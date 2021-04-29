package com.Isuruni;
import java.util.Random;

public  class Player {
    private String name;
    private int score;
    private String gotOutBy;
    private String wicket_type;
    private String status;

    Player(String name){
        setName(name);
        setScore(0);
        setGotOutBy(null);
        setWicket_type(null);
        setStatus("Not Yet Bat");
    }
    Player (){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setScore(int score){
        this.score+=score;
    }

    public int getScore() {
        return score;
    }

    public void setGotOutBy(String gotOutBy) {
        this.gotOutBy = gotOutBy;
    }

    public String getGotOutBy() {
        return gotOutBy;
    }

    public void setWicket_type(String wicket_type) {
        this.wicket_type = wicket_type;
    }

    public String getWicket_type() {
        return wicket_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public int bat(Random random){
        return random.nextInt(8);
    }

}
class SuperPlayer extends Player{

    private int min_score;

    SuperPlayer(String name,int min_score) {
        super(name);
        this.setMin_score(min_score);
    }

    public void setMin_score(int min_score) {
        this.min_score = min_score;
    }

    public int getMin_score() {
        return this.min_score;
    }

    public int bat(Random random){
        int result= random.nextInt(8);
        while(result<getMin_score()){
            result= random.nextInt(8);
        }
        return result;
    }

}

