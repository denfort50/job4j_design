package ru.job4j.io.clientapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("Started, waiting for a connection.");
            while (!server.isClosed()) {
                Socket client = server.accept();
                System.out.println("Accepted. " + client.getInetAddress());
                try (DataInputStream in = new DataInputStream(client.getInputStream());
                     DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
                    String str = in.readUTF();
                    System.out.println(str);
                    if (str.contains("Hello")) {
                        out.writeUTF("Hello, Friend!");
                    } else if (str.contains("Exit")) {
                        out.writeUTF("Closing server...");
                        server.close();
                    } else {
                        out.writeUTF("Repeat please");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}