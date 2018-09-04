package com.mahdi.service.entity;

public class VoteResult extends Entity<Integer> {

    private int question_Fk;
    private int item_Fk;

    public VoteResult() {
    }

    public VoteResult(int question_Fk, int item_Fk) {
        this.question_Fk = question_Fk;
        this.item_Fk = item_Fk;
    }

    public VoteResult(Integer id, int question_Fk, int item_Fk) {
        super(id);
        this.question_Fk = question_Fk;
        this.item_Fk = item_Fk;
    }

    public int getQuestion_Fk() {
        return question_Fk;
    }

    public void setQuestion_Fk(int question_Fk) {
        this.question_Fk = question_Fk;
    }

    public int getItem_Fk() {
        return item_Fk;
    }

    public void setItem_Fk(int item_Fk) {
        this.item_Fk = item_Fk;
    }
}
