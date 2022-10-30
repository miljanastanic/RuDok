package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LassoAction extends AbstractManagerAction{

    public LassoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/lasso.png"));
        putValue(NAME, "L");
        putValue(SHORT_DESCRIPTION, "Select more slots");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            ((Page) item).startLassoState();
        }
    }
}
