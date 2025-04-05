package com.woragis;

public class Student extends Person {
    private String rgm;
    private LinkedList courses;

    public Student(String name, String rgm) {
        this.name = name;
        this.rgm = rgm;
        this.courses = new LinkedList(null);
    }

    public String getName() {
        return name;
    }

    public String getRgm() {
        return rgm;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public void getCourses() {
        this.courses.iterateList();
    }

}
