package edu.eric.model;

import edu.eric.util.BorderTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sudoku {
    private List<List<Integer>> border;

    public Sudoku() {
        this.border = new ArrayList<>();

        for(int i = 0; i < 9; i ++) {
            Spaces spaces = new Spaces();
            border.add(spaces.getSpaces());
        }
    }

    public void startGameOrClearGame(String[] args) {
        Sudoku newBorder = new Sudoku();
        int argsPosition = 0;
        for(int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for(int j = 0; j < 9; j++) {
                if(args[argsPosition].equals("empty")) {
                    newBorder.border.get(rowIndex).add(null);
                    argsPosition++;
                } else {
                    newBorder.border.get(rowIndex).add(Integer.parseInt(args[argsPosition++]));
                }
            }
        }
        this.border = newBorder.border;
    }

    public void addNumber(int horizontalIndex, int verticalIndex, int number) {
        if(border.get(horizontalIndex).get(verticalIndex) == null) {
            border.get(horizontalIndex).set(verticalIndex, number);
        } else {
            System.out.println("ESPACO JA OCUPADO!");
        }
    }

    public void removeNumber(int horizontalIndex, int verticlIndex, String[] args) {
        if(isFixedNumber(args, horizontalIndex, verticlIndex)) {
            System.out.println("NUMERO FIXO NAO PODE SER REMOVIDO");
        } else {
            border.get(horizontalIndex).set(verticlIndex, null);
        }
    }

    public boolean isFixedNumber(String[] args, int horizontalIndex, int verticalIndex) {
        boolean isFixed = false;
        switch (horizontalIndex) {
            case 0:
                if(!args[verticalIndex].equals("empty")) { isFixed = true; } break;
            case 1:
                if(!args[9 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 2:
                if(!args[18 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 3:
                if(!args[27 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 4:
                if(!args[36 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 5:
                if(!args[45 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 6:
                if(!args[54 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 7:
                if(!args[63 + verticalIndex].equals("empty")) { isFixed = true; } break;
            case 8:
                if(!args[72 + verticalIndex].equals("empty")) { isFixed = true; } break;
        }

        return isFixed;
    }

    public void showCurrentGame() {
        String[] currentGame = new String[81];
        int cG_Position = 0;
        for(int row =0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                currentGame[cG_Position ++] = border.get(row).get(col) == null ? " " : String.valueOf(border.get(row).get(col));
            }
        }
        System.out.println(BorderTemplate.borderTemplate.formatted(currentGame));
    }

    private boolean checkForRepeatedNumbers() {
        boolean repeatedNumbers = false;
        for(List<Integer> row : border) {
            List<Integer> onlyNumbers = row.stream().filter(Objects::nonNull).toList();
            List<Integer> distinctNumbers = onlyNumbers.stream().distinct().toList();
            if(distinctNumbers.size() < onlyNumbers.size()) {
                repeatedNumbers = true;
                break;
            }
        }

        for(int vIndex = 0; vIndex < 9; vIndex++) {
            List<Integer> onlyNumbers = new ArrayList<>();

            for(int hIndex = 0; hIndex < 9; hIndex++) {
                if(border.get(hIndex).get(vIndex) != null) {
                    onlyNumbers.add(border.get(hIndex).get(vIndex));
                }
            }

            List<Integer> distinctNumbers = onlyNumbers.stream().distinct().toList();

            if(distinctNumbers.size() < onlyNumbers.size()) {
                repeatedNumbers = true;
                break;
            }
        }

        return repeatedNumbers;
    }

    public void checkGameStatus() {
        if(border.getFirst().isEmpty()) {
            System.out.println("JOGO NAO INICIADO");
        } else {
            for(List<Integer> row : border) {
                if(!row.contains(null)) {
                    if(row == border.getLast()) {
                        System.out.println("JOGO COMPLETO" + (checkForRepeatedNumbers() ? " MAS CONTEM NUMEROS CONFLITANTES" : ""));
                    }
                } else {
                    System.out.println("JOGO IMCOMPLETO" + (checkForRepeatedNumbers() ? " E CONTEM NUMEROS CONFLITANTES" : ""));
                    break;
                }
            }
        }
    }

    public void endGame() {
        for(List<Integer> row : border) {
            if(!row.contains(null) && !checkForRepeatedNumbers()) {
                if(row == border.getLast()) {
                    System.out.println("PARABENS, VOCE FINALIZOU O JOGO COM SUCESSO!!");
                }
            } else {
                System.out.println("PREENCHA TODOS OS ESPACOS COM SEUS RESPECTIVOS NUMEROS");
                break;
            }
        }
    }

    public List<List<Integer>> getBorder() {
        return border;
    }
}
