package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteShapeAction extends AbstractManagerAction{

    public DeleteShapeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/delete2.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete shape on double click");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            ((Page) item).startDeleteState();
        }

    }
}
