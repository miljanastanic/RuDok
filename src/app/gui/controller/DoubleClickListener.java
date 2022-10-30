package app.gui.controller;

import app.gui.node.view.DocumentView;
import app.gui.node.view.ProjectView;
import app.gui.node.view.RuTab;
import app.gui.view.MainFrame;
import app.repository.Document;
import app.repository.Project;
import app.repository.node.RuNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickListener implements MouseListener {

    public DoubleClickListener(){ }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        RuNode item = MainFrame.getInstance().getRuTree().getSelectedNode();

        if(e.getClickCount() == 2){

            if(item instanceof Document){
                    DocumentView documentView = new DocumentView((Document)item, (Project) item.getParent());
            }else if(item instanceof Project){

                MainFrame.getInstance().getTabbedPane().getRuTabs().clear();
                MainFrame.getInstance().getTabbedPane().removeAll();
                ProjectView projectView = new ProjectView((Project) item);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
