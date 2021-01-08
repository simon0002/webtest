package com.example.webtest.entity;

public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassWord(){
        return this.passWord;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getRealName(){
        return this.realName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
