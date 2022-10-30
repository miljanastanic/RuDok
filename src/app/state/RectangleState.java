package app.state;

import app.command.AddSlotCommand;
import app.factory.RectangleFactory;
import app.factory.SlotFactory;
import app.repository.Page;
import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class RectangleState extends State{
//recfactory
    private SlotFactory rectangleFactory;
    private Page med;
    public RectangleState(Page med) {
        this.med = med;
    }

    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        rectangleFactory=new RectangleFactory();
        if (e.getButton() == MouseEvent.BUTTON1) {
            med.getCommandManager().addCommand(new AddSlotCommand(med,position,med.getSelectedSlots(),"Rectangle"));

//            SlotDevice slotDevice = rectangleFactory.makeSlot(position);
//           med.addSlotElements(slotDevice);
            // poziva make, i dodaje u listu dece
        }
    }
}
