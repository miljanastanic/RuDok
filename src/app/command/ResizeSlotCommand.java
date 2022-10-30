package app.command;

import app.gui.node.view.graphics.painters.CirclePainter;
import app.gui.node.view.graphics.painters.RectanglePainter;
import app.gui.node.view.graphics.painters.TrianglePainter;
import app.repository.Page;
import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;
import app.repository.element.TriangleElement;

import java.awt.*;
import java.util.ArrayList;

public class ResizeSlotCommand extends AbstactCommand{
    protected Page model;
    private ArrayList<SlotDevice> selectedSlots;
    private ArrayList<Dimension> oldSizes;
    private ArrayList<Dimension> sizes;

    public ResizeSlotCommand(Page model) {

        this.model = model;
        selectedSlots = new ArrayList<>(model.getSelectedSlots());
        oldSizes = new ArrayList<>();
        sizes = new ArrayList<>();

        for(SlotDevice p: selectedSlots) {
            oldSizes.add(p.getOldSize());
        }
    }

    @Override
    public void doCommand() {

        for(int i = 0; i <selectedSlots.size(); i++) {

            SlotDevice s = selectedSlots.get(i);
            s.setSize(s.getSize());
            sizes.add(s.getSize());
            s.setSize(sizes.get(i));

            if(s instanceof RectangleElement)
                s.setPainter(new RectanglePainter(s, s.getPosition()));
            else if(s instanceof TriangleElement)
                s.setPainter(new TrianglePainter(s, s.getPosition()));
            else
                s.setPainter(new CirclePainter(s, s.getPosition()));
        }
        model.notifySubscriber(this);
    }

    @Override
    public void undoCommand() {

        for(int i = 0; i < selectedSlots.size(); i++) {

            SlotDevice s = selectedSlots.get(i);
            s.setSize(oldSizes.get(i));

            if(s instanceof RectangleElement)
                s.setPainter(new RectanglePainter(s, s.getPosition()));
            else if(s instanceof TriangleElement)
                s.setPainter(new TrianglePainter(s, s.getPosition()));
            else
                s.setPainter(new CirclePainter(s, s.getPosition()));
            System.out.println(s.getPosition().toString());
        }
        model.notifySubscriber(this);
    }
   /* protected Page model;
    protected Point2D lastPosition;
    protected SlotDevice device;
    protected ArrayList<SlotDevice> selectedModels;
    protected String name;
    protected SlotFactory factory;

    @Override
    public void doCommand() {

    }

    @Override
    public void undoCommand() {
        model.removeSlotElements(device);
        model.clearSelectedSlotFromList(device);
    }

    */
}
