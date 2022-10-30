package app.gui.tree.controller;


import app.gui.tree.model.RuTreeItem;
import app.repository.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;

    public RuTreeCellEditor(JTree tree, DefaultTreeCellRenderer arg1) {
        super(tree, arg1);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object arg1, boolean isSelected, boolean expanded, boolean leaf, int row) {
        //return super.getTreeCellEditorComponent(tree, arg1, isSelected, expanded, leaf, row);
        clickedOn = arg1;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject event) {
        if(event instanceof MouseEvent){
            if((((MouseEvent) event).getClickCount()==3)) {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if(!(clickedOn instanceof RuTreeItem)){
            return;
        }

        RuTreeItem clicked = (RuTreeItem) clickedOn;

        if(clicked.getNodeModel() instanceof Workspace){
            clicked.setName(e.getActionCommand());
        }
        else if (clicked.getNodeModel() instanceof Project){
            clicked.setName(e.getActionCommand());
            Project project = (Project) clicked.getNodeModel();
            project.setName(e.getActionCommand());
        }
        else if (clicked.getNodeModel() instanceof Document){
            clicked.setName(e.getActionCommand());
            Document document = (Document) clicked.getNodeModel();
            document.setName(e.getActionCommand());
        }
        else if (clicked.getNodeModel() instanceof Page){
            clicked.setName(e.getActionCommand());
            Page page = (Page) clicked.getNodeModel();
            page.setName(e.getActionCommand());
        }
        else if (clicked.getNodeModel() instanceof Slot){
            clicked.setName(e.getActionCommand());
        }
    }
}
