package com.frontier.back.lemon_tree.data.output;

public class StaticInformation {
    private String title;

    private String respuestaEscrita;

    public StaticInformation(String title, String respuestaEscrita) {
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
