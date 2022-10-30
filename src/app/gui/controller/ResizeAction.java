package app.gui.controller;

import app.gui.node.view.graphics.painters.CirclePainter;
import app.gui.node.view.graphics.painters.DevicePainter;
import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ResizeAction extends AbstractManagerAction{

    public ResizeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/resize.png"));
        putValue(NAME, "Resize");
        putValue(SHORT_DESCRIPTION, "Resize shape");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            System.out.println("resize state active");
            ((Page) item).startResizeState();
        }
    }
}
