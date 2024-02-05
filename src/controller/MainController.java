package controller;

import model.MainModel;
import view.*;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

public class MainController
    implements MainControllerMediator
{
    public static MainView mainView;
    public static MainModel mainModel;

    public MainController()
    {
        mainView = new MainView();
        // add controllers here
        mainModel = new MainModel(new Controller[]
                {
                        new MenuController(this), new TypingPracticeController(this)
                });

        // mainView configurations
        FullScreenMode.makeFullScreen(mainView); // makes application full screen
        mainView.setFocusable(true); // Make window focusable to gain focus
        mainView.requestFocus(); // Gain focus to listen key events
        mainView.add(((MenuController) mainModel.getControllers()[0]).getMenuView()); // set MenuView as default when the screen will be opened
        addKeyListenerToMainView();

    } // end of MainController()

    private void addKeyListenerToMainView()
    // add key listeners to mainView components here
    {
        mainView.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                // if escape is pressed close window
                {
                    System.exit(0); // exit from program
                }
            }
        });
    } // end of addActionListenerToMainView()


    public static void changePage(JPanel from, String to)
    // changes JPanel displayed on MainView
    {
        switch (to)
        {
            case "MenuView" ->
            {
                mainView.getContentPane().remove(from);
                mainView.getContentPane().add(((MenuController) mainModel.getControllers()[0]).getMenuView());
            }
            case "TypingPracticeView" ->
            {
                mainView.getContentPane().remove(from);
                mainView.getContentPane().add(((TypingPracticeController) mainModel.getControllers()[1]).getTypingPracticeView());
            }
            default -> System.out.println("wrong panel");
        }

        // Show changes
        mainView.getContentPane().revalidate();
        mainView.getContentPane().repaint();

    } // end of changePage()


    @Override
    public void notification(Controller sender, String[] message)
    {


        if (sender instanceof MenuController)
        {
            // initialise session of game
            configureGame(sender, message);

        }
        else if (sender instanceof TypingPracticeController)
        {
            if (message[0].equals("Main Menu"))
            // if main menu button is clicked
            {
                // change page from TypingPracticeView to MenuView
                MainController
                        .changePage(((TypingPracticeController) sender)
                                .getTypingPracticeView(), "MenuView");

            }
        }
    }


    private void configureGame(Controller sender, String[] message)
    {
        // message contains strings with this sequence typingMode - 0 and difficultyLevelOption - 1
        var typingMode = message[0];
        var difficultyLevelOption = message[1];

        // Construct corresponding sentence using message and send it to typingPracticeController
        switch (difficultyLevelOption)
        {
            case "Easy" ->
            {
                switch (typingMode)
                {
                    case "Random" ->
                    {
                        var sentence = mainModel.easyRandomMode();
                        var typingPracticeController = ((TypingPracticeController) mainModel
                                .getControllerByClassName("TypingPracticeController"));

                        // get TypingPracticeModel to set sentence generated by mainModel
                        typingPracticeController.getTypingPracticeModel().sentence = sentence;

                        // display sentence on readingTextBar too!
                        typingPracticeController.getTypingPracticeView().getReadingTextBar().setText(sentence);

                        // change page from MenuView to TypingRacerView
                        MainController.changePage(((MenuController) sender).getMenuView(), "TypingPracticeView");
                    }
                    case "Sentences" ->
                    {

                    }
                    case "InstantDeath" ->
                    {

                    }
                }
            }
            case "Normal" ->
            {
                switch (difficultyLevelOption)
                {
                    case "Random" ->
                    {

                    }
                    case "Sentences" ->
                    {

                    }
                    case "InstantDeath" ->
                    {

                    }
                }
            }
            case "Hard" ->
            {
                switch (difficultyLevelOption)
                {
                    case "Random" ->
                    {

                    }
                    case "Sentences" ->
                    {

                    }
                    case "InstantDeath" ->
                    {

                    }
                }
            }
        }

    }





}
