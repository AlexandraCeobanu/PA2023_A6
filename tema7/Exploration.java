package org.example.tema7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();
    private volatile boolean paused=false;
    TimeKeeper timeKeeper =new TimeKeeper(30000);
    Thread[] threads =new Thread[3];
    public void start () throws InterruptedException, IOException {
        int i=0;
        for (Robot robot : robots) {
            threads[i]= new Thread(robot);
        ++i;}

        Scanner scanner =new Scanner(System.in);
        while(map.checkUnvisitedCells(map.getMatrix())!=0 && timeKeeper.isStopped()==false)
        {
            if (System.in.available() > 0){
            String command = scanner.nextLine();
             if(command.equals("start robots")) {
                startRobots();
            }
            else if(command.equals("pause robots")){
                pauseRobots();
            }
            else if(command.equals("resume robots"))
             {
                 resumeRobots();
             }
            else if(command.equals("pause"))
             {
                 pauseOneRobot();
             }
            else if(command.equals("resume"))
             {
                 resumeOneRobot();
             }
            else if(command.equals("end")){
                System.out.println("Jocul s-a terminat");
                break;
            }}
            if(timeKeeper.isStopped()==true)
            {
                for (Robot robot : robots)
                {
                    robot.stop();
                }
                break;
            }
        }
        System.out.println("Nu mai exista celule nevizitate");
        if(timeKeeper.isStopped()==true)
        {

            for (Robot robot : robots)
            {
                if(robot.isPaused()==true)
                    robot.resumeRobot();
                robot.stop();
            }
        }
        timeKeeper.stopTime();
        sleep(1000);
    }
    public void startRobots() throws InterruptedException {
        timeKeeper.start();
        for( int i=0;i<3;i++)
        {
            threads[i].start();
        }
    }
    public void pauseRobots()
    {
        paused=true;
    }
    public void resumeRobots()
    {
        paused=false;
    }
    public void pauseOneRobot() throws InterruptedException {
        pauseRobots();
        System.out.println("Numele robotului: ");
        Scanner scanner =new Scanner(System.in);
        String nume = scanner.nextLine();
        for(Robot robot:robots)
        {
            if(nume.equals( robot.getName()))
            {
                resumeRobots();
                robot.pauseRobot();
                System.out.println(robot.getName() + " A fost pus in pauza");
                break;
            }
        }
    }
    public void resumeOneRobot() throws InterruptedException {
        pauseRobots();
        System.out.println("Numele robotului: ");
        Scanner scanner =new Scanner(System.in);
        String nume = scanner.nextLine();
        for(Robot robot:robots)
        {
            if(nume.equals( robot.getName()))
            {
                resumeRobots();
                robot.resumeRobot();
                System.out.println(robot.getName() + " si-a reluat executia");
                break;
            }
        }
    }
    public void addRobot(Robot robot)
    {
        robots.add(robot);
    }
    public static void main(String args[]) throws InterruptedException, IOException {
        var explore = new Exploration();
        /*playerThread.start();*/
        explore.addRobot(new Robot("Wall-E",explore));
        explore.addRobot(new Robot("R2D2",explore));
        explore.addRobot(new Robot("Optimus Prime",explore));
        explore.start();
    }
    public boolean isPaused() {
        return paused;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }
}
