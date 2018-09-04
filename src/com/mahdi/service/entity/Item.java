package com.mahdi.service.entity;

public class Item extends Entity<Integer> {

    private String item;
    private int question_Fk;

    public Item() {
    }

    public Item(String item, int question_Fk) {
        this.item = item;
        this.question_Fk = question_Fk;
    }

    public Item(Integer id, String item, int question_Fk) {
        super(id);
        this.item = item;
        this.question_Fk = question_Fk;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuestion_Fk() {
        return question_Fk;
    }

    public void setQuestion_Fk(int question_Fk) {
        this.question_Fk = question_Fk;
    }
}
