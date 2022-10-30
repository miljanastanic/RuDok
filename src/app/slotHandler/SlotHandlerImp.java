package app.slotHandler;

import app.core.SlotHandler;
import app.gui.node.view.graphics.painters.CirclePainter;
import app.gui.node.view.graphics.painters.RectanglePainter;
import app.gui.node.view.graphics.painters.TrianglePainter;
import app.repository.element.CircleElement;
import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;
import app.repository.element.TriangleElement;

import java.awt.*;
import java.awt.geom.Point2D;

public class SlotHandlerImp implements SlotHandler{
    @Override
    public SlotDevice resizeSlot(Point2D startingPoint,Point2D endingPoint, SlotDevice selectedSlot,int oldx,int oldy) {

        int distanceX = (int) (oldx+(endingPoint.getX() - startingPoint.getX()));
        int distanceY = (int) (oldy+(endingPoint.getY() - startingPoint.getY()));
        //System.out.println(selectedSlot.toString());

        selectedSlot.setSize(new Dimension(distanceX,distanceY));

        if(selectedSlot instanceof RectangleElement){
            selectedSlot.setPainter(new RectanglePainter(selectedSlot, selectedSlot.getPosition()));
        }else if(selectedSlot instanceof TriangleElement){
            selectedSlot.setPainter(new TrianglePainter(selectedSlot, selectedSlot.getPosition()));
        }else if(selectedSlot instanceof CircleElement){
            selectedSlot.setPainter(new CirclePainter(selectedSlot, selectedSlot.getPosition()));
        }


        selectedSlot.setPaint(Color.RED);

        return selectedSlot;


    }

    @Override
    public void rotateSlot(SlotDevice slotDevice) {

    }

    @Override
    public SlotDevice moveSlot(Point2D startPoint,Point2D endPoint, SlotDevice selectedSlot,int oldx,int oldy) {

        int x = (int)(oldx+(endPoint.getX()-startPoint.getX())) ;
        int y = (int)(oldy+(endPoint.getY()-startPoint.getY())) ;

        selectedSlot.setPosition(new Point(x,y));

        if(selectedSlot instanceof RectangleElement){
            selectedSlot.setPainter(new RectanglePainter(selectedSlot,selectedSlot.getPosition()));
        }else if(selectedSlot instanceof TriangleElement){
            selectedSlot.setPainter(new TrianglePainter(selectedSlot,selectedSlot.getPosition()));
        }else if(selectedSlot instanceof CircleElement){
            selectedSlot.setPainter(new CirclePainter(selectedSlot, selectedSlot.getPosition()));
        }

        selectedSlot.setPaint(Color.RED);

        return selectedSlot;

    }

}
