package app.gui.node.view.graphics.painters;

import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;
import app.repository.element.TriangleElement;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class TrianglePainter extends DevicePainter{

    public TrianglePainter(SlotDevice slot, Point2D position) {
        super(slot);

        TriangleElement triangleElement = (TriangleElement) slot;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(position.getX(),position.getY());

        ((GeneralPath)shape).lineTo(position.getX()+triangleElement.getSize().width,
                position.getY());

        ((GeneralPath)shape).lineTo(position.getX(),
                position.getY()+triangleElement.getSize().height);

        ((GeneralPath)shape).closePath();
    }
}
