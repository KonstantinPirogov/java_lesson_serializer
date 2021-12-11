package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Main {
    public static final int PORT = 1488;
    public static LinkedList<ClientWorker> clients = new LinkedList<>(); // список всех клиентов

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {
                    clients.add(new ClientWorker(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    e.printStackTrace();
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его при завершении работы:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
