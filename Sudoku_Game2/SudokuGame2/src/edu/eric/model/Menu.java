package edu.eric.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Sudoku board = new Sudoku();

    public void play(String[] args) {
        try {
            while (true) {
                boolean isGameStarted = board.getBoard().getFirst().isEmpty();
                if (isGameStarted) {
                    System.out.println("VAMOS JOGAR!!");
                    System.out.println("1 -  INICIAR NOVO JOGO");
                    System.out.println("2 -  VERIFICAR STATUS DO JOGO");
                    System.out.println("3 -  SAIR");
                } else {
                    System.out.println("VAMOS JOGAR!!");
                    System.out.println("1 - COLOCAR NOVO NUMERO");
                    System.out.println("2 - REMOVER NUMERO");
                    System.out.println("3 - VERIFICAR STATUS DO JOGO");
                    System.out.println("4 - LIMPAR");
                    System.out.println("5 - FINALIZAR JOGO");
                    System.out.println("6 - SAIR");
                }

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        if (isGameStarted) {
                            board.startGameOrClearGame(args);

                            System.out.println("NOVO JOGO INICIADO");

                            board.showCurrentGame();
                        } else {
                            inputNumber();
                            board.showCurrentGame();
                        }
                        break;
                    case 2:
                        if (isGameStarted) {
                            board.checkGameStatus();
                        } else {
                            deleteNumber(args);
                            board.showCurrentGame();
                        }
                        break;

                    case 3:
                        if (isGameStarted) {
                            System.exit(0);
                        } else {
                            board.checkGameStatus();
                            break;
                        }

                    case 4:
                        if (!isGameStarted) {
                            board.startGameOrClearGame(args);
                            board.showCurrentGame();
                        } else {
                            System.out.println("OPCAO INVALIDA");
                        }
                        break;

                    case 5:
                        if (!isGameStarted) {
                            board.endGame();
                        } else {
                            System.out.println("OPCAO INVALIDA");
                        }
                        break;

                    case 6:
                        if (!isGameStarted) {
                            System.exit(0);
                        }

                    default:
                        System.out.println("OPCAO INVALIDA");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("OPCAO INVALIDA");
        }
    }

    private void inputNumber() {
        System.out.print("INFORME O ÍNDICE HORIZONTAL: ");
        int horizontalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O ÍNDICE VERTICAL: ");
        int verticalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O NÚMERO: ");
        int number = runUntilGetValidNumber();

        board.addNumber(horizontalIndex - 1, verticalIndex - 1, number);
    }

    private void deleteNumber(String[] args) {
        System.out.print("INFORME O ÍNDICE HORIZONTAL: ");
        int horizontalIndex = runUntilGetValidNumber();

        System.out.print("INFORME O ÍNDICE VERTICAL: ");
        int verticalIndex = runUntilGetValidNumber();

        board.removeNumber(horizontalIndex - 1, verticalIndex - 1, args);
    }

    private int runUntilGetValidNumber() {
        int numberInformed = scanner.nextInt();
        while (numberInformed < 1 || numberInformed > 9) {
            System.out.println("INFORME UM NUMERO DE 1 A 9");
            numberInformed = scanner.nextInt();
        }

        return numberInformed;
    }
}
