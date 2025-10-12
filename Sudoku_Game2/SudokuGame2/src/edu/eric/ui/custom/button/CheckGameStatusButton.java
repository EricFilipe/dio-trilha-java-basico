package edu.eric.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckGameStatusButton extends JButton {

    public CheckGameStatusButton(ActionListener actionListener) {
        this.setText("Status do jogo");
        this.addActionListener(actionListener);
    }
}
