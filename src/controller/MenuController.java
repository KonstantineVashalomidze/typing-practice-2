package controller;

import model.MenuModel;
import view.MenuView;

public class MenuController
    implements Controller
{


    private MenuView menuView;
    private MenuModel menuModel;

    public MenuController()
    {
        menuView = new MenuView();
        menuModel = new MenuModel();
    }


}
