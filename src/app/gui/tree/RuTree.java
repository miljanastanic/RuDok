package app.gui.tree;

import app.repository.*;
import app.repository.node.RuNode;

import javax.swing.*;

public interface RuTree {

    JTree generateTree(Workspace workspace);

    void addProject(Project project);
    void addDocument(Document document, Project project);
    void addPage(Page page, Document document);
    void addSlot(Slot slot, Page page);
    void removeNode(RuNode parent);
    void shareNode(RuNode document, RuNode project);
    RuNode getSelectedNode();
    Project getCurrentProject();
}
