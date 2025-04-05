package com.woragis;

public class Main {
    public static void main(String[] args) {
        // LinkedList myList = new LinkedList(0);
        // myList.add(20);
        // myList.add(30);
        // myList.add(50);
        // myList.add(60);
        // myList.add(70);
        // myList.add(80);
        // myList.iterateList();
        // myList.remove(30);
        // myList.iterateList();

        // LinkedList disciplinas = new LinkedList(null);
        // disciplinas.add(new Course("Data Structures", "Wallace"));
        // disciplinas.add(new Course("Object Oriented Programming", "Alvaro"));
        // disciplinas.add(new Course("SQL with MySql", "Alvaro"));
        // disciplinas.iterateList();
        Student jezreel = new Student("Jezreel", "378");

        jezreel.addCourse(new Course("Data Structures", "Wallace"));
        jezreel.addCourse(new Course("Object Oriented Programming with Java",
                "Joe"));
        jezreel.addCourse(new Course("Sql with MySql", "Alvaro"));
        jezreel.addCourse(new Course("Objective C", "Leonardo"));

        // jezreel.getCourses();
        Student carlos = new Student("Carlos", "377");

        carlos.addCourse(new Course("Data Structures", "Wallace"));
        carlos.addCourse(new Course("Object Oriented Programming with Java",
                "Joe"));
        carlos.addCourse(new Course("Sql with MySql", "Alvaro"));
        carlos.addCourse(new Course("Objective C", "Leonardo"));

        // carlos.getCourses();

        // Menu.mainloop();
        Students unipe = new Students(1);
        try {
            unipe.add(jezreel);
            unipe.increaseSize(2);
            unipe.add(carlos);
            unipe.view();
        } catch (Exception e) {
            System.out.println("Could not add more students");
        }
    }
}