package app.repository.element;

import app.gui.node.view.graphics.painters.RectanglePainter;
import app.gui.node.view.graphics.painters.TrianglePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleElement extends SlotDevice{


   /* public TriangleElement(Stroke stroke, Paint paint, String name, Color strokeColor, Dimension size, Point2D position) {
        super(stroke, paint, name, strokeColor, size, position);
        elementPainter = new TrianglePainter(this);
    }

    */
   public TriangleElement(String name, Dimension size, Point2D position, double angle, Color paint) {
       super(name, size, position, angle, paint);
       elementPainter = new TrianglePainter(this,position);
   }
}
