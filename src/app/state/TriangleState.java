package app.state;

import app.command.AddSlotCommand;
import app.factory.SlotFactory;
import app.factory.TriangleFactory;
import app.repository.Page;
import app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class TriangleState extends State{

    private Page med;
    private SlotFactory triangleFactory;

    public TriangleState(Page med) {
        this.med = med;
    }

    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        triangleFactory = new TriangleFactory();
        if (e.getButton()==MouseEvent.BUTTON1){
            med.getCommandManager().addCommand(new AddSlotCommand(med,position,med.getSelectedSlots(),"Triangle"));

//            SlotDevice slotDevice = triangleFactory.makeSlot(position);
//            med.addSlotElements(slotDevice);
        }
    }
}
