package edu.eric.ui.custom.input;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberTextLimit extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if(text.matches("[1-9]") && fb.getDocument().getLength() + text.length() <= 1) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
