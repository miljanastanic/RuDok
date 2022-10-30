package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.controller.AbstractManagerAction;
import app.gui.node.view.DocumentView;
import app.gui.view.MainFrame;
import app.repository.Document;
import app.repository.Project;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewTabButton extends AbstractManagerAction {

    public NewTabButton(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("Images/newTab.png"));
        putValue(NAME, "NewTab");
        putValue(SHORT_DESCRIPTION, "Add new document tab");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode item = MainFrame.getInstance().getRuTree().getSelectedNode();
        if(item==null){
            MainCore.getEventHandler().generateError(Type.NIJE_NISTA_SELEKTOVANO);
        }else if(item instanceof Document) {
            DocumentView documentView = new DocumentView((Document)item, (Project) item.getParent());
        }else{
            MainCore.getEventHandler().generateError(Type.NEW_TAB_NIJE_DOKUMENT);
        }

    }
}
