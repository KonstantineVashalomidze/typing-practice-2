package view;

import javax.swing.*;
import java.awt.*;

public class ResultsStatsView
    extends JPanel
{



    private JPanel wpmPanel;
    private JPanel timePanel;
    private JPanel accuracyPanel;

    private JButton playAgainButton;




    public ResultsStatsView()
    {
        setLayout(new BorderLayout());
        var mainPanel = new JPanel(new GridBagLayout()); // panel to add 3 minor panels and this will then be added to this panel
        var gbc = new GridBagConstraints();


        wpmPanel = new JPanel();
        wpmPanel.setBackground(Color.cyan);
        timePanel = new JPanel();
        timePanel.setBackground(Color.ORANGE);
        accuracyPanel = new JPanel();
        accuracyPanel.setBackground(Color.pink);
        playAgainButton = new JButton("Play Again");

        var resultPanel = createResultPanel(); // result panel where wpm accuracy and time will be displayed for session

        // add minor panels to mainPanel
        gbc.insets = new Insets(30, 0, 0, 0); // gap at top of the components


        // row 1 col 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(playAgainButton, gbc);

        gbc.fill = GridBagConstraints.BOTH; // expand everything that gird contains
        gbc.ipadx = 800;


        // row 2 col 1
        gbc.gridy = 1;
        mainPanel.add(resultPanel, gbc);

//        // row 2 col 1
//        gbc.gridy = 1;
//
//
//        // row 3 col 1
//        gbc.gridy = 2;




        add(mainPanel, BorderLayout.CENTER); // add main panel to this panel



    }

    private JPanel createResultPanel()
    {
        var resultPanel = new JPanel(new GridBagLayout());
        var gbc = new GridBagConstraints();

        var wpmLabel = new JLabel("WPM");
        var timeLabel = new JLabel("TIME");
        var accuracyLabel = new JLabel("ACCURACY");

        resultPanel.setBackground(Color.BLUE);


        // row 1, col 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        resultPanel.add(wpmLabel, gbc); // add wpm

        // row 2, col 1
        gbc.gridy = 1;
        resultPanel.add(timeLabel, gbc); // add time

        // row 3, col 1
        gbc.gridy = 2;
        resultPanel.add(accuracyLabel, gbc); // add accuracy

        gbc.fill = GridBagConstraints.BOTH; // expand everything that gird contains
        gbc.insets = new Insets(5, 5, 5, 5); // gap at top of the components
        gbc.ipadx = 100; // width of the component
        gbc.ipady = 20; // height of the component

        // row 2, col 1
        gbc.gridx = 1;
        gbc.gridy = 0;
        resultPanel.add(wpmPanel, gbc);

        // row 2, col 2
        gbc.gridy = 1;
        resultPanel.add(timePanel, gbc);

        // rwo 2, col 3
        gbc.gridy = 2;
        resultPanel.add(accuracyPanel, gbc);


        return resultPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new JFrame();
            frame.getContentPane().add(new ResultsStatsView());
            frame.setBounds(0, 0, 800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
