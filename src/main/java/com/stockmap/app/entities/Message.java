package com.stockmap.app.entities;

import org.springframework.stereotype.Component;

@Component
public class Message {

    private String messagem;


    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
}
