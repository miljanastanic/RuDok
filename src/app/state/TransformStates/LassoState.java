package app.state.TransformStates;

import app.gui.node.view.graphics.painters.DevicePainter;
import app.repository.Page;
import app.repository.element.SlotDevice;
import app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;


public class LassoState extends State {

    private Page med;
    private Point2D startingPoint;
    private Point2D endingPoint;


    public LassoState(Page med) {
        this.med = med;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startingPoint = e.getPoint();
        /*
        if (e.getButton() == MouseEvent.BUTTON1) {
            int i = med.getDeviceAtPosition(startingPoint);
            if (i != -1) {
                SlotDevice slotDevice = med.getDeviceAt(i);
            }
         */
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        endingPoint = e.getPoint();
        med.notifySubscriber("");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // endingPoint = e.getPoint();

        for (SlotDevice s: med.getSlotElements()) {
            DevicePainter devicePainter = (DevicePainter) s.getPainter();
            if(devicePainter.getLasso().contains(s.getPosition())){
                med.addSelectedSlotToList(s);
                s.setPaint(Color.green);
                med.notifySubscriber(this);
            }else {
                med.getSelectedSlots().clear();
            }
        }
        //provera da li je lasso selektovao sve
        for (SlotDevice s: med.getSlotElements()){
            System.out.println(s);
        }
    }

    public Point2D getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point2D startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point2D getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Point2D endingPoint) {
        this.endingPoint = endingPoint;
    }
}
