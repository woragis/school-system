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
                    System.out.println(Messages.MOSTRANDO_ESTUDANTES);
                    try {
                        school.view();
                    } catch (Exception e) {
                        System.out.println(Errors.MOSTRANDO_ESTUDANTES_ERRO + ": " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(Messages.ADICIONANDO_ESTUDANTE);
                    Student newStudent = pegarEstudante(scanner);
                    try {
                        school.add(newStudent);
                    } catch (Exception e) {
                        System.out.println(Errors.ADICIONANDO_ESTUDANTE_ERRO + ": " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(Messages.PESQUISANDO_ESTUDANTE);
                    rgm = pegarRgm(scanner);
                    try {
                        Student student = school.getStudent(rgm);
                        loopDeEstudante(scanner, student);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(Messages.DELETANDO_ESTUDANTE);
                    rgm = pegarRgm(scanner);
                    try {
                        school.remove(rgm);
                    } catch (Exception e) {
                        System.out.println(Errors.DELETANDO_ESTUDANTE_ERRO + ": " + e.getMessage());
                    }
                    break;
                case EXIT_OPTION:
                    System.out.println(Messages.SAINDO);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Errors.CARACTERE_INVALIDO_ERRO);
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
        System.out.println(Messages.OPCAO_MENU_1);
        System.out.println(Messages.OPCAO_MENU_2);
        System.out.println(Messages.OPCAO_MENU_3);
        System.out.println(Messages.OPCAO_MENU_4);
        System.out.println(Messages.OPCAO_MENU_5);
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public static Student pegarEstudante(Scanner scanner) {
        System.out.print(Messages.DIGITE_NOME_ALUNO);
        String studentName = scanner.nextLine();

        System.out.print(Messages.DIGITE_RGM_ALUNO);
        String studentRgm = scanner.nextLine();

        Student newStudent = new Student(studentName, studentRgm);

        return newStudent;
    }

    public static String pegarRgm(Scanner scanner) {
        System.out.print(Messages.DIGITE_RGM_ALUNO);
        String rgm = scanner.nextLine();

        return rgm;
    }

    public static void menuDeDisciplina() {
        System.out.println();
        System.out.println(Messages.OPCAO_ALUNO_0);
        System.out.println(Messages.OPCAO_ALUNO_1);
        System.out.println(Messages.OPCAO_ALUNO_2);
        System.out.println(Messages.OPCAO_ALUNO_3);
        System.out.println(Messages.OPCAO_ALUNO_4);
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
                    System.out.println(Messages.ADICIONANDO_DISCIPLINA);
                    Course newCourse = pegarDisciplian(scanner);
                    student.addCourse(newCourse);
                    break;
                case 2:
                    System.out.println(Messages.REMOVENDO_DISCIPLINA);
                    break;
                case 3:
                    System.out.println(Messages.DELETANDO_ESTUDANTE_LOOP);
                    try {
                        school.remove(student.getRgm());
                        return;
                    } catch (Exception e) {
                        System.out.println(Errors.DELETANDO_ESTUDANTE_ERRO);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println(Errors.CARACTERE_INVALIDO_ERRO);
                    break;
            }
            menuDeDisciplina();
            input = scanner.nextLine();
            option = Integer.parseInt(input);
        }
    }

    public static Course pegarDisciplian(Scanner scanner) {
        System.out.print(Messages.DIGITE_NOME_DISCIPLINA);
        String courseName = scanner.nextLine();

        System.out.print(Messages.DIGITE_PROFESSOR_DISCIPLINA);
        String teacherName = scanner.nextLine();

        return new Course(courseName, teacherName);
    }
}