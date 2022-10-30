package app.gui.view;

import app.gui.controller.RedoAction;
import app.gui.controller.UndoAction;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    public ToolBar(){
        super(SwingConstants.HORIZONTAL);

        setFloatable(true);
        setBackground(Color.WHITE);

        add(MainFrame.getInstance().getActionManager().getAddButton());
        add(MainFrame.getInstance().getActionManager().getDeleteButton());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getShareButton());
        add(MainFrame.getInstance().getActionManager().getNewTabButton());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getAboutButton());
        add(MainFrame.getInstance().getActionManager().getExitButton());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getImagesAndTextButton());
        add(new UndoAction());
        add(new RedoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSwitchWorkspaceAction());

    }
}
