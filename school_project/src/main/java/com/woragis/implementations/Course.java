package com.woragis.implementations;

import java.io.Serializable;

import com.woragis.constants.Messages;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Teacher teacher;

    public Course(String name, String teacherName) {
        this.name = name;
        this.teacher = new Teacher(teacherName);
    }

    @Override
    public String toString() {
        return Messages.COURSE + " [nome=" + name + ", professor=" + teacher + "]";
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
