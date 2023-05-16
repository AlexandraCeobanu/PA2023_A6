package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class ClientThread extends Thread {
    private Socket socket = null ;
    private  Board board;
    private Game game;
    private int idJucator;
    public ClientThread (Socket socket, int id) { this.socket = socket ;
        idJucator=id;
    }

    public void run () {

        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request;
            while((request = in.readLine()) != null ) {
            System.out.println("I received the command : " + request);
            String raspuns=new String();
            if(request.equals("stop"))
            {
                raspuns="Server Stopped...";
                out.println(raspuns);
                out.flush();
                GameServer.stop();
                break;
            }
            else if (request.equals("create game"))
            {
                createGame();
                raspuns= board.matrixToString(board.getBoard());
            }
            else if (request.contains("submit"))
            {
                if(game.getPlayer()!=idJucator || game.getNrJucatori()==1){
                raspuns=submitMove(request);
                }
                else
                {  raspuns="Nu este randul tau...";
                    raspuns=raspuns + "\n";
                    raspuns =raspuns +"#";
            }}
            else if(request.equals("restart game"))
            {
                restartGame();
                raspuns= board.matrixToString(board.getBoard());
            }
            else if(request.contains("join game"))
            {
                raspuns=joinGame(request);
            }
            else if (request.equals("exit"))
            {
                game.removePlayer();
                break;
            }
            // Send the response to the output stream: server → client
           else
            {
                raspuns = "Server received the request ... ";
                raspuns=raspuns + "\n";
                raspuns =raspuns +"#";
            }
           if(request.equals("exit")==false)
           { out.println(raspuns);
            out.flush();}}
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
    public  void createGame()
    {
        board=GameServer.createBoard();
        game=GameServer.createGame();
        //board=new Board();
        //game =new Game();
    }
    public String submitMove(String request)
    {
        String raspuns;
        if(game.isGameOver()==false){
            int linie=parseInt(request.substring(7,8));
            int coloana=parseInt(request.substring(9,10));
            if(board!=null)
            {
                if(game.getNrJucatori()>1)
                game.setPlayer(idJucator);

                if(board.updateMatrix(board.getBoard(),linie,coloana,idJucator)==true){

                    if(game.checkWinner(board,linie,coloana)==true)
                    {
                        raspuns = "Jocul s-a terminat, ai castigat ... ";
                        raspuns=raspuns + "\n";
                        raspuns =raspuns + board.matrixToString(board.getBoard());
                    }
                    else
                        raspuns= board.matrixToString(board.getBoard());
                }
                else
                {
                    raspuns = "Coordonate gresite ... ";
                    raspuns=raspuns + "\n";
                    raspuns =raspuns +"#";
                }
            }
            else
            {
                raspuns = "Nu faci parte dintr-un joc ... ";
                raspuns=raspuns + "\n";
                raspuns =raspuns +"#";
            }
        }
        else
        {
            raspuns = "Jocul s-a terminat , pentru a juca din  nou foloseste comanda 'restart game' ";
            raspuns=raspuns + "\n";
            raspuns =raspuns +"#";
        }
        return raspuns;
    }
    public String joinGame(String request)
    {
        int id=parseInt(request.substring(10));
        board=GameServer.getBoards()[id];
        game=GameServer.getGames()[id];
        game.setNrJucatori();
        String raspuns = null;
        if(game.isGameOver()==false){
            raspuns = "Te-ai alaturat jocului... ";
            raspuns=raspuns + "\n";
            raspuns =raspuns + board.matrixToString(board.getBoard());
        }
        return raspuns;
    }
    public void restartGame()
    {
        board.resetBoard();
        game.setGameOver(false);
    }

}
