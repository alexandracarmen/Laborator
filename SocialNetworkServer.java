/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Codruta
 */
public class SocialNetworkServer {

    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args) throws IOException {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
    }

    // Implement the init() method: create the serverSocket and set running to true
    public void init() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            this.running = true;
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.
    public void waitForClients() throws IOException {
        try {
            while (this.running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            serverSocket.close();
        }
    }

    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();

    }
}
