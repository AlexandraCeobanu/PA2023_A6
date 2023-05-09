package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;

    public ClientThread (Socket socket) { this.socket = socket ; }

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
            // Send the response to the oputput stream: server → client
           else
            {
                raspuns = "Server received the request ... ";
            }
            out.println(raspuns);
            out.flush();}
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }}
