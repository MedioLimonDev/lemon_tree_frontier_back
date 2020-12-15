package com.frontier.back.lemon_tree.biz.vo;

public class ResponseVO extends ModelVO{
    private String description;

    private int idOriginalStep;

    private int idNextStep;

    private String response_type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOriginalStep() {
        return idOriginalStep;
    }

    public void setIdOriginalStep(int idOriginalStep) {
        this.idOriginalStep = idOriginalStep;
    }

    public int getIdNextStep() {
        return idNextStep;
    }

    public void setIdNextStep(int idNextStep) {
        this.idNextStep = idNextStep;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }
}
