package app.gui.controller;

import app.MainCore;
import app.gui.node.view.PageView;
import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RectangleAction extends AbstractManagerAction {

    public RectangleAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/rectangle.png"));
        putValue(NAME, "Rectangle");
        putValue(SHORT_DESCRIPTION, "Draw rectangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            System.out.println("selektovala si rectangle");
            ((Page) item).startRectangleState();
        }
    }
}
