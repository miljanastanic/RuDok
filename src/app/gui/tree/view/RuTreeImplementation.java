package app.gui.tree.view;


import app.MainCore;
import app.eventHandler.Type;
import app.gui.tree.RuTree;
import app.gui.tree.model.RuTreeItem;
import app.gui.view.MainFrame;
import app.repository.*;
import app.repository.node.RuNode;
import app.repository.node.RuNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class RuTreeImplementation implements RuTree {

    private RuTreeView ruTreeView;
    private DefaultTreeModel treeModel;

    @Override
    public JTree generateTree(Workspace workspace) {
        RuTreeItem root = new RuTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        ruTreeView = new RuTreeView(treeModel);
        return ruTreeView;
    }

    @Override
    public void addProject(Project project) {
        RuNode nodeModel = ((RuTreeItem)treeModel.getRoot()).getNodeModel();
        ((RuTreeItem)treeModel.getRoot()).add(new RuTreeItem(project));
        ((Workspace) nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(ruTreeView);
    }

    @Override
    public void addDocument(Document document, Project project) {
        ((RuTreeItem)ruTreeView.getLastSelectedPathComponent()).add(new RuTreeItem(document));
        project.addChild(document);
        ruTreeView.expandPath(ruTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(ruTreeView);
    }

    @Override
    public void addPage(Page page, Document document) {
        ((RuTreeItem)ruTreeView.getLastSelectedPathComponent()).add(new RuTreeItem(page));
        document.addChild(page);
        ruTreeView.expandPath(ruTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(ruTreeView);
    }

    @Override
    public void addSlot(Slot slot, Page page) {
        ((RuTreeItem)ruTreeView.getLastSelectedPathComponent()).add(new RuTreeItem(slot));
        page.addChild(slot);
        ruTreeView.expandPath(ruTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(ruTreeView);
    }

    @Override
    public void removeNode(RuNode node) {

           RuNodeComposite parent = (RuNodeComposite) ((RuTreeItem) ruTreeView.getLastSelectedPathComponent()).getNodeModel().getParent();
           parent.removeChild(node);
           SwingUtilities.updateComponentTreeUI(ruTreeView);

    }

    @Override
    public void shareNode(RuNode document, RuNode project) {

        String oldName;

        RuTreeItem root = (RuTreeItem)treeModel.getRoot();
        RuTreeItem parent = root.findChildByName(document.getParent().getName());
        RuTreeItem child = parent.findChildByName(document.getName());
        oldName = child.getName();
        child.setName("~" + child.getName());
        root.findChildByName(project.getName()).insert(child,0);
        ruTreeView.expandPath(ruTreeView.getSelectionPath());
        ((Project)project).addChild(document);
        document.setName(oldName);

        SwingUtilities.updateComponentTreeUI(ruTreeView);
    }


    @Override
    public RuNode getSelectedNode(){
        if(((RuTreeItem)ruTreeView.getLastSelectedPathComponent())==null) {
           return null;
        }else{
            return ((RuTreeItem) ruTreeView.getLastSelectedPathComponent()).getNodeModel();
        }
    }

    public Project getCurrentProject() {
       /* TreePath path = ruTreeView.getSelectionPath();
        for(int i=0; i<path.getPathCount(); i++){
            if(path.getPathComponent(i) instanceof Project){
                return (Project)path.getPathComponent(i);
            }
        }
        return null;

        */

        if(getSelectedNode() instanceof Project){
            return (Project) this.getSelectedNode();
        }else{
            return null;
        }

    }


}
