package org.example.tema7;

public class TimeKeeper extends Thread {
    private long startTime;
    private volatile boolean stopped;
    private long time;
    private long limit;
    public TimeKeeper(long limit)
    {
        this.limit=limit;
        setDaemon(true);
        startTime = 0;
        stopped=false;
    }
    public void run()
    {
        startTime = System.currentTimeMillis();
        while(stopped==false)
        {
            time=System.currentTimeMillis() - startTime;
            if(time>limit)
            {System.out.println("S-a depasit limita de timp");
                stopped=true;
            break;}
            try {
                Thread.sleep(1000); // pauza de 1 secundă
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Explorarea a durat " + time + " milisecunde");
    }
    public void stopTime()
    {
        stopped=true;
    }

    public boolean isStopped() {
        return stopped;
    }
}
