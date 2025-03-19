package com.spring.dto;

import jdk.jfr.DataAmount;

public class PostRequest {
    private String title;
    // TODO: adauga restul atributelor

    public PostRequest() {}
    public PostRequest(String title, String content) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    // Setteri
    public void setTitle(String title) {
        this.title = title;
    }
}
