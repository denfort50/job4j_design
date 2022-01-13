package ru.job4j.io.clientapp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 9000)) {
            try (DataOutputStream out = new DataOutputStream(client.getOutputStream());
                 DataInputStream in = new DataInputStream(client.getInputStream())) {
                Scanner keyboard = new Scanner(System.in);
                while (true) {
                    String request = keyboard.nextLine();
                    System.out.println("Your request: " + request);
                    out.writeUTF(request);
                    String response = in.readUTF();
                    System.out.println("Server's response: " + response);
                    if ("Exit".equals(request)) {
                        System.out.println("Client is closing...");
                        client.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
