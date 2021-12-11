package com.company;

import java.io.*;
import java.net.Socket;

public class ClientWorker extends Thread {
    private Socket socket; // сокет, через который сервер общается с клиентом,
    // кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    public ClientWorker(Socket socket) throws IOException {
        this.socket = socket;
        // если потоку ввода/вывода приведут к генерированию исключения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); // вызываем run()
    }

    @Override
    public void run() {
        try {
            String client_string = in.readLine();
            System.out.println("Получили от клиента: " + client_string);
            int first_num = Integer.parseInt(client_string.split(",")[0]);
            int second_num = Integer.parseInt(client_string.split(",")[1]);
            int summa = first_num + second_num;
            send(summa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(int summa) {
        try {
            out.write(summa + " сумма в строке\n");
            out.flush();
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

}
