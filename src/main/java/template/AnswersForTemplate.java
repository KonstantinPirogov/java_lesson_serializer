package template;

public class AnswersForTemplate {
    private int id;
    private String value;

    //answer id
    public int getId() {
        return this.id;
    }

    public void setId(int answer_id_into_file) {
        this.id = answer_id_into_file;
    }


    //answer value
    public String getValue() {
        return this.value;
    }

    public void setValue(String answer_value_into_file) {
        this.value = answer_value_into_file;
    }
}
