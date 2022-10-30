package app.gui.node.view.graphics.painters;

import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public abstract class ElementPainter implements Serializable {

    private SlotDevice slotDevice;

    public ElementPainter(SlotDevice device) {	}

    public abstract void paint(Graphics2D g, SlotDevice device,Double degrees);

    public abstract void paintLasso(Graphics2D g, Point2D startingPoint, Point2D endingPoint);

    public abstract boolean elementAt(Point pos);
}
