package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TriangleAction extends AbstractManagerAction{

    public TriangleAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/triangle.png"));
        putValue(NAME, "Triangle");
        putValue(SHORT_DESCRIPTION, "Draw triangle");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            ((Page) item).startTriangleState();
        }
    }
}
