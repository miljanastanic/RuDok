package app.command;

import app.factory.CircleFactory;
import app.factory.RectangleFactory;
import app.factory.TriangleFactory;
import app.repository.Page;
import app.repository.element.SlotDevice;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class AddSlotCommand extends AbstactCommand{

    protected Page model;
    protected Point2D lastPosition;
    protected SlotDevice device;
    protected ArrayList<SlotDevice> selectedModels;
    protected String name;
    protected CircleFactory circleFactory;
    protected RectangleFactory rectangleFactory;
    protected TriangleFactory triangleFactory;

    public AddSlotCommand(Page model, Point2D lastPosition, ArrayList<SlotDevice> selectedModels, String name) {
        this.model = model;
        this.lastPosition = lastPosition;
        //this.device = device;
        this.selectedModels = selectedModels;
        this.name = name;
        this.circleFactory = new CircleFactory();
        this.rectangleFactory = new RectangleFactory();
        this.triangleFactory = new TriangleFactory();
    }

    @Override
    public void doCommand() {
        if(device == null){
            if (name.equals("Triangle")){
                device = triangleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);
            }
            else if (name.equals("Circle")){
                device = circleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);
            }
            else if(name.equals("Rectangle")){
                device = rectangleFactory.makeSlot(lastPosition);
                model.addSlotElement(device);
            }
        }else
            model.addSlotElement(device);
    }

    @Override
    public void undoCommand() {
    device.setPaint(Color.RED);
    selectedModels.remove(device);
    model.removeSlotElements(device);

    }
}
