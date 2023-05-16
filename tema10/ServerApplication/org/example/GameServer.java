package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class GameServer {
    public static final int PORT = 8100;
    private  volatile static boolean running = true;
    private static Board[] boards = new Board[10];
    private static Game[] games = new Game[10];
    private static Player[] players =new Player[11];
    private static int nrBoards = 0;
    private static int nrGames = 0;
    private static ClientThread[] threads =new ClientThread[2];
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            int i=1;
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket,i).start();
                players[i++]=new Player(i);

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
    public static Board createBoard()
    {
        boards[nrBoards]=new Board();
        ++nrBoards;
        return boards[nrBoards-1];
    }
    public static Game createGame()
    {
        games[nrGames]=new Game();
        ++nrGames;
        return games[nrGames-1];
    }

    public static Board[] getBoards() {
        return boards;
    }

    public static Game[] getGames() {
        return games;
    }
}