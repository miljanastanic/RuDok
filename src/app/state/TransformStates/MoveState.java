package app.state.TransformStates;

import app.MainCore;
import app.command.MoveSlotCommand;
import app.core.SlotHandler;
import app.repository.Page;
import app.repository.element.SlotDevice;
import app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class MoveState extends State {

    private Page med;
    private Point2D startingPoint;
    private Point2D endingPoint;
    private SlotDevice device;
    private SlotHandler slotHandler = MainCore.getSlotHandler();

    public MoveState(Page med) {
        this.med = med;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startingPoint=e.getPoint();
        if(e.getButton() == MouseEvent.BUTTON1){

                for(SlotDevice slotDevice : med.getSelectedSlots()){
                    //Point startingPoint = new Point((int) slotDevice.getX(),(int) slotDevice.getY());
                    slotDevice.setOldPosition(slotDevice.getPosition());
                }
            }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endingPoint=e.getPoint();
        for(SlotDevice slotDevice : med.getSelectedSlots()) {
            int x = (int) (slotDevice.getOldPosition().getX());
            int y = (int) (slotDevice.getOldPosition().getY());

           // endingPoint = new Point(x,y) ;
            device = slotHandler.moveSlot(startingPoint,endingPoint, slotDevice,x,y);
            med.addSlotElement(device);
        }
        med.notifySubscriber(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        med.getCommandManager().addCommand(new MoveSlotCommand(med));
        med.notifySubscriber(this);
    }


}


