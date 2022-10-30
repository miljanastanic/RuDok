package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.view.MainFrame;
import app.gui.view.SlotDetailsDialog;
import app.gui.view.TextSlotView;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class TextButtonListener extends AbstractManagerAction{
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new TextFileFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            String path = jfc.getSelectedFile().getAbsolutePath();

            RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
            if (item instanceof Page) {
                if (((Page) item).getSelectedSlot() != null) {
                    MainFrame mainFrame = MainFrame.getInstance();
                    ((Page) item).getSelectedSlot().setType("text");
                    ((Page) item).getSelectedSlot().setFile(new File(path));

                    TextSlotView textSlotView = new TextSlotView(((Page) item).getSelectedSlot());
                    textSlotView.setVisible(true);

                } else {
                    MainCore.getEventHandler().generateError(Type.NIJE_SELEKTOVAN_SLOT);
                }
            }
        }
    }
}
