package com.woragis.implementations;

import com.woragis.abstracts.Person;

public class Teacher extends Person {
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher [" + this.name + "]";
    }

}
