package com.woragis;

public class Teacher extends Person {
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher [" + this.name + "]";
    }

}
