package app.gui.controller;

import app.MainCore;
import app.gui.node.view.PageView;
import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CircleAction extends AbstractManagerAction{

    public CircleAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/circle.png"));
        putValue(NAME, "Circle");
        putValue(SHORT_DESCRIPTION, "Draw circle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            ((Page) item).startCircleState();
        }
    }
}
