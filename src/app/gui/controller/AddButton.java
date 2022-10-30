package app.gui.controller;

import app.MainCore;
import app.core.EventHandler;
import app.eventHandler.Type;
import app.gui.view.MainFrame;
import app.repository.*;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class AddButton extends AbstractManagerAction {

    private EventHandler eventHandler;

    public AddButton() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("Images/add.png"));
        putValue(NAME, "Add");
        putValue(SHORT_DESCRIPTION, "Add new project");

    }

    @Override
    public void actionPerformed(ActionEvent e) {


         RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());

        if(item==null){
            MainCore.getEventHandler().generateError(Type.NIJE_NISTA_SELEKTOVANO);
        }

        if (item instanceof Workspace) {
            Project project = new Project("Project " + ((Workspace)item).getCount(), item);
            ((Workspace) item).increaseCount();
            MainFrame.getInstance().getRuTree().addProject(project);
           }

        if(item instanceof Project){
            Document document = new Document("Document " + ((Project)item).getCount(), item);
            ((Project) item).increaseCount();
            MainFrame.getInstance().getRuTree().addDocument(document, (Project) item);
            }

        if(item instanceof Document){
            Page page = new Page("Page  " + ((Document)item).getCount(), item );
            ((Document) item).increaseCount();
            MainFrame.getInstance().getRuTree().addPage(page, (Document) item);
        }

        if(item instanceof Page){
            Slot slot = new Slot("Slot " + ((Page)item).getCount(), item );
            ((Page) item).increaseCount();
            MainFrame.getInstance().getRuTree().addSlot(slot, (Page) item);
        }

        }
    }
