package com.mahdi.service.entity;

public class User extends Entity<Integer> {

    private String userName;
    private String passWord;
    private String displayName;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(Integer id, String userName, String passWord) {
        super(id);
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, String displayName) {
        this.userName = userName;
        this.passWord = passWord;
        this.displayName = displayName;
    }

    public User(int id, String userName, String passWord, String displayName) {
        super(id);
        this.userName = userName;
        this.passWord = passWord;
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
