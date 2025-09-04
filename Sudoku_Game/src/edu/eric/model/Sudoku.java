package edu.eric.model;

import edu.eric.service.InvalidNumberException;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    private List<List<String>> surroundingSpace;
    private boolean gameStarted;

    public Sudoku() {
        this.surroundingSpace = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            Space rows = new Space();
            surroundingSpace.add(rows.getSpaces());
        }
    }

    public void addNumber(int horizontalIndex, int verticalIndex, String number) throws InvalidNumberException {
        if(checkSpaceOccupied(horizontalIndex, verticalIndex)) {
            System.out.println("ESPAÇO JÁ OCUPADO");
        } else if (Integer.parseInt(number) <= 0 || Integer.parseInt(number) > 9) {
            throw new InvalidNumberException();
        } else {
            for (int i = 0; i < 9; i++) {
                if (i == horizontalIndex) {
                    surroundingSpace.get(i).set(verticalIndex, number);
                }
            }
        }
    }

    public void removeNumber(int horizontalIndex, int verticalIndex, String[] args) {
        if(checkFixedNumber(horizontalIndex, verticalIndex, args)) {
            System.out.println("NÚMERO FIXO NÃO PODE SER REMOVIDO");
        } else {
            surroundingSpace.get(horizontalIndex).set(verticalIndex, " ");
        }
    }

    private boolean checkSpaceOccupied(int horizontalIndex, int verticalIndex) {
        Space space = new Space();
        if(surroundingSpace.get(horizontalIndex).get(verticalIndex).equals(" ")) {
            space.setOccupied(false);
        } else {
            space.setOccupied(true);
        }

        return space.isOccupied();
    }

    public void clear(String[] args) {
        for(int hIndex = 0; hIndex < 9; hIndex++) {
            for(int vIndex = 0; vIndex < 9; vIndex++) {
                if(!checkFixedNumber(hIndex, vIndex, args)) {
                    removeNumber(hIndex, vIndex, args);
                }
            }
        }
    }

    public void checkGameStatus() {
        if(!isGameStarted()) {
            System.out.println("JOGO NÃO INICIADO");
        } else {
            for(int hIndex = 0; hIndex < 9; hIndex++) {
                if(surroundingSpace.get(hIndex).stream().anyMatch(space -> space.equals(" "))) {
                    System.out.println("JOGO IMCOMPLETO");
                    break;
                } else if (hIndex == 8 && surroundingSpace.get(hIndex).stream().noneMatch(space -> space.equals(" "))){
                    System.out.println("JOGO COMPLETO");
                }

            }

            if(checkRepeatedNumbersInRows() || checkRepeatedNumbersInColumns()) {
                System.out.println("NÚMERO(S) EM POSIÇÃO(ÕES) CONFLITANTE(S)");
            }
        }
    }

    public void checkGame() {
        if(!checkRepeatedNumbersInRows() && !checkRepeatedNumbersInColumns()) {
            System.out.println("NENHUM NÚMERO CONFLITANTE, VOCÊ ESTA INDO BEM!");
        } else {
            System.out.println("NÚMERO(S) EM POSIÇÃO(ÕES) CONFLITANTE(S)");
        }
    }

    private boolean checkRepeatedNumbersInRows() {
        boolean repeatedNumbers = false;

        for(List<String> row : surroundingSpace) {
            List<String> rowNumbers = row.stream().filter(space -> !space.equals(" ")).toList();
            List<String> distinctRowNumbers = rowNumbers.stream().distinct().toList();

            if (distinctRowNumbers.size() < rowNumbers.size()) {
                repeatedNumbers = true;
            }
        }

        return repeatedNumbers;
    }

    private boolean checkRepeatedNumbersInColumns() {
        boolean repeatedNumbers = false;

        for(int i = 0; i < 9; i++) {
            List<String> columnNumbers = new ArrayList<>();

            for(int j = 0; j < 9; j++) {
                if(!checkSpaceOccupied(j, i)) {
                    continue;
                }
                columnNumbers.add(surroundingSpace.get(j).get(i));

            }

            List<String> distinctColumnNumbers = columnNumbers.stream().distinct().toList();

            if(distinctColumnNumbers.size() < columnNumbers.size()) {
                repeatedNumbers = true;
            }
        }

        return repeatedNumbers;
    }

    private boolean checkFixedNumber(int horizontalIndex, int verticalIndex, String[] args) {
        boolean fixedNumber = false;
        for(int index = 0; index < args.length; index++) {
            if(index % 3 == 0) {
                if(horizontalIndex == Integer.parseInt(args[index]) && verticalIndex == Integer.parseInt(args[index + 1])) {
                    fixedNumber = true;
                }
            }
        }

        return fixedNumber;
    }

    public void endGame() {
        for(int hIndex = 0; hIndex < 9; hIndex++) {
            if(surroundingSpace.get(hIndex).stream().anyMatch(space -> space.equals(" "))) {
                System.out.println("PREENCHA TODOS OS ESPAÇOS COM SEUS REPECTIVOS NÚMEROS");
                break;
            } else if (hIndex == 8){
                if(!checkRepeatedNumbersInRows() && !checkRepeatedNumbersInColumns()) {
                    System.out.println("PARABÉNS, JOGO FINALIZADO!");
                } else {
                    System.out.println("NÚMERO(S) EM POSIÇÃO(ÕES) CONFLITANTE(S). PREENCHA TODOS OS ESPAÇOS COM SEUS REPECTIVOS NÚMEROS");
                }
            }

        }
    }

    public void show() {
        surroundingSpace.forEach(System.out::println);
    }

    public List<List<String>> getSurroundingSpace() {
        return surroundingSpace;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}
