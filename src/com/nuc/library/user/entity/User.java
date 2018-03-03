package com.nuc.library.user.entity;

public class User {

    int id;
    String college;
    String year;
    String major;
    String type;
    String username;
    String password;
    String sex;

    public User() {
    }

    public User(int id, String college, String year, String major, String type, String username, String password, String sex) {

        this.id = id;
        this.college = college;
        this.year = year;
        this.major = major;
        this.type = type;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
