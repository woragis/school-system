package com.woragis;

import java.util.Scanner;

import com.woragis.constants.Errors;
import com.woragis.constants.Messages;

public class Main {
    private static int option = 0;
    private static final int SCHOOL_CAPACITY = 10;
    private static Students school = new Students("unipe", SCHOOL_CAPACITY);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        school.loadFromFile();

        mainloop(scanner);

        scanner.close();
    }

    public static void mainloop(Scanner scanner) {
        String input;
        String rgm;
        final int EXIT_OPTION = 5;
        while (option != 5) {
            clearScreen();
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
                    Student newStudent = getStudent(scanner);
                    try {
                        school.add(newStudent);
                    } catch (Exception e) {
                        System.out.println(Errors.ADDING_STUDENT_ERROR + ": " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(Messages.SEARCHING_STUDENTS);
                    rgm = getRgm(scanner);
                    school.getStudent(rgm);
                    break;
                case 4:
                    System.out.println(Messages.DELETING_STUDENTS);
                    rgm = getRgm(scanner);
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
            showOptions();
            school.saveToFile();
            input = scanner.nextLine();
            option = Integer.parseInt(input);
        }

    }

    public static void showOptions() {
        System.out.println(Messages.MAIN_OPTION_1);
        System.out.println(Messages.MAIN_OPTION_2);
        System.out.println(Messages.MAIN_OPTION_3);
        System.out.println(Messages.MAIN_OPTION_4);
        System.out.println(Messages.MAIN_OPTION_5);
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public static Student getStudent(Scanner scanner) {
        System.out.print(Messages.GET_STUDENT_NAME);
        String studentName = scanner.nextLine();

        System.out.print(Messages.GET_STUDENT_RGM);
        String studentRgm = scanner.nextLine();

        Student newStudent = new Student(studentName, studentRgm);

        return newStudent;
    }

    public static String getRgm(Scanner scanner) {
        System.out.print(Messages.GET_STUDENT_RGM);
        String rgm = scanner.nextLine();

        return rgm;
    }

    public static void studentMainloop(Scanner scanner, Student student) {
        System.out.println(Messages.STUDENT_OPTION_1);
    }

    public static void getCourse(Scanner scanner) {
        System.out.println();
    }
}