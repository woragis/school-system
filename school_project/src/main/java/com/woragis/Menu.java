package com.woragis;

import java.util.Scanner;

public class Menu {
    private static int option = 0;

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

    public static void mainloop() {
        Scanner scanner = new Scanner(System.in);
        String input;
        final int EXIT_OPTION = 5;
        while (option != 5) {
            clearScreen();
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("Mostrando alunos...");
                    break;
                case 2:
                    System.out.println("Adicionando aluno...");
                    break;
                case 3:
                    System.out.println("Pesquisando aluno...");
                    break;
                case 4:
                    System.out.println("Deletando aluno...");
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
}
