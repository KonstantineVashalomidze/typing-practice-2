package view;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class CustomTextPane
        extends JTextPane
{
    private StyledDocument styledDocument;
    private Style style;

    public CustomTextPane()
    {
        styledDocument = getStyledDocument();
        style = styledDocument.addStyle(null, null);
    }


    public void clearPaint(int index)
    // recolor everything as black after index
    {
        StyleConstants.setForeground(style, Color.BLACK);
        styledDocument.setCharacterAttributes(index + 1, super.getText().length() - index - 1, style, true);
    } // end of clearPaint()

    public void repaintCharAtIndex(int index, Color color)
    // repaint char at index with specified color
    {
        StyleConstants.setForeground(style, color);
        styledDocument.setCharacterAttributes(index, 1, style, true);
    } // end of repaintCharAtIndex()
}
