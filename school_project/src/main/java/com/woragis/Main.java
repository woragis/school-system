package com.woragis;

import java.util.Scanner;

public class Main {
    private static int option = 0;
    private static final int SCHOOL_CAPACITY = 10;
    private static Students school = new Students(SCHOOL_CAPACITY);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Mostrando alunos...");
                    try {
                        school.view();
                    } catch (Exception e) {
                        System.out.println("Erro ao tentar visualizar escola: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Adicionando aluno...");
                    Student newStudent = getStudent(scanner);
                    try {
                        school.add(newStudent);
                    } catch (Exception e) {
                        System.out.println("Erro ao tentar adicionar aluno: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Pesquisando aluno...");
                    rgm = getRgm(scanner);
                    school.getStudent(rgm);
                    break;
                case 4:
                    System.out.println("Deletando aluno...");
                    rgm = getRgm(scanner);
                    try {
                        school.remove(rgm);
                    } catch (Exception e) {
                        System.out.println("Erro ao tentar deletar aluno: " + e.getMessage());
                    }
                    break;
                case EXIT_OPTION:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Voce digitou um caractere invalido");
                    break;
            }
            showOptions();
            input = scanner.nextLine();
            option = Integer.parseInt(input);
        }

    }

    public static void showOptions() {
        System.out.println("\n");
        System.out.println("[0]-Mostrar opcoes");
        System.out.println("[1]-Mostrar alunos");
        System.out.println("[2]-Adicionar aluno");
        System.out.println("[3]-Pesquisar aluno");
        System.out.println("[4]-Deletar aluno");
        System.out.println("[5]-Sair");
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public static Student getStudent(Scanner scanner) {
        System.out.print("Nome do aluno: ");
        String studentName = scanner.nextLine();

        System.out.print("Rgm do aluno: ");
        String studentRgm = scanner.nextLine();

        Student newStudent = new Student(studentName, studentRgm);

        return newStudent;
    }

    public static String getRgm(Scanner scanner) {
        System.out.print("Qual o RGM do aluno: ");
        String rgm = scanner.nextLine();

        return rgm;
    }
}