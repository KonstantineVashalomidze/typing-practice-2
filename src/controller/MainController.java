package controller;

import model.MainModel;
import view.*;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

public class MainController
{
    public MainView mainView;
    public MainModel mainModel;
    public String difficultyLevel; // Easy, Normal, Hard
    public String typingMode; // Random, Sentences, InstantDeath
    public String sentence; // text to be played
    public Color charColor; // indicating what color should current char have, blue - if correctly written red if not
    public int indexOfCurrentChar; // index of the character of sentence being written

    public int indexOfLastNonAlpha; // remember last non-alphabetical character for ctrl+delete to work

    public MainController()
    {
        difficultyLevel = "Easy"; // set easy as default
        typingMode = "Random"; // as default
        indexOfLastNonAlpha = 0;
        charColor = Color.BLUE;
        this.mainView = new MainView();
        this.mainModel = new MainModel();

        // mainView configurations
        FullScreenMode.makeFullScreen(mainView); // makes application full screen
        mainView.setFocusable(true); // Make window focusable to gain focus
        mainView.requestFocus(); // Gain focus to listen key events
        mainView.add(mainModel.getPages()[0]); // set MenuView as default when the screen will be opened
        addKeyListenerToMainView();
        addActionListenerToMenuView(); // add action listeners to menu view in this function
        addActionListenerToTypingPracticeView(); // add action listeners typing practice view in this function
    } // end of MainController()

    private void addKeyListenerToMainView()
    // add key listeners to mainView components here
    {
        mainView.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                // if escape is pressed close window
                {
                    System.exit(0); // exit from program
                }
                else
                {
                    var typingPracticeView = (TypingPracticeView) mainModel.getPages()[1]; // get object of tyingPracticeView
                    var readingTextBar = typingPracticeView.getReadingTextBar(); // get object of readingTextBar which is JTextPane

                    if (typingPracticeView.getParent() != null && indexOfCurrentChar < sentence.length())
                    // check if current window is typingPracticeView and if caret position is less than string
                    {

                        if (e.isControlDown() && e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                        // delete whole word
                        {
                            indexOfCurrentChar = indexOfLastNonAlpha;
                            ((CustomTextPane) readingTextBar).clearPaint(indexOfCurrentChar); // recolor everything written as black again

                        }

                        if (!Character.isAlphabetic(sentence.charAt(indexOfCurrentChar)))
                        // non alpha and not digit is seen
                        {
                            indexOfLastNonAlpha = indexOfCurrentChar; // set index of last seen as necessary
                            System.out.println(indexOfLastNonAlpha);
                        }

                        if (Character.isAlphabetic(e.getKeyChar()) || e.getKeyChar() == ' ')
                        // easy mode
                        {
                            if (sentence.charAt(indexOfCurrentChar) != e.getKeyChar())
                            // set red if char is typed wrongly
                            {
                                charColor = Color.RED;
                            }

                            if (sentence.charAt(indexOfCurrentChar) == e.getKeyChar())
                            // set blue if char is typed correctly
                            {
                                charColor = Color.BLUE;
                            }

                            // repaints char and controls of caret position and current char index
                            ((CustomTextPane) readingTextBar).repaintCharAtIndex(indexOfCurrentChar, charColor); // cast JTextPane to CustomTextPane and paint current char as necessary
                            readingTextBar.setCaretPosition(indexOfCurrentChar + 1);
                            indexOfCurrentChar++;

                        }






                    }

                    if (indexOfCurrentChar > 0 && e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                    // if delete button is clicked
                    {
                        indexOfCurrentChar--;
                        readingTextBar.setCaretPosition(indexOfCurrentChar);
                        ((CustomTextPane) readingTextBar).repaintCharAtIndex(indexOfCurrentChar, Color.BLACK); // cast JTextPane to CustomTextPane and paint current char as necessary

                    }




                }


            }
        });

    } // end of addActionListenerToMainView()

    public void addActionListenerToMenuView()
    // add action listener to menu view
    {
        var menuView = (MenuView) mainModel.getPages()[0];
        menuView  // MenuView object
                .getStartGameButton() // get start button from it
                .addActionListener((e) ->  // add action listener
                {
                    // remove MenuView object from mainView and add TypingPracticeView to it
                    mainView.getContentPane().remove(menuView);
                    mainView.getContentPane().add(mainModel.getPages()[1]);
                    selectedGameMode(); // will give sentence variable random value depending on game type and hardness selected
                    mainView.getContentPane().revalidate(); // repaint to showcase changes
                    mainView.getContentPane().repaint();
                }
        );

        menuView
                .getDifficultyLevelOption() // get difficulty level option selector
                .addActionListener((e) ->
                {
                    // selected item: Easy, Medium, Hard
                    difficultyLevel = String.valueOf(
                            menuView
                            .getDifficultyLevelOption()
                            .getSelectedItem()
                    );
                });

        menuView
                .getTypingMode() // get typing mode option selector
                .addActionListener((e) ->
                {
                    // selected item: Random, Sentences, InstantDeath
                    typingMode = String.valueOf(
                            menuView
                            .getTypingMode()
                            .getSelectedItem()
                    );
                });





    } // end of addActionListenerToMenuView()

    public void addActionListenerToTypingPracticeView()
    // add action listener to typing practice view
    {
        var typingPracticeView = (TypingPracticeView) mainModel.getPages()[1]; // TypingPracticeView object
        typingPracticeView
                .getMainMenuButton() // main menu button
                .addActionListener((e) ->
                {
                    mainView.getContentPane().remove(typingPracticeView); // remove current page from frame
                    mainView.getContentPane().add(mainModel.getPages()[0]); // add main menu view as current page
                    mainView.getContentPane().revalidate(); // display changes
                    mainView.getContentPane().repaint();
                });

    } // end of addActionListenerToTypingPracticeView()

    public void selectedGameMode()
    // initializes value of sentences variable when typing practice is opened
    {
        var typingPracticeView = (TypingPracticeView) mainModel.getPages()[1];
        var readingTextBar = typingPracticeView.getReadingTextBar();

        switch (typingMode)
        {
            case "Random" -> {
                switch (difficultyLevel) // words are randomly selected from words.txt and sentence is formed
                {
                    case "Easy" -> // sentences are just made from existing file
                    {
                        sentence = mainModel.easyRandomMode(); // get randomly generated words
                        indexOfCurrentChar = 0; // make current char position 0
                        readingTextBar.setText(sentence); // set text that should be played
                        readingTextBar.setPreferredSize(new Dimension()); //
                        readingTextBar.setCaretPosition(indexOfCurrentChar); // set caret position to one
                        readingTextBar.getCaret().setVisible(true); // make caret visible
                        ((CustomTextPane) readingTextBar).clearPaint(-1); // clear everything as black

                    }
                    case "Normal" ->  // sentences contain [,.'!?]
                            sentence = mainModel.normalRandomMode();
                    case "Hard" ->  // sentences contain [(0-9),.'!?:"_-+&]
                            sentence = mainModel.hardRandomMode();
                    default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
                }
            }
            case "Sentences" -> {
                switch (difficultyLevel) {
                    case "Easy" -> sentence = mainModel.easySentencesMode();
                    case "Normal" -> sentence = mainModel.normalSentencesMode();
                    case "Hard" -> sentence = mainModel.hardSentencesMode();
                    default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
                }
            }
            case "InstantDeath" -> {
                switch (difficultyLevel) {
                    case "Easy" -> sentence = mainModel.easyInstantDeathMode();
                    case "Normal" -> sentence = mainModel.normalInstantDeathMode();
                    case "Hard" -> sentence = mainModel.hardInstantDeathMode();
                    default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + typingMode);
        }
    } // end of readingTextBarController()





}
