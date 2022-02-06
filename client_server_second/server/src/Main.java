import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public final static int PORT = 12345;

    public static void main(String[] a) {

        Scanner console = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            // Блокируем пока не произойдет соединение
            Socket socket = serverSocket.accept(); // останавливаемся и ожидаем ВХОДЯЩЕГО соединения от клиента

            // создаём Reader для чтения из порта
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // создаём Writer для записи в порт
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            System.out.println("Введите exit если хотите закрыть чат");
            while (true) {
                //общение клиента с сервером
                System.out.println("Введите сообщение для клиента: ");
                String message_from_server = console.nextLine();
                if (message_from_server.equals("exit")) {
                    out.println(message_from_server);
                    break;
                }

                out.println(message_from_server);
                String readedStringFromClient = in.readLine();

                if (readedStringFromClient.equals("exit")) {
                    System.out.println("Закрытие чата инициировано клиентом");
                    break;
                }
                System.out.println("От клиента принята строка " + readedStringFromClient);
            }

            // закрываем соединение
            in.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}