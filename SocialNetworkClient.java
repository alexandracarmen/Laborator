/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class SocialNetworkClient {

    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public SocialNetworkClient(String serverAddress, int port) throws IOException {
        this.socket = new Socket(serverAddress, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient(SERVER_ADDRESS, PORT);
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequestToServer(request);
            }
        }
    }

    //Implement the sendRequestToServer method
    public void sendRequestToServer(String request) throws IOException {
        try {
            out.println(request);
            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            System.err.println("No server listening ... " + e);
        }
    }

    String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
