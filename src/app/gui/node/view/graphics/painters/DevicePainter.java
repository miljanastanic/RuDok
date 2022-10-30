package app.gui.node.view.graphics.painters;

import app.repository.element.SlotDevice;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DevicePainter extends ElementPainter {

    protected Shape shape;
    protected Rectangle2D lasso;
    protected double degrees = 0;

    public DevicePainter(SlotDevice slot) {
        super(slot);
    }

    @Override
    public void paint(Graphics2D g, SlotDevice element, Double degrees) {
        AffineTransform old = g.getTransform();
        g.rotate(Math.toRadians(element.getAngle()),element.getX(),element.getY());

        g.setPaint(element.getPaint());
        g.setStroke(new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL));
        g.draw(getShape());
        g.setColor(Color.WHITE);
        g.fill(getShape());

        if (element instanceof SlotDevice) {
            g.setPaint(Color.BLACK);
            SlotDevice slotDevice = (SlotDevice) element;
            g.drawString(slotDevice.getName(), (int) slotDevice.getPosition().getX() + 10,
                    (int) slotDevice.getPosition().getY() + 10);
        }

        g.setTransform(old);
//things you draw after here will not be rotated
        g.rotate(Math.toRadians(element.getAngle()),element.getX(),element.getY());


    }

    @Override
    public void paintLasso(Graphics2D g, Point2D startingPoint, Point2D endingPoint){
        g.setStroke(new BasicStroke((float)(1),BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL,1f,new float[]{3f,6f},0));
        g.setColor(Color.cyan);
        lasso = new Rectangle((int)startingPoint.getX(), (int)startingPoint.getY(), (int)endingPoint.getX(), (int)endingPoint.getY());
        g.draw(lasso);
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    public Rectangle2D getLasso() {
        return lasso;
    }

    public void setLasso(Rectangle2D lasso) {
        this.lasso = lasso;
    }
}
