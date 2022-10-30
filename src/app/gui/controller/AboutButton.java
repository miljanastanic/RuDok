package app.gui.controller;

import app.gui.view.AboutView;
import app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class AboutButton extends AbstractManagerAction {

    public AboutButton(){
        putValue(SMALL_ICON, loadIcon("Images/user.png"));
        putValue(NAME, "About");
        putValue(SHORT_DESCRIPTION, "About view");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame mainFrame = MainFrame.getInstance();
        AboutView about = new AboutView(mainFrame, false);
        about.setVisible(true);


    }
}
