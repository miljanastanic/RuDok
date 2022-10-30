package app.gui.node.view.graphics.painters;

import app.repository.element.CircleElement;
import app.repository.element.SlotDevice;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class CirclePainter extends DevicePainter{

    public CirclePainter(SlotDevice slot, Point2D position) {
        super(slot);

        CircleElement circleElement = (CircleElement) slot;

        shape=new GeneralPath();

        ((GeneralPath)shape).moveTo(position.getX()+circleElement.getSize().getWidth()/2,position.getY());

        ((GeneralPath)shape).quadTo(position.getX()+circleElement.getSize().getWidth(), position.getY(),
                position.getX()+circleElement.getSize().getWidth(),
                position.getY()+circleElement.getSize().getHeight()/2);

        ((GeneralPath)shape).quadTo(position.getX()+circleElement.getSize().getWidth(), position.getY()+circleElement.getSize().getHeight(),
                position.getX()+circleElement.getSize().getWidth()/2,
                position.getY()+circleElement.getSize().getHeight());

        ((GeneralPath)shape).quadTo(position.getX(), position.getY()+circleElement.getSize().getHeight(),
                position.getX(), position.getY()+circleElement.getSize().getHeight()/2);


        ((GeneralPath)shape).quadTo(position.getX(), position.getY(),
                position.getX()+circleElement.getSize().getWidth()/2,position.getY());


    }
}
