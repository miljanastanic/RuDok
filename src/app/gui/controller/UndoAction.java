package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractManagerAction{
    public UndoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "undo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Page page = (Page) MainFrame.getInstance().getRuTree().getSelectedNode();
        page.getCommandManager().undoCommand();
    }
}
