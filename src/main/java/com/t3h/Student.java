package com.t3h;

public class Student {
    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }


}
