import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        convert_string();
        find_coins();
    }

    public static void convert_string() {
        //блок объявления и подготовки к преобразованию
        String original_string = "AAAABBXYZFFAA";
        System.out.println(original_string);
        char[] char_array_from_string = original_string.toCharArray();
        ArrayList<Character> result_list = new ArrayList<>();
        int char_counter = 1;
        char current_char = char_array_from_string[0];

        //преобразование строки
        for (int i = 1; i < char_array_from_string.length; i++) {
            if (char_array_from_string[i - 1] == char_array_from_string[i]) {
                char_counter++;
            } else {
                result_list.add(current_char);
                result_list.add((char) (char_counter + '0'));

                current_char = char_array_from_string[i];
                char_counter = 1;
            }
            if (i == char_array_from_string.length - 1) {
                result_list.add(current_char);
                result_list.add((char) (char_counter + '0'));
            }
        }

        //вывод списка result_list с преобразованной строкой на экран
        for (int i = 0; i < result_list.size(); i++) {
            Character current = result_list.get(i);
            if (current.charValue() != (char) 1 + '0') {
                System.out.print(current);
            }
        }
    }

    public static void find_coins() {
        //вводим массив монет int
        Scanner console_scan = new Scanner(System.in);
        System.out.println("Введите количество монет: ");
        int N = console_scan.nextInt();
        int[] coin_array = new int[N];
        for (int i = 0; i < coin_array.length; i++) {
            System.out.println("Введите очередной номинал монеты: ");
            coin_array[i] = console_scan.nextInt();
        }

        System.out.println("Введите сумму, которую необходимо собрать: ");
        int summ = console_scan.nextInt();

        //сортируем массив по возрастанию
        int bubble_proxy = 0;
        for (int j = 0; j < coin_array.length - 1; j++) {
            for (int i = j + 1; i < coin_array.length; i++) {
                if (coin_array[j] > coin_array[i]) {
                    bubble_proxy = coin_array[j];
                    coin_array[j] = coin_array[i];
                    coin_array[i] = bubble_proxy;
                }
            }
        }
        System.out.println("Имеем монеты с номиналами: ");
        for (int j : coin_array) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("Сумма = " + summ);

        //находим номиналы которые нам нужны по принципу "продавщицы" - берем максимально возможные номиналы
        ArrayList<Integer> result_list = new ArrayList<>();
        for (int k = coin_array.length - 1; k >= 0; k--) {
            int number_of_coins = summ / coin_array[k];
            if (number_of_coins != 0) {
                result_list.add(coin_array[k]);
                result_list.add(number_of_coins);
            }
            summ = summ - (coin_array[k] * number_of_coins);
            if (summ <= 0) {
                break;
            }
        }

        System.out.println("Необходимо монет: ");
        for (int i = 0; i < result_list.size(); i = i + 2) {
            int current_nominal = result_list.get(i);
            int current_number = result_list.get(i + 1);
            System.out.println(current_nominal + "р " + current_number + "шт");
        }
        if (summ > 0) {
            System.out.println("Недостаточно монет данных номиналов, чтобы собрать введенную сумму");
            System.out.println("Не смогли собрать " + summ + "р");
        }
    }
}
