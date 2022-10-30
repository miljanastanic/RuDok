package app.repository.element;

import app.gui.node.view.graphics.painters.RectanglePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectangleElement extends SlotDevice{


   // public RectangleElement(String name) {
     //   super(name);
       // elementPainter=new RectanglePainter(this);
    //}

   /* public RectangleElement(Stroke stroke, Paint paint, String name, Color strokeColor, Dimension size, Point2D position) {
       super(stroke, paint, name, strokeColor, size, position);
        elementPainter = new RectanglePainter(this);
    }

    */

    public RectangleElement(String name, Dimension size, Point2D position,double angle, Color paint) {
        super(name, size, position, angle, paint);
        elementPainter = new RectanglePainter(this,position);
    }
}
