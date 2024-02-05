package controller;

import model.MenuModel;
import model.TypingPracticeModel;
import view.CustomTextPane;
import view.MenuView;
import view.TypingPracticeView;

import java.awt.*;

public class MenuController
    implements Controller
{


    private MenuView menuView;
    private MenuModel menuModel;

    public MenuController(MainControllerMediator mainControllerMediator)
    {
        menuView = new MenuView();
        menuModel = new MenuModel(mainControllerMediator);
        addActionListenerToMenuView();
    }



    public void addActionListenerToMenuView()
    // add action listener to menu view
    {
        menuView  // MenuView object
                .getStartGameButton() // get start button from it
                .addActionListener((e) ->  // add action listener
                        {
                            // set game configurations in typingPracticeController
                            menuModel.mainControllerMediator.notification(this,
                                    // typingMode and difficultyLevelOption
                                    new String[]{ menuView.getTypingMode().getSelectedItem() + "",
                                            menuView.getDifficultyLevelOption().getSelectedItem() + "" }

                            );

                        }
                );

        menuView
                .getDifficultyLevelOption() // get difficulty level option selector
                .addActionListener((e) ->
                {
                    // selected item: Easy, Medium, Hard
                    menuModel.difficultyLevel = String.valueOf(
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
                    menuModel.typingMode = String.valueOf(
                            menuView
                                    .getTypingMode()
                                    .getSelectedItem()
                    );
                });


    } // end of addActionListenerToMenuView()


    public MenuView getMenuView()
    {
        return menuView;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }






}
