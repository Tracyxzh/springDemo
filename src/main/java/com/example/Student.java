package com.example;

/**
 * Created by xiezhanghua on 2017/2/23.
 */
public class Student {
    private int id;
    private String name;
    private String info;
    private String className;
    private int classNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getClassNum() {
        return classNum;
    }
}
