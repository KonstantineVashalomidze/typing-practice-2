package controller;

import javax.sound.midi.ControllerEventListener;

public interface MainControllerMediator
{

    // send message to mediator
    void notification(Controller sender, String[] message);




}
