package edu.eric.ui.custom.panel;

import edu.eric.service.EventEnum;
import edu.eric.service.EventListener;
import edu.eric.ui.custom.input.NumberTextLimit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SudokuSector extends JPanel implements EventListener {

    private static List<JTextPane> spaces;

    public SudokuSector(String[] args) {
        Dimension dimension = new Dimension(500, 500);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setBorder(new LineBorder(Color.black, 2, true));
        this.setVisible(true);

        spaces = new ArrayList<>();

        createTextArea(args, spaces);

        spaces.forEach(this::add);
    }

    private void createTextArea(String[] args, List<JTextPane> areas) {
        for (int i = 0; i < args.length; i++) {
            JTextPane textArea = getJTextPane(args, i);
            areas.add(textArea);

            StyledDocument doc = textArea.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        }
    }

    private static JTextPane getJTextPane(String[] args, int i) {
        JTextPane textArea = new JTextPane();

        Dimension textAreaDimension = new Dimension(50, 50);
        textArea.setPreferredSize(textAreaDimension);
        //textArea.setBorder(new LineBorder(Color.black, 2, true));
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new NumberTextLimit());
        textArea.setVisible(true);
        textArea.setEditable(args[i].equals("empty"));
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setText(args[i].equals("empty") ? "" : args[i]);

        return textArea;
    }

    public static List<JTextPane> getSpaces() {
        return spaces;
    }

    @Override
    public void update(EventEnum eventType) {
        if(eventType.equals(EventEnum.CLEAR_SPACE)) {
            spaces.stream().filter(JTextComponent::isEditable).forEach(s -> s.setText(""));
        }
    }
}
