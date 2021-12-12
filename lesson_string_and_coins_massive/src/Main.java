import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        convert_string();
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
}
