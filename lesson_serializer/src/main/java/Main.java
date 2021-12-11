import com.fasterxml.jackson.databind.ObjectMapper;
import result.AnswersForResult;
import result.Result;
import template.AnswersForTemplate;
import template.Questions;
import template.Template;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        //блок создания объектов
        ObjectMapper mapper = new ObjectMapper();
        Scanner console = new Scanner(System.in);
        Result result_this = new Result(); //не путать с пакетом резалт
        File result_file = new File("/Users/kpirogov/Downloads/for_2nd_dz/result.json");
        result_file.createNewFile(); //создаем файл резалт, если его нет
        ArrayList<AnswersForResult> temp_list_res_answers = new ArrayList<>(); //список для добавления в резалт

        //читаем темплейт
        Template template = mapper.readValue(
                new File("/Users/kpirogov/Downloads/for_2nd_dz/template.json"),
                Template.class);

        //вывод данных из темплейт и отработка логики
        for (Questions questions : template.getQuestions()) {
            System.out.println(questions.getTitle());
            //после вывода каждого вопроса выводим все ответы для него
            for (AnswersForTemplate cur_answer : questions.getAnswers()) {
                System.out.println(cur_answer.getId() + ". " + cur_answer.getValue());
            }

            //записываем айди вопроса в поле объекта темп
            AnswersForResult temp = new AnswersForResult();
            temp.setQuestion_id(questions.getId());

            //вводим номер ответа с консоли
            System.out.print("Введите номер ответа: ");
            int user_answer = console.nextInt();

            //находим айди ответа по введенному номеру
            for (AnswersForTemplate cur_answer : questions.getAnswers()) {
                if (user_answer == cur_answer.getId()) {
                    temp.setAnswer_id(cur_answer.getId()); //записываем айди ответа в поле объекта темп
                }
            }
            //добавляем объект темп в список
            temp_list_res_answers.add(temp);
        }
        //записываем список в файл резалт
        result_this.setAnswers(temp_list_res_answers);
        mapper.writeValue(result_file, result_this);
    }
}