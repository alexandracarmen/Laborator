/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Codruta
 */
public class ClientThread {

    private Socket socket = null;
    private final SocialNetworkServer server;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.server = null;
    }

    // Create the constructor that receives a reference to the server and to the client socket
    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client -> server stream
                String request = in.readLine();
                String response = execute(request);
                PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream
                out.println(response);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Communication error" + e);
        } finally {
            try {
                socket.close(); //... usse try-catch-finally to handle the exceptions!
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    private String execute(String request) {
        // display the message: "Server received the request ... "
        return "Server received the request " + request;
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
