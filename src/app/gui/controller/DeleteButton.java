package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.controller.AbstractManagerAction;
import app.gui.tree.model.RuTreeItem;
import app.gui.view.MainFrame;
import app.repository.Workspace;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class DeleteButton extends AbstractManagerAction {

    public DeleteButton() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
        //pitati zasto javlja warning

        putValue(SMALL_ICON, loadIcon("Images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete project");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode item = MainFrame.getInstance().getRuTree().getSelectedNode();

        if(item==null){
            MainCore.getEventHandler().generateError(Type.NIJE_NISTA_SELEKTOVANO);
        }
        else if(item instanceof Workspace){
            MainCore.getEventHandler().generateError(Type.NE_MOZE_SE_OBRISATI);
        }else {
            MainFrame.getInstance().getRuTree().removeNode(item);
        }
    }

}
