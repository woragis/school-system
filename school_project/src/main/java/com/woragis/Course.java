package com.woragis;

public class Course {
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
