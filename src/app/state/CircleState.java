package app.state;

import app.command.AddSlotCommand;
import app.factory.CircleFactory;
import app.factory.SlotFactory;
import app.repository.Page;
import app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class CircleState extends State {

    private SlotFactory circleFactory;
    private Page med;

    public CircleState(Page med) {
        this.med = med;
    }

    public void mousePressed(MouseEvent e) {
        Point2D position = e.getPoint();
        circleFactory= new CircleFactory();
        if (e.getButton() == MouseEvent.BUTTON1) {
            med.getCommandManager().addCommand(new AddSlotCommand(med,position,med.getSelectedSlots(),"Circle"));
//            SlotDevice slotDevice = circleFactory.makeSlot(position);
//            med.addSlotElements(slotDevice);
            }
        }
    }
