package com.mahdi.service.entity;

public class Question extends Entity<Integer> {

    private String question;

    public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    public Question(Integer id, String question) {
        super(id);
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
