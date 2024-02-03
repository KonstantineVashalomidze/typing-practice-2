package view;

import javax.swing.*;
import java.awt.*;

public class MenuView
    extends JPanel
{

    private JLabel welcomeMessageLabel;  // creating welcome message
    private JButton startGameButton; // start game button
    private JComboBox<String> difficultyLevelOption; // game difficulties
    private JComboBox<String> typingMode; // typing mode
    private JButton settingsButton; // setting button

    public MenuView()
    {
        createDifficultyLevelComboBox();
        createTypingModeComboBox();
        welcomeMessageLabel = new JLabel("Welcome to typing practice 2");
        startGameButton = new JButton("Start");
        settingsButton = new JButton("Settings");


        setLayout(new BorderLayout()); // change layout to border layout
        var centerWelcomeMessagePanel = new JPanel(new FlowLayout());  // panel to center the welcome label
        centerWelcomeMessagePanel.add(welcomeMessageLabel); // add welcome label to that panel
        add(centerWelcomeMessagePanel, BorderLayout.NORTH); // add welcome message center panel to the top

        // add start difficulty and settings buttons to another panel to have vertical layout
        add(createVerticalPanel(), BorderLayout.CENTER);

    }

    public JButton getStartGameButton()
    {
        return startGameButton;
    }

    public JComboBox<String> getDifficultyLevelOption()
    {
        return difficultyLevelOption;
    }

    public JComboBox<String> getTypingMode()
    {
        return typingMode;
    }

    public JButton getSettingsButton()
    {
        return settingsButton;
    }

    private void createDifficultyLevelComboBox()
    {
        this.difficultyLevelOption = new JComboBox<>(); // game difficulty

        // add options to difficulty level combo box
        this.difficultyLevelOption.addItem("Easy");
        this.difficultyLevelOption.addItem("Normal");
        this.difficultyLevelOption.addItem("Hard");
    }

    private void createTypingModeComboBox()
    {
        this.typingMode = new JComboBox<>(); // typing mode
        // add options to typing mode
        typingMode.addItem("Random");
        typingMode.addItem("Sentences");
        typingMode.addItem("InstantDeath");
    }

    private JPanel createVerticalPanel()
    {
        var panel = new JPanel();
        var gbc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL; // fill components horizontally
        gbc.ipadx = 200; // set minimum width for components
        gbc.insets = new Insets(10, 0, 0, 0); // set gap to top
        // first row first column
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(startGameButton, gbc);
        // second row fist column
        gbc.gridy = 1;
        panel.add(difficultyLevelOption, gbc);
        // third row first column
        gbc.gridy = 2;
        panel.add(typingMode, gbc);
        gbc.gridy = 3;
        // forth row first column
        panel.add(settingsButton, gbc);
        return panel;
    }


}
