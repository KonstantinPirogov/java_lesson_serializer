import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public final static int PORT = 12345;

    public static void main(String[] args) throws IOException {

        Scanner console = new Scanner(System.in);

        try {
            // соединяемся с сервером
            Socket socket = new Socket("localhost", PORT);

            // создаём Reader для приёма данных от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // создаём Writer для отправки данных серверу
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            System.out.println("Введите exit если хотите закрыть чат");
            while (true) {
                //общение клиента с сервером

                String readedStringFromServer = in.readLine();
                System.out.println("Получено от сервера: " + readedStringFromServer);

                if (readedStringFromServer.equals("exit")) {
                    System.out.println("Закрытие чата инициировано сервером");
                    break;
                }

                System.out.println("Введите сообщение для сервера: ");
                String message_from_client = console.nextLine();

                out.println(message_from_client);
                if (message_from_client.equals("exit")) {
                    break;
                }
            }

            // закрываем соединение
            in.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}