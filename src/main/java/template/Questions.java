package template;

import java.util.ArrayList;

public class Questions {
    private int id;
    private String title;
    private ArrayList<AnswersForTemplate> answers = new ArrayList<>();

    //id
    public int getId() {
        return this.id;
    }

    public void setId(int id_into_file) {
        this.id = id_into_file;
    }

    //title
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String question_into_file) {
        this.title = question_into_file;
    }

    //answers
    public ArrayList<AnswersForTemplate> getAnswers () {
        return this.answers;
    }

    public void setAnswers(ArrayList<AnswersForTemplate> answers_ForTemplate_into_file) {
        this.answers = answers_ForTemplate_into_file;
    }
}
