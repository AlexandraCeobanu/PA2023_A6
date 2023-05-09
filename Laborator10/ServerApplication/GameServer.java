package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class GameServer {
    public static final int PORT = 8100;
    private  volatile static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
                sleep(10000);
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            serverSocket.close();
        }
    }

  synchronized  public static void stop() {
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }
}