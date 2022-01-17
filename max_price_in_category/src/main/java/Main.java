import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //создаем объекты
        ObjectMapper mapper = new ObjectMapper();

        EveryPrice[] prices = mapper.readValue(
                new File("/Users/kpirogov/Downloads/for_2nd_dz/prices.json"),
                EveryPrice[].class);

        //ищем максимальный номинал категории
        int max_element = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i].getCategory_id() > max_element) {
                max_element = prices[i].getCategory_id();
            }
        }

        // массив результатов: индекс = категория, элемент = максимальный прайс. Нулевой индекс пропустим
        int[] array = new int[max_element + 1];

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if ( i == prices[j].getCategory_id() && prices[j].getPrice() > array[i]) {
                    array[i] = prices[j].getPrice();
                }
            }
        }

        //выводим результат
        for (int i = 1; i < array.length; i++) {
            System.out.println("Категория: " + i);
            System.out.println("Максимальный прайс: " + array[i]);
            System.out.println();
        }
    }
}
