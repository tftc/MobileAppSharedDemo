package com.mvvm.model;

/**
 * Created by dayku on 16/1/21.
 */
public class User {
    private String lastname;
    private String firstname;
    private String sex;
    private int age;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String lastname, String firstname, String sex, int age) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.age = age;
    }

    public User() {
    }
}
