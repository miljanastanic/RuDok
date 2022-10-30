package app.gui.controller;

import app.gui.view.ImageSlotView;
import app.gui.view.MainFrame;
import app.gui.view.SlotDetailsDialog;
import app.repository.Page;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;


public class EditImageListener extends AbstractManagerAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ImageFileFilter());

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            String path = jfc.getSelectedFile().getAbsolutePath();

            RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
            if (item instanceof Page) {
                if (((Page) item).getSelectedSlot() != null) {
                    MainFrame mainFrame = MainFrame.getInstance();
                    ((Page) item).getSelectedSlot().setFile(new File(path));

                    ImageSlotView imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                    imageSlotView.setVisible(true);
                }
            }
        }
    }
}
