package model;

import controller.MainControllerMediator;

import java.awt.*;
import java.util.Stack;

public class TypingPracticeModel
{

    public String sentence; // text to be played
    public Color charColor; // indicating what color should current char have, blue - if correctly written red if not
    public int indexOfCurrentChar; // index of the character of sentence being written
    public MainControllerMediator mainControllerMediator;
    public boolean gameIsOver = false;

    public TypingPracticeModel(MainControllerMediator mainControllerMediator)
    {
        indexOfCurrentChar = 0;
        charColor = Color.BLUE;
        this.mainControllerMediator = mainControllerMediator;

    } // end of TypingPracticeModel()




}
