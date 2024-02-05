package controller;

import model.TypingPracticeModel;
import view.CustomTextPane;
import view.TypingPracticeComponent;
import view.TypingPracticeView;

public class TypingPracticeController
    implements Controller, TypingPracticeControllerMediator
{
    private TypingPracticeView typingPracticeView;
    private TypingPracticeModel typingPracticeModel;


    public TypingPracticeController(MainControllerMediator mainControllerMediator)
    {
        typingPracticeView = new TypingPracticeView(this);
        typingPracticeModel = new TypingPracticeModel(mainControllerMediator);
        addActionListenerToTypingPracticeView();
    } // end of TypingPracticeController()



    public void addActionListenerToTypingPracticeView()
    // add action listener to typing practice view
    {
        typingPracticeView
                .getMainMenuButton() // main menu button
                .addActionListener((e) ->
                {
                    // if main menu is clicked send notification to mediator to change page
                    getTypingPracticeModel().mainControllerMediator.notification(this, new String[] { "Main Menu" });
                });

    } // end of addActionListenerToTypingPracticeView()

    public TypingPracticeView getTypingPracticeView()
    {
        return typingPracticeView;
    }

    public TypingPracticeModel getTypingPracticeModel()
    {
        return typingPracticeModel;
    }

    @Override
    public void notification(TypingPracticeComponent sender, char message)
    // message indicates what key was pressed typed or released respectively
    {
        if (sender instanceof CustomTextPane)
        {
            
        }

    }




}
