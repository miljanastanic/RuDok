package app.factory;

import app.repository.element.CircleElement;
import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleFactory extends SlotFactory{


    @Override
    public SlotDevice create(Point2D pos) {
        /*
        CircleElement or=new CircleElement(new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.WHITE,
                "Circle", Color.BLACK, new Dimension(100,50), pos);

         */
        CircleElement or=new CircleElement("Circle", new Dimension(100,50), pos, 0, Color.RED);
        return or;
    }
}
