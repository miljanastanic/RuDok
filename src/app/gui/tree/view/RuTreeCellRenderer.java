package app.gui.tree.view;

import app.gui.tree.model.RuTreeItem;
import app.repository.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    public RuTreeCellRenderer() {

    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);

        if (((RuTreeItem)value).getNodeModel() instanceof Workspace) {
            URL imageURL = getClass().getResource("images/workspace.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        } else if (((RuTreeItem)value).getNodeModel() instanceof Project) {
            URL imageURL = getClass().getResource("images/project.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        }else if (((RuTreeItem)value).getNodeModel() instanceof Document) {
            URL imageURL = getClass().getResource("images/document.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        }else if (((RuTreeItem)value).getNodeModel() instanceof Page) {
            URL imageURL = getClass().getResource("images/page.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        }else if (((RuTreeItem)value).getNodeModel() instanceof Slot) {
            URL imageURL = getClass().getResource("images/slot.png");
            Icon icon = null;
            if (imageURL != null)
                icon = new ImageIcon(imageURL);
            setIcon(icon);

        }
        return this;
    }



}
