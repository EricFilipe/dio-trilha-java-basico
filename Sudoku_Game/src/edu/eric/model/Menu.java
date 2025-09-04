package edu.eric.model;

import edu.eric.service.InvalidNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void play(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sudoku box = new Sudoku();

        boolean valid = true;

        try {

            while (valid) {
                if (!box.isGameStarted()) {
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
                        box = new Sudoku();

                        box.setGameStarted(true);

                        for (int i = 0; i < args.length; i++) {
                            if (i % 3 == 0) {
                                box.addNumber(Integer.parseInt(args[i]), Integer.parseInt(args[i + 1]), args[i + 2]);
                            }
                        }

                    case 2:
                        if (!box.isGameStarted()) {
                            box.checkGameStatus();
                        } else {
                            boolean valid2 = true;

                            while (valid2) {

                                try {

                                    System.out.println("1 - COLOCAR NOVO NUMERO");
                                    System.out.println("2 - REMOVER NUMERO");
                                    System.out.println("3 - VERIFICAR JOGO");
                                    System.out.println("4 - LIMPAR");
                                    System.out.println("5 - FINALIZAR JOGO");
                                    System.out.println("6 - VOLTAR PARA O MENU INICIAL");

                                    box.show();

                                    int option2 = scanner.nextInt();
                                    switch (option2) {
                                        case 1:
                                            System.out.print("INFORME O ÍNDICE HORIZONTAL(COMEÇANDO PELO 0): ");
                                            int horizontalIndex = scanner.nextInt();
                                            System.out.print("INFORME O ÍNDICE VERTICAL(COMEÇANDO PELO 0): ");
                                            int verticalIndex = scanner.nextInt();
                                            System.out.print("INFORME O NÚMERO: ");
                                            String number = scanner.next();

                                            box.addNumber(horizontalIndex, verticalIndex, number);
                                            break;

                                        case 2:
                                            System.out.print("INFORME O ÍNDICE HORIZONTAL(COMEÇANDO PELO 0): ");
                                            horizontalIndex = scanner.nextInt();
                                            System.out.print("INFORME O ÍNDICE VERTICAL(COMEÇANDO PELO 0): ");
                                            verticalIndex = scanner.nextInt();
                                            box.removeNumber(horizontalIndex, verticalIndex, args);
                                            break;

                                        case 3:
                                            box.checkGame();
                                            break;

                                        case 4:
                                            box.clear(args);
                                            break;

                                        case 5:
                                            box.endGame();
                                            break;

                                        case 6:
                                            valid2 = false;
                                            break;

                                        default:
                                            System.out.println("OPÇÃO INVÁLIDA");
                                    }

                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("ÍNDICE INVÁLIDO");
                                } catch (InvalidNumberException e) {
                                    System.out.println("NÚMERO DEVE SER DE 1 A 9");
                                }
                            }
                        }
                        break;

                    case 3:
                        if (!box.isGameStarted()) {
                            valid = false;
                        } else {
                            box.checkGameStatus();
                        }
                        break;

                    case 4:
                        if (box.isGameStarted()) {
                            valid = false;
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
}
