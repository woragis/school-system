package com.woragis;

public class Student extends Person {
    private String rgm;

    public Student(String name, String rgm) {
        this.name = name;
        this.rgm = rgm;
    }

    public String getName() {
        return name;
    }

    public String getRgm() {
        return rgm;
    }

}
