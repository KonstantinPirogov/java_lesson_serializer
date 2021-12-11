package result;

import java.util.ArrayList;

public class Result {
    private ArrayList<AnswersForResult> answers = new ArrayList<>();

    //answers
    public ArrayList<AnswersForResult>  getAnswers () {
        return this.answers;
    }

    public void setAnswers(ArrayList<AnswersForResult> answers_ForResult_into_file) {
        this.answers = answers_ForResult_into_file;
    }

}
