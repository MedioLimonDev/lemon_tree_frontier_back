package com.frontier.back.lemon_tree.biz.vo;

public class FlowRecordVO {
    private int idRecord;
    private int idStep;
    private int idResponse;
    private String respuestaEscrita;
    private String note;

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdStep() {
        return idStep;
    }

    public void setIdStep(int idStep) {
        this.idStep = idStep;
    }

    public int getIdResponse() {
        return idResponse;
    }

    public void setIdResponse(int idResponse) {
        this.idResponse = idResponse;
    }

    public String getRespuestaEscrita() {
        return respuestaEscrita;
    }

    public void setRespuestaEscrita(String respuestaEscrita) {
        this.respuestaEscrita = respuestaEscrita;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
