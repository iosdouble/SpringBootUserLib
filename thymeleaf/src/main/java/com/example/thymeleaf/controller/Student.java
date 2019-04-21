package com.example.thymeleaf.controller;

/**
 * @ClassName Student
 * @Author nihui
 * @Date 2019/4/21 19:05
 * @Version 1.0
 * @Description TODO
 */
public class Student {
    private Integer sid;
    private String sName;
    private Integer sAge;
    private String sSex;

    public Student(Integer sid, String sName, Integer sAge, String sSex) {
        this.sid = sid;
        this.sName = sName;
        this.sAge = sAge;
        this.sSex = sSex;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }
}


