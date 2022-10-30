package app.factory;

import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;


import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleFactory extends SlotFactory{


    @Override
    public SlotDevice create(Point2D pos) {

        /*RectangleElement or=new RectangleElement(new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.WHITE,
                "Rectangle", Color.BLACK, new Dimension(100,50), pos);

         */
        RectangleElement or=new RectangleElement("Rectangle", new Dimension(100,50), pos, 0, Color.RED);
        return or;
    }
}
