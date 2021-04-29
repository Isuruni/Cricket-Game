package com.Isuruni;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {
        Game_Manager1 GM1 = new Game_Manager1();
        GM1.play_Game();
        GM1.toss(GM1.random);

        if (GM1.team.get(0).getToss() == true) {
            GM1.batting(GM1.team.get(0), 0, GM1.input);

        } else {
            GM1.batting(GM1.team.get(1), 0, GM1.input);

        }

        GM1.winning();


    }
}





