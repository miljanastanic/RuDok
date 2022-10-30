package app.state;

import app.gui.node.view.Handles;
import app.repository.Page;
import app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State {
    private Page med;
    private Handles handles = null;

    public SelectState(Page med) {
        this.med = med;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton() == MouseEvent.BUTTON1) {
            int i = med.getDeviceAtPosition(position);
            if (i != -1) {
                SlotDevice slotDevice = med.getDeviceAt(i);

                med.setSelectedSlot(slotDevice);
                med.addSelectedSlotToList(slotDevice);

              System.out.println("selektovao je " + slotDevice);

              slotDevice.setPaint(Color.GREEN);
              med.addSlotElement(slotDevice);
            }else{
                for (SlotDevice device: med.getSelectedSlots()){
                    device.setPaint(Color.RED);
                }
                med.getSelectedSlots().clear();
                med.notifySubscriber(med.getSelectedSlot());

            }


            }
        }
    }

    /*@Override
    public void mouseMoved(MouseEvent e) {
        Point2D position = e.getPoint();
        med.setMouseCursor(position);
    }

    */
