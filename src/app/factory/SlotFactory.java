package app.factory;

import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class SlotFactory {

    //pitati da li je dobro!!
    //ideja je da prosledimo i state u kom se nalazimo i da factory pravi slot element na osnovu pozicije i tipa

    public SlotDevice makeSlot(Point2D pos){
        SlotDevice slotDevice;
        slotDevice = create(pos);
        //slotDevice.setPosition(pos);
        //slotDevice.setSize(new Dimension(50,50));
        /*slotDevice.setStroke(new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ));
        slotDevice.setPaint(Color.WHITE);
        slotDevice.setStrokeColor(Color.BLACK);
         */
        return slotDevice;
    }

    public abstract SlotDevice create(Point2D pos);

}

