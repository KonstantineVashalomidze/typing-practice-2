package view;

import javax.swing.*;
import java.awt.*;

public class TypingPracticeView
    extends JPanel
{
    private JProgressBar progressBar;
    private JTextPane readingTextBar;
    private JPanel typingTextBar;
    private JPanel timer;
    private JPanel wpm;
    private JPanel accuracy;

    private JButton mainMenuButton;

    public TypingPracticeView()
    {
        mainMenuButton = new JButton("Main Menu");
        progressBar = new JProgressBar();
        readingTextBar = new CustomTextPane();
        readingTextBar.setFocusable(false);
        readingTextBar.setEditable(false);
        typingTextBar = new JPanel();
        typingTextBar.setBackground(Color.GREEN);
        timer = new JPanel();
        timer.setBackground(Color.RED);
        wpm = new JPanel();
        wpm.setBackground(Color.pink);
        accuracy = new JPanel();
        accuracy.setBackground(Color.ORANGE);

        setLayout(new BorderLayout());  // set border layout

        add(createMainPanel(), BorderLayout.CENTER); // add main panel






    } // end of TypingPracticeView()


    public JPanel createMainPanel()
    // creates JPanel containing, progress bar, reading and typing panels together
    {

        // creating main panel
        var mainPanel = new JPanel(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // fill everything in both directions
        gbc.ipadx = 700; // give minimum width 500
        gbc.insets = new Insets(10, 0, 0, 0); // set gap to top
        // row 0 col 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5; // height 5
        mainPanel.add(progressBar, gbc); // add progress bar
        // row 1 col 0
        gbc.gridy = 1;
        gbc.ipady = 200; // height 70
        mainPanel.add(readingTextBar, gbc); // add reading text bar
        // row 2 col 0
        gbc.gridy = 2;
        gbc.ipady = 25; // height 25
        mainPanel.add(typingTextBar, gbc); // add typing text bar

        // creating stats display panel, holding timer, wpm, accuracy
        var currentStatsDisplayPanel = new JPanel(new GridBagLayout());
        currentStatsDisplayPanel.setBackground(Color.cyan);

        gbc.ipadx = 100; // give minimum width 100

        // row 0 col 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 20; // height 33
        gbc.insets.top = 20; // set little gap between stats
        gbc.insets.bottom = 20;
        currentStatsDisplayPanel.add(wpm, gbc); // add wpm

        // row 1 col 0
        gbc.gridy = 1;
        currentStatsDisplayPanel.add(accuracy, gbc); // add accuracy

        // row 2 col 0
        gbc.gridy = 2;
        currentStatsDisplayPanel.add(timer, gbc); // add timer

        gbc.gridy = 3;
        currentStatsDisplayPanel.add(mainMenuButton, gbc); // add main menu button

        // row 0 col 1
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 3; // grid width is 3
        gbc.insets.left = 10; // add gap left side 10
        gbc.insets.top = 10;  // reset gaps needed for stats
        gbc.insets.bottom = 0;
        gbc.ipadx = 50;
        // add current stats display panel to the main panel
        mainPanel.add(currentStatsDisplayPanel, gbc);

        return mainPanel;

    } // end of createMainPanel()


    public JButton getMainMenuButton()
    {
        return mainMenuButton;
    }


    public JTextPane getReadingTextBar()
    {
        return readingTextBar;
    }
}

