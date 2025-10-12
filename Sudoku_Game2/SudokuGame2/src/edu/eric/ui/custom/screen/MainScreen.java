package edu.eric.ui.custom.screen;

import edu.eric.model.Sudoku;
import edu.eric.service.EventEnum;
import edu.eric.service.EventListener;
import edu.eric.service.NotifierService;
import edu.eric.ui.custom.button.CheckGameStatusButton;
import edu.eric.ui.custom.button.FinishGameButton;
import edu.eric.ui.custom.button.ResetButton;
import edu.eric.ui.custom.frame.MainFrame;
import edu.eric.ui.custom.panel.MainPanel;
import edu.eric.ui.custom.panel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainScreen {

    private Dimension dimension = new Dimension(600,600);

    private Sudoku board;
    private NotifierService notifierService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;

    public MainScreen(String[] args) {
        this.board = new Sudoku();
        board.startGameOrClearGame(args);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen(String[] args) {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);

        mainPanel.add(generateSection(args));
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        addResetButton(args, mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private JPanel generateSection(String[] args) {
        EventListener SudokuSector = new SudokuSector(args);
        notifierService.subscribe(EventEnum.CLEAR_SPACE, SudokuSector);
        return new SudokuSector(args);
    }

    private void addFinishGameButton(JPanel mainPanel) {
        finishGameButton = new FinishGameButton(e -> {
            updateBoardGame();

            if(board.endGame()) {
                JOptionPane.showMessageDialog(null, "PARABENS, VOCE FINALIZOU O JOGO COM SUCESSO!!");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "SEU JOGO TEM INCONSISTENCIAS");
            }
        });

        mainPanel.add(finishGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new CheckGameStatusButton(e -> {
            updateBoardGame();
            String message = null;

            if(board.getBoard().getFirst().isEmpty()) {
                message = "JOGO NAO INICIADO";
            } else {
                for(List<Integer> row : board.getBoard()) {
                    if(!row.contains(null)) {
                        if(row == board.getBoard().getLast()) {
                            message = "JOGO COMPLETO" + (board.checkForRepeatedNumbers() ? " MAS CONTEM NUMEROS CONFLITANTES" : "");
                        }
                    } else {
                        message = "JOGO IMCOMPLETO" + (board.checkForRepeatedNumbers() ? " E CONTEM NUMEROS CONFLITANTES" : "");
                        break;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, message);
        });

        mainPanel.add(checkGameStatusButton);
    }

    private void addResetButton(String[] args, JPanel mainPanel) {
        resetButton = new ResetButton(e -> {
           int dialogResult = JOptionPane.showConfirmDialog(
                   null,
                   "Deseja realmente reiniciar o jogo?",
                   "Limpar o jogo",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE
           );

           if(dialogResult == 0) {
               board.startGameOrClearGame(args);
               notifierService.notify(EventEnum.CLEAR_SPACE);
           }
        });

        mainPanel.add(resetButton);
    }

    private void updateBoardGame() {
        Sudoku newBoard = new Sudoku();
        int spacePosition = 0;
        for(int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for(int j = 0; j < 9; j++) {
                if(SudokuSector.getSpaces().get(spacePosition).getText().isEmpty()) {
                    newBoard.getBoard().get(rowIndex).add(null);
                    spacePosition++;
                } else {
                    int number = Integer.parseInt(String.valueOf(SudokuSector.getSpaces().get(spacePosition++).getText()));
                    newBoard.getBoard().get(rowIndex).add(number);
                }
            }
        }
        this.board = newBoard;
    }
}
