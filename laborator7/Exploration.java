package org.example.laborator7;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap();
    private final List<Robot> robots = new ArrayList<>();
    public void start() throws InterruptedException {
        for (Robot robot : robots) {
            new Thread(robot).run();
        }
        System.out.println("Nu mai exista celule nevizitate");
        System.out.println(map.toString());
    }
    public void addRobot(Robot robot)
    {
        robots.add(robot);
    }
    public static void main(String args[]) throws InterruptedException {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E",explore));
        explore.addRobot(new Robot("R2D2",explore));
        explore.addRobot(new Robot("Optimus Prime",explore));
        explore.start();
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }
}
