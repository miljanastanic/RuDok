package app.gui.controller;

import app.MainCore;
import app.eventHandler.Type;
import app.gui.view.ImageSlotView;
import app.gui.view.SlotDetailsDialog;
import app.gui.view.MainFrame;
import app.gui.view.TextSlotView;
import app.repository.Page;
import app.repository.node.RuNode;

import java.awt.event.ActionEvent;

public class DetailsButton extends AbstractManagerAction{

    public DetailsButton() {

        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("Images/add.png"));
        putValue(NAME, "Slot Details");
        putValue(SHORT_DESCRIPTION, "Slot Details");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SlotDetailsDialog slotDetailsDialog = null;
        TextSlotView textSlotView = null;
        ImageSlotView imageSlotView = null;

        RuNode item = (MainFrame.getInstance().getRuTree().getSelectedNode());
        if (item instanceof Page) {
            if(((Page) item).getSelectedSlot()!=null) {
                MainFrame mainFrame = MainFrame.getInstance();
                if(((Page) item).getSelectedSlot().getType().equals("")) {
                    slotDetailsDialog = new SlotDetailsDialog(mainFrame, false, ((Page) item).getSelectedSlot());
                    slotDetailsDialog.setVisible(true);
                }else if (((Page) item).getSelectedSlot().getType().equals("text")){
                     textSlotView = new TextSlotView(((Page) item).getSelectedSlot());
                    textSlotView.setVisible(true);
                }else if (((Page) item).getSelectedSlot().getType().equals("image")){
                     imageSlotView = new ImageSlotView(((Page) item).getSelectedSlot());
                    imageSlotView.setVisible(true);
                }
            }else{
                MainCore.getEventHandler().generateError(Type.NIJE_SELEKTOVAN_SLOT);
            }
        }
    }}


