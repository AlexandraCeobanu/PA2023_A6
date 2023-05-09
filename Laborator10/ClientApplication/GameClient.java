package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            Scanner input=new Scanner(System.in);
            System.out.println("Enter a command: ");
            String request;
            request = input.nextLine();
                while(request.equals("exit")==false)
                {
                out.println(request);
            // Wait the response from the server ()
                    String response = in.readLine ();
                System.out.println(response);

                if(request.equals("stop")==true){
                    break;
                }


                System.out.println("Enter a command: ");
                request = input.nextLine();
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }