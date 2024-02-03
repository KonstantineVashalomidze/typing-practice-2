package view;

import javax.swing.*;
import java.awt.*;

public class FullScreenMode
{
    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];



    // this method adds logic of full screen mode.
    public static void makeFullScreen(JFrame frame)
    {
        // makes window full screen
        device.setFullScreenWindow(frame);
    }

    // this method makes window default screen
    public static void makeDefaultScreen(JFrame frame)
    {
        device.setFullScreenWindow(null);
    }

}