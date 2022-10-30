package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectAction extends AbstractManagerAction{

    public SelectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/select1.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            System.out.println("selektovala si rectangle");
            ((Page) item).startSelectState();
        }
    }
}
