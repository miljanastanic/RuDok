package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.view.ImageSlotView;
import app.gui.view.MainFrame;
import app.gui.view.SlotDetailsDialog;
import app.repository.Page;
import app.repository.node.RuNode;

import java.awt.event.ActionEvent;

public class ImageButtonListener extends AbstractManagerAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            if(((Page) item).getSelectedSlot()!=null) {
                MainFrame mainFrame = MainFrame.getInstance();
                ((Page) item).getSelectedSlot().setType("image");
                /*SlotDetailsDialog slotDetailsDialog = new SlotDetailsDialog(mainFrame, false, ((Page) item).getSelectedSlot());
                slotDetailsDialog.setVisible(true);

                 */
                ImageSlotView imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                imageSlotView.setVisible(true);
            }else{
                MainCore.getEventHandler().generateError(Type.NIJE_SELEKTOVAN_SLOT);
            }
        }

    }
}
