package com.mahdi.service.entity;

public class VoteResultItem extends Entity<Integer> {

    private int itemId;
    private int count;
    private String item;

    public VoteResultItem(int itemId, int count, String item) {
        this.itemId = itemId;
        this.count = count;
        this.item = item;
    }

    public VoteResultItem(Integer id, int itemId, int count, String item) {
        super(id);
        this.itemId = itemId;
        this.count = count;
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
