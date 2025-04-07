package com.woragis;

import com.woragis.abstracts.Person;
import com.woragis.constants.Messages;

public class Student extends Person {
    private String rgm;
    private Courses courses;

    public Student(String name, String rgm) {
        this.name = name;
        this.rgm = rgm;
        this.courses = new Courses();
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

    public void removeCourse(String courseName) {
        this.courses.remove(courseName);
    }

    public void getCourses() {
        this.courses.iterateList();
    }

    @Override
    public String toString() {
        return Messages.STUDENT + " [nome=" + name + ", rgm=" + rgm + "]";
    }

}
