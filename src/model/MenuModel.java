package model;

import controller.MainControllerMediator;

public class MenuModel
{
    public String difficultyLevel; // Easy, Normal, Hard
    public String typingMode; // Random, Sentences, InstantDeath

    public MainControllerMediator mainControllerMediator;

    public MenuModel(MainControllerMediator mainControllerMediator)
    {
        difficultyLevel = "Easy"; // set easy as default
        typingMode = "Random"; // as default
        this.mainControllerMediator = mainControllerMediator;
    }




}
