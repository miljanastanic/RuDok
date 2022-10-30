package app.repository.element;

import app.gui.node.view.graphics.painters.CirclePainter;
import app.gui.node.view.graphics.painters.RectanglePainter;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleElement extends SlotDevice{

  /*  public CircleElement(Stroke stroke, Paint paint, String name, Color strokeColor, Dimension size, Point2D position) {
        super(stroke, paint, name, strokeColor, size, position);
        elementPainter = new CirclePainter(this);
    }

   */
  public CircleElement(String name, Dimension size, Point2D position,double angle, Color paint) {
      super(name, size, position, angle, paint);
      elementPainter = new CirclePainter(this,position);
  }

}
