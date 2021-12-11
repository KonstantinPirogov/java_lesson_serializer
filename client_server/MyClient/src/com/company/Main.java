package com.company;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        String hostname = "localhost"; // IP or Domain
        int port = 1488;

        Socket socket = new Socket(hostname, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // Отправить данные на сервер
        out.write("14,88\n");
        out.flush();

        String word = in.readLine();
        System.out.println("Получили от сервера: " + word);

        System.out.println("Завершили работу!");
    }
}
