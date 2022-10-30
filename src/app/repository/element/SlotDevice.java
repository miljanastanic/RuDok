package app.repository.element;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

public abstract class SlotDevice extends SlotElement {

    protected Dimension size;
    private Dimension oldSize = null;
    protected Point2D position;
    private Point2D oldPosition = null;
    protected double angle = 0;
    private String type = "";
    private File file = null;
    private String text = "";
    private boolean changed = false;

   /* public SlotDevice(Stroke stroke, Paint paint, String name, Color strokeColor, Dimension size,
                      Point2D position) {
        super(stroke, paint, name, strokeColor);

        this.size=size;
        this.position=position;
    }

    */
    public SlotDevice(String name, Dimension size, Point2D position, double angle, Color paint) {
        super(paint, name);
        this.angle = angle;
        this.size=size;
        this.position=position;
        this.paint = paint;
        setOldPosition(position);
        setOldSize(size);
    }


    public SlotDevice(Stroke stroke, String name, Color paint) {
        super(paint, name);
    }

    public void writeInFile(String text){

        try {
            PrintWriter out = new PrintWriter(file.getAbsolutePath());
            out.println(text);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fajl nije ucitan");
        }

    }

    public void setText(String text) {
        this.text = text;
        setChanged(true);
    }

    public void setOldPosition(Point2D oldPosition) {

        if (!(oldPosition == null)){
            this.oldPosition = oldPosition;
        }else {
            this.oldPosition = position;
        }
    }

    public Point2D getOldPosition() {
        return oldPosition;
    }

    public Dimension getOldSize() {
        return oldSize;
    }

    public void setOldSize(Dimension oldSize) {

        if (!(oldSize == null)){
            this.oldSize = oldSize;
        }else{
            this.oldSize = size;
        }
    }


    public String getText() {
        return text;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getX(){
        return position.getX();
    }

    public double getY(){
        return position.getY();
    }


}
