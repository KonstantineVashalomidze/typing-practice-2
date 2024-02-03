package controller;

import model.TypingPracticeModel;
import view.TypingPracticeView;

public class TypingPracticeController
    implements Controller
{
    private TypingPracticeView typingPracticeView;
    private TypingPracticeModel typingPracticeModel;

    public TypingPracticeController()
    {
        typingPracticeView = new TypingPracticeView();
        typingPracticeModel = new TypingPracticeModel();
    }





}
