package app.gui.controller;

import app.gui.view.MainFrame;
import app.repository.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractManagerAction{

    public RedoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/redo1.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "redo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Page page = (Page) MainFrame.getInstance().getRuTree().getSelectedNode();
        page.getCommandManager().doCommand();
    }
}
