package app.command;


import app.gui.node.view.graphics.painters.CirclePainter;
import app.gui.node.view.graphics.painters.RectanglePainter;
import app.gui.node.view.graphics.painters.TrianglePainter;
import app.repository.Page;
import app.repository.element.RectangleElement;
import app.repository.element.SlotDevice;
import app.repository.element.TriangleElement;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MoveSlotCommand extends AbstactCommand{

    private Page page;
    private ArrayList<SlotDevice> selectedSlots;
    private ArrayList<Point2D> oldPoints;
    private ArrayList<Point2D> points;

    public MoveSlotCommand(Page page) {
        this.page = page;
        selectedSlots = new ArrayList<>(page.getSelectedSlots());
        oldPoints = new ArrayList<>();
        points = new ArrayList<>();

        for(SlotDevice p: selectedSlots) {
            oldPoints.add(p.getOldPosition());
        }
    }

    @Override
    public void doCommand() {

        for(int i = 0; i < selectedSlots.size();i ++) {

            SlotDevice s = selectedSlots.get(i);
            s.setPosition(s.getPosition());
            points.add(s.getPosition());
            s.setPosition(points.get(i));

            if(s instanceof RectangleElement)
                s.setPainter(new RectanglePainter(s, s.getPosition()));
            else if(s instanceof TriangleElement)
                s.setPainter(new TrianglePainter(s, s.getPosition()));
            else
                s.setPainter(new CirclePainter(s, s.getPosition()));
        }
        page.notifySubscriber(this);
    }

    @Override
    public void undoCommand() {

        for(int i = 0; i < selectedSlots.size(); i++) {

            SlotDevice s = selectedSlots.get(i);
            s.setPosition(oldPoints.get(i));

            if(s instanceof RectangleElement)
                s.setPainter(new RectanglePainter(s, s.getPosition()));
            else if(s instanceof TriangleElement)
                s.setPainter(new TrianglePainter(s, s.getPosition()));
            else
                s.setPainter(new CirclePainter(s, s.getPosition()));
            System.out.println(s.getPosition().toString());
        }
        page.notifySubscriber(this);
    }
}