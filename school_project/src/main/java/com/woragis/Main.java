package com.woragis;

import java.util.Scanner;

import com.woragis.constants.Errors;
import com.woragis.constants.Messages;
import com.woragis.implementations.Course;
import com.woragis.implementations.Student;
import com.woragis.implementations.Students;

public class Main {
    private static int option = 0;
    private static final int SCHOOL_CAPACITY = 10;
    private static Students school = new Students("unipe", SCHOOL_CAPACITY);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        school.loadFromFile();

        loopPrincipal(scanner);

        scanner.close();
    }

    public static void loopPrincipal(Scanner scanner) {
        String input;
        String rgm;
        final int EXIT_OPTION = 5;
        while (option != 5) {
            limparTela();
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println(Messages.SHOWING_STUDENTS);
                    try {
                        school.view();
                    } catch (Exception e) {
                        System.out.println(Errors.SHOWING_STUDENTS_ERROR + ": " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(Messages.ADDING_STUDENTS);
                    Student newStudent = pegarEstudante(scanner);
                    try {
                        school.add(newStudent);
                    } catch (Exception e) {
                        System.out.println(Errors.ADDING_STUDENT_ERROR + ": " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(Messages.SEARCHING_STUDENTS);
                    rgm = pegarRgm(scanner);
                    try {
                        Student student = school.getStudent(rgm);
                        loopDeEstudante(scanner, student);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(Messages.DELETING_STUDENTS);
                    rgm = pegarRgm(scanner);
                    try {
                        school.remove(rgm);
                    } catch (Exception e) {
                        System.out.println(Errors.DELETE_STUDENT_ERROR + ": " + e.getMessage());
                    }
                    break;
                case EXIT_OPTION:
                    System.out.println(Messages.EXITING);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Errors.INVALID_CHAR_ERROR);
                    break;
            }
            mostrarOpcoesPrincipais();
            school.saveToFile();
            input = scanner.nextLine();
            option = Integer.parseInt(input);
        }

    }

    public static void mostrarOpcoesPrincipais() {
        System.out.println();
        System.out.println(Messages.MAIN_OPTION_1);
        System.out.println(Messages.MAIN_OPTION_2);
        System.out.println(Messages.MAIN_OPTION_3);
        System.out.println(Messages.MAIN_OPTION_4);
        System.out.println(Messages.MAIN_OPTION_5);
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public static Student pegarEstudante(Scanner scanner) {
        System.out.print(Messages.GET_STUDENT_NAME);
        String studentName = scanner.nextLine();

        System.out.print(Messages.GET_STUDENT_RGM);
        String studentRgm = scanner.nextLine();

        Student newStudent = new Student(studentName, studentRgm);

        return newStudent;
    }

    public static String pegarRgm(Scanner scanner) {
        System.out.print(Messages.GET_STUDENT_RGM);
        String rgm = scanner.nextLine();

        return rgm;
    }

    public static void menuDeDisciplina() {
        System.out.println();
        System.out.println(Messages.STUDENT_OPTION_0);
        System.out.println(Messages.STUDENT_OPTION_1);
        System.out.println(Messages.STUDENT_OPTION_2);
        System.out.println(Messages.STUDENT_OPTION_3);
        System.out.println(Messages.STUDENT_OPTION_4);
    }

    public static void loopDeEstudante(Scanner scanner, Student student) {
        String input;
        int option = 0;

        while (true) {
            switch (option) {
                case 0:
                    student.getCourses();
                    break;
                case 1:
                    System.out.println(Messages.STUDENT_COURSE_ADD);
                    Course newCourse = pegarDisciplian(scanner);
                    student.addCourse(newCourse);
                    break;
                case 2:
                    System.out.println(Messages.STUDENT_COURSE_REMOVE);
                    break;
                case 3:
                    System.out.println(Messages.STUDENT_DELETE);
                    try {
                        school.remove(student.getRgm());
                        return;
                    } catch (Exception e) {
                        System.out.println(Errors.DELETE_STUDENT_ERROR);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println(Errors.INVALID_CHAR_ERROR);
                    break;
            }
            menuDeDisciplina();
            input = scanner.nextLine();
            option = Integer.parseInt(input);
        }
    }

    public static Course pegarDisciplian(Scanner scanner) {
        System.out.print(Messages.GET_STUDENT_COURSE_NAME);
        String courseName = scanner.nextLine();

        System.out.print(Messages.GET_STUDENT_COURSE_TEACHER);
        String teacherName = scanner.nextLine();

        return new Course(courseName, teacherName);
    }
}