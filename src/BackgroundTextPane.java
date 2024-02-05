import javax.swing.*;
import java.awt.*;

public class BackgroundTextPane extends JTextPane {

    private String backgroundText;

    public BackgroundTextPane(String backgroundText) {
        this.backgroundText = backgroundText;
        setText(backgroundText); // Set initial background text

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);




    }

    public String getBackgroundText() {
        return backgroundText;
    }

    public void setBackgroundText(String backgroundText) {
        this.backgroundText = backgroundText;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("BackgroundTextPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            BackgroundTextPane textPane = new BackgroundTextPane("Type here...");
            JScrollPane scrollPane = new JScrollPane(textPane);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
