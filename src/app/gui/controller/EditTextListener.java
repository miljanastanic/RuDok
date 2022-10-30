package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.view.MainFrame;
import app.gui.view.SlotDetailsDialog;
import app.gui.view.TextEditorView;
import app.gui.view.TextSlotView;
import app.repository.Page;
import app.repository.node.RuNode;

import java.awt.event.ActionEvent;

public class EditTextListener extends AbstractManagerAction {
    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());

        if (item instanceof Page) {
            if (((Page) item).getSelectedSlot() != null) {
                MainFrame mainFrame = MainFrame.getInstance();
                TextEditorView textEditorView = new TextEditorView(mainFrame,((Page) item).getSelectedSlot());
                textEditorView.setVisible(true);

            }

        }
    }
}
