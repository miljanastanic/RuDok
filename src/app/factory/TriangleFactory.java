package app.factory;

import app.repository.element.*;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleFactory extends SlotFactory{
    @Override
    public SlotDevice create(Point2D pos) {
      /*
        TriangleElement or=new TriangleElement(new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.WHITE,
                "Triangle", Color.BLACK, new Dimension(100,50), pos);

       */
        TriangleElement or=new TriangleElement("Triangle", new Dimension(100,50), pos, 0, Color.RED);
        return or;
    }
}
