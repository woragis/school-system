package com.woragis;

import java.util.Scanner;

public class Menu {
    private static int option = 0;

    public static void mainloop() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (option != 5) {
            input = scanner.nextLine();
            option = Integer.parseInt(input);
            switch (option) {
                case 0:
                    System.out.println("Mostrar opcoes");
                    break;
                case 1:
                    System.out.println("Mostrar escolas");
                    break;
                case 2:
                    System.out.println("Criar escola");
                    break;
                case 3:
                    System.out.println("Mostrar alunos da escola");
                    break;
                case 4:
                    System.out.println("Adicionar aluno na escola");
                    break;
                case 5:
                    System.out.println("Remover aluno da escola");
                    break;
                case 6:
                    System.out.println("Adicionar disciplina no aluno");
                    break;
                case 7:
                    System.out.println("Mostrar disciplina do aluno");
                    break;
                case 8:
                    System.out.println("Remover disciplina do aluno");
                    break;
                case 9:
                default:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }

    }
}
