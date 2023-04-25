package org.example.tema7;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private String name;
    private volatile boolean running=true;
    private int numberOfTokens;
    Exploration explore;
    private  boolean paused;
    public boolean fail=false;
    public Robot(String name,Exploration explore) {
        this.name = name;
        this.explore=explore;
        numberOfTokens=0;
        paused=false;
    }
    public boolean isRunning() {
        return running;
    }
    public void pauseRobot()
    {
        paused=true;
    }
    public void resumeRobot()
    {
        paused=false;
    }
    public void setNumberOfTokenset()
    {
        ++numberOfTokens;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
    public void stop()
    {
        running=false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void run() {
        while (running) {
            synchronized(this)
            {
                while(explore.isPaused()==true || paused==true)
            {
                try {
                    wait(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            }

                Random random1 = new Random();
                int row = random1.nextInt(5);
                Random random2 = new Random();
                int col = random2.nextInt(5);
                if (explore.getMap().visit(row, col, this) == false)
                    running = false;
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Robotul " + getName()+ " A stocat " + getNumberOfTokens()*5 + " token uri in matrice");
    }

   public String getName() {
        return name;
    }
}
