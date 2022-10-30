package app.gui.node.view.graphics.painters;

import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;


public class RectanglePainter extends DevicePainter{

    public RectanglePainter(SlotDevice slot, Point2D position) {
        super(slot);
        RectangleElement rectangleElement = (RectangleElement) slot;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(position.getX(),position.getY());

        ((GeneralPath)shape).lineTo(position.getX()+rectangleElement.getSize().width,
                position.getY());

        ((GeneralPath)shape).lineTo(position.getX()+rectangleElement.getSize().width,
                position.getY()+rectangleElement.getSize().height);

        ((GeneralPath)shape).lineTo(position.getX(),
                position.getY()+rectangleElement.getSize().height);

        ((GeneralPath)shape).closePath();


    }




}
