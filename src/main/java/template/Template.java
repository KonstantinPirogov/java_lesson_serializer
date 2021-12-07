package template;

import java.util.ArrayList;

public class Template {
    private ArrayList<Questions> questions = new ArrayList<>();

    //answers
    public ArrayList<Questions> getQuestions () {
        return this.questions;
    }

    public void setQuestions(ArrayList<Questions> questions_into_file) {
        this.questions = questions_into_file;
    }

}
