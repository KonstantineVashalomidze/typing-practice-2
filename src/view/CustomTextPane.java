package view;

import controller.TypingPracticeControllerMediator;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class CustomTextPane
        extends JTextPane
        implements TypingPracticeComponent
{
    private StyledDocument styledDocument;
    private Style style;
    private TypingPracticeControllerMediator typingPracticeControllerMediator;

    public CustomTextPane(TypingPracticeControllerMediator typingPracticeControllerMediator)
    {
        this.typingPracticeControllerMediator = typingPracticeControllerMediator;
        styledDocument = getStyledDocument();
        style = styledDocument.addStyle(null, null);
        setFocusable(false);
        setEditable(false);
    }


    public void repaintCharAtIndex(int index, Color color)
    // repaint char at index with specified color
    {
        StyleConstants.setForeground(style, color);
        styledDocument.setCharacterAttributes(index, 1, style, true);
    } // end of repaintCharAtIndex()
}
