package edu.eric.model;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private Sudoku border = new Sudoku();

    public void play(String[] args) {
        try {

            while (true) {
                if (!border.isGameStarted()) {
                    System.out.println("VAMOS JOGAR!!");
                    System.out.println("1 -  INICIAR NOVO JOGO");
                    System.out.println("2 -  VERIFICAR STATUS DO JOGO");
                    System.out.println("3 -  SAIR");
                } else {
                    System.out.println("VAMOS JOGAR!!");
                    System.out.println("1 -  INICIAR NOVO JOGO");
                    System.out.println("2 -  CONTINUAR");
                    System.out.println("3 -  VERIFICAR STATUS DO JOGO");
                    System.out.println("4 -  SAIR");
                }

                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        startNewGame(args);

                    case 2:
                        if (!border.isGameStarted()) {
                            border.checkGameStatus();
                        } else {
                            boolean valid = true;

                            while (valid) {

                                System.out.println("1 - COLOCAR NOVO NUMERO");
                                System.out.println("2 - REMOVER NUMERO");
                                System.out.println("3 - VERIFICAR JOGO");
                                System.out.println("4 - LIMPAR");
                                System.out.println("5 - FINALIZAR JOGO");
                                System.out.println("6 - VOLTAR PARA O MENU INICIAL");

                                border.show();

                                int option2 = scanner.nextInt();
                                switch (option2) {
                                    case 1:
                                        inputNumber();
                                        break;

                                    case 2:
                                        deleteNumber(args);
                                        break;

                                    case 3:
                                        border.checkGame();
                                        break;

                                    case 4:
                                        border.clear(args);
                                        break;

                                    case 5:
                                        border.endGame();
                                        break;

                                    case 6:
                                        valid = false;
                                        break;

                                    default:
                                        System.out.println("OPÇÃO INVÁLIDA");
                                }
                            }
                        }
                        break;

                    case 3:
                        if (!border.isGameStarted()) {
                            System.exit(0);
                        } else {
                            border.checkGameStatus();
                        }
                        break;

                    case 4:
                        if (border.isGameStarted()) {
                            System.exit(0);
                        } else {
                            System.out.println("OPÇÃO INVÁLIDA");
                        }
                        break;

                    default:
                        System.out.println("OPÇÃO INVÁLIDA");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("OPÇÃO INVÁLIDA");
        }
    }

    private void startNewGame(String[] args) {
        border = new Sudoku();

        border.setGameStarted(true);

        for (int i = 0; i < args.length; i++) {
            if (i % 3 == 0) {
                border.addNumber(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]), args[i + 2]);
            }
        }
    }

    private void inputNumber() {
        System.out.print("INFORME O ÍNDICE HORIZONTAL: ");
        int horizontalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O ÍNDICE VERTICAL: ");
        int verticalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O NÚMERO: ");
        String number = String.valueOf(runUntilGetValidNumber());

        border.addNumber(horizontalIndex, verticalIndex, number);
    }

    private void deleteNumber(String[] args) {
        System.out.print("INFORME O ÍNDICE HORIZONTAL: ");
        int horizontalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O ÍNDICE VERTICAL: ");
        int verticalIndex = runUntilGetValidNumber();

        border.removeNumber(horizontalIndex, verticalIndex, args);
    }

    private int runUntilGetValidNumber() {
        int numberInformed = scanner.nextInt();
        while (numberInformed < 1 || numberInformed > 9) {
            System.out.println("INFORME UM NUMERO ENTRE 1 E 9");
            numberInformed = scanner.nextInt();
        }

        return numberInformed;
    }
}
