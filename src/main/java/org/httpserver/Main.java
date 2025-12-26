package org.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        System.out.println("Logs from your program will appear here!");

        try {
            ServerSocket serverSocket = new ServerSocket(4221);

            // Since the tester restarts your program quite often, setting SO_REUSEADDR
            // ensures that we don't run into 'Address already in use' errors
            serverSocket.setReuseAddress(true);

            Socket clientSocket = serverSocket.accept(); // Wait for connection from client.
            System.out.println("accepted new connection");

            //object to read from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //object to write to the socket
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //reading and printing the message from the client
            String request = in.readLine();
            System.out.println("Message from the client: " + request);

            //sending and printing the response to the client
            String response = "HTTP/1.1 200 OK\r\n\r\n";
            out.println(response);
            System.out.println("Message sent to the client: " + response);

            //closing the socket
            clientSocket.close();


        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
