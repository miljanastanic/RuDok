package app.gui.controller;

import app.gui.controller.AbstractManagerAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitButton extends AbstractManagerAction {

    public ExitButton(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("Images/exit.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit from aplication");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
