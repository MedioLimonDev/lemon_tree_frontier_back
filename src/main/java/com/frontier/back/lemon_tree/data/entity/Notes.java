package com.frontier.back.lemon_tree.data.entity;

public class Notes extends Model {
    private String stepTitle;

    private String responseQuestion;

    private String description;

    public Notes(String title, String response, String note) {
        super();
    }

    public String getStepTitle() {
        return stepTitle;
    }

    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }

    public String getResponseQuestion() {
        return responseQuestion;
    }

    public void setResponseQuestion(String responseQuestion) {
        this.responseQuestion = responseQuestion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
