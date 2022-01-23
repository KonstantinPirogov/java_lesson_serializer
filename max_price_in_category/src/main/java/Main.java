import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //создаем объекты
        ObjectMapper mapper = new ObjectMapper();

        EveryPrice[] prices = mapper.readValue(
                new File("/Users/kpirogov/Downloads/for_2nd_dz/prices.json"),
                EveryPrice[].class);

        //хэш мап результатов: ключ - айди, значение - прайс
        HashMap<Integer, Integer> result_map = new HashMap<>();

        for (int i = 0; i < prices.length; i++) {
            // если в мапе есть такой айдишник и прайс больше - кладем туда новый прайс
            if (result_map.containsKey(prices[i].getCategory_id())) {
                if (prices[i].getPrice() > result_map.get(prices[i].getCategory_id())) {
                    result_map.put(prices[i].getCategory_id(), prices[i].getPrice());
                }
            // если в мапе нет айдишника - добавляем новую пару ключ - значение
            } else {
                result_map.put(prices[i].getCategory_id(), prices[i].getPrice());
            }
        }

        //выводим в цикле данные с мапы по порядку
        for (HashMap.Entry<Integer, Integer> entry: result_map.entrySet()) {

            System.out.println("Категория: " + entry.getKey());
            System.out.println("Максимальный прайс: " + entry.getValue());
            System.out.println();

        }
    }
}
