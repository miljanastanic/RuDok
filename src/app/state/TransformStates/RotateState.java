package app.state.TransformStates;

import app.repository.Page;
import app.repository.element.SlotDevice;
import app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class RotateState extends State {

    private Page med;
    private Point2D startingPoint;

    public RotateState(Page med) {
        this.med = med;
    }

    SlotDevice slotDevice;

    SlotDevice selectedSlot;

    @Override
    public void mousePressed(MouseEvent e) {
        startingPoint = e.getPoint();

        if (e.getButton() == MouseEvent.BUTTON1) {
            int i = med.getDeviceAtPosition(startingPoint);
            if (i != -1) {
                slotDevice = med.getDeviceAt(i);

                med.setSelectedSlot(slotDevice);
            }
        }
    }
        @Override
        public void mouseDragged (MouseEvent e){

         selectedSlot = med.getSelectedSlot();

       // selectedSlot.setAngle(startingPoint.getX());

            //med.addSlotElements(selectedSlot);
        }

        @Override
        public void mouseReleased (MouseEvent e){
            // selectedSlot = med.getSelectedSlot();
            selectedSlot.setAngle(startingPoint.getX());
            med.addSlotElement(selectedSlot);
        }
    }

