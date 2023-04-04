package org.example.laborator7;

import java.util.Random;

public class Robot implements Runnable {
    private String name;
    private boolean running=true;
    Exploration explore;
    public Robot(String name,Exploration explore) {
        this.name = name;
        this.explore=explore;
    }
    public void run() {
        while (running) {
            Random random1 = new Random();
            int row = random1.nextInt(5);
            Random random2 = new Random();
            int col = random2.nextInt(5);
            if(explore.getMap().visit(row,col, this)==false)
                running=false;
        }
    }

    public String getName() {
        return name;
    }
}
