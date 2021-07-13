package com.frontier.back.lemon_tree.biz.output;

public class StaticInformationVO {
    private String title;

    private String respuestaEscrita;

    public StaticInformationVO(String title, String respuestaEscrita) {
        this.title = title;
        this.respuestaEscrita = respuestaEscrita;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRespuestaEscrita() {
        return respuestaEscrita;
    }

    public void setRespuestaEscrita(String respuestaEscrita) {
        this.respuestaEscrita = respuestaEscrita;
    }
}
