package com.zy.domain;

public class Student {
    private String name;
    private String sid;
    private int age;
    private String birthday;

    public Student() {
    }

    public Student(String name, String sid, int age, String birthday) {
        this.name = name;
        this.sid = sid;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
