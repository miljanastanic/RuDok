package app.state.TransformStates;

import app.MainCore;
import app.command.MoveSlotCommand;
import app.command.ResizeSlotCommand;
import app.core.SlotHandler;
import app.repository.Page;
import app.repository.element.SlotDevice;
import app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ResizeState extends State {
    private Page med;
    private SlotDevice device;
    private Point2D oldPoint;
    private Point2D newPoint;
    SlotHandler slotHandler = MainCore.getSlotHandler();

    public ResizeState(Page med) {
        this.med = med;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldPoint= e.getPoint();
        if(e.getButton() == MouseEvent.BUTTON1) {
            for(SlotDevice sdevice : med.getSelectedSlots()){
                sdevice.setOldSize(device.getSize());
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        newPoint = e.getPoint();
        for (SlotDevice sdevice : med.getSelectedSlots()) {
            int x =(int)(sdevice.getOldSize().getWidth());
            int y = (int)(sdevice.getOldSize().getHeight());
            device = slotHandler.resizeSlot(oldPoint,newPoint,sdevice,x,y);
          //  med.notifySubscriber(device);
        }
        med.notifySubscriber(device);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      //  for(SlotDevice sdevice : med.getSelectedSlots()){
        //    sdevice.setOldSize(sdevice.getSize());
       // }
        med.getCommandManager().addCommand(new ResizeSlotCommand(med));
        med.notifySubscriber(this);
    }


}
