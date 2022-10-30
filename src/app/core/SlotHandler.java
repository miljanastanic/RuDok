package app.core;

import app.repository.element.SlotDevice;

import java.awt.geom.Point2D;

public interface SlotHandler {

   SlotDevice resizeSlot(Point2D point,Point2D pos, SlotDevice slotDevice, int x, int y);
   void rotateSlot(SlotDevice slotDevice);
   SlotDevice moveSlot(Point2D point,Point2D pos, SlotDevice slotDevice, int x, int y);

}
