package edu.eric.ui.custom.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinishGameButton extends JButton {

    public FinishGameButton(ActionListener actionListener) {
        this.setText("Concluir jogo");
        this.addActionListener(actionListener);
    }
}
