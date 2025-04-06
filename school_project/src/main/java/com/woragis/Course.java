package com.woragis;

import java.io.Serializable;

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
        return "Course [name=" + name + ", teacher=" + teacher + "]";
    }

}
