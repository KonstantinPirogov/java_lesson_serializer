package result;

import java.util.ArrayList;

public class AnswersForResult {
    private int question_id;
    private int answer_id;

    //question id
    public int getQuestion_id() {
        return this.question_id;
    }

    public void setQuestion_id(int question_id_into_file) {
        this.question_id = question_id_into_file;
    }

    //answer id
    public int getAnswer_id() {
        return this.answer_id;
    }

    public void setAnswer_id(int answer_id_into_file) {
        this.answer_id = answer_id_into_file;
    }
}
