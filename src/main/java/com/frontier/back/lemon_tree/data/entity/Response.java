package com.frontier.back.lemon_tree.data.entity;

public class Response extends Model{
    private String description;

    private int idOriginalStep;

    private int idNextStep;

    private String responseType;

    public Response() { }

    public Response(int id, String description, int id_original_step, int id_next_step, String responseType) {
        super();
        this.id = id;
        this.description = description;
        this.idOriginalStep = id_original_step;
        this.idNextStep = id_next_step;
        this.responseType = responseType;
    }

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

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
