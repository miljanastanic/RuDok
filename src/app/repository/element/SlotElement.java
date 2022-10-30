package app.repository.element;

import app.gui.node.view.graphics.painters.ElementPainter;
import app.repository.Slot;
import app.serialization.SerializableStrokeAdapter;

import java.awt.*;
import java.io.Serializable;

public abstract class SlotElement implements Serializable {

   // protected SerializableStrokeAdapter stroke; //stroke odvojiti u zasebnu klasu!!!!
   // protected Stroke stroke;
    protected Color paint;
    protected String name;
   // protected Color strokeColor;

    protected ElementPainter elementPainter;

    public SlotElement( Color paint, String name){
        //this.stroke= (SerializableStrokeAdapter) stroke;
        //this.stroke = stroke;
        this.paint = paint;
        this.name = name;

    }

    /*

    public SlotElement(String name, Color paint){
        this.name = name;
        this.paint = paint;
    }
    */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ElementPainter getPainter() {
        return elementPainter;
    }

    public void setPainter(ElementPainter elementPainter) {
        this.elementPainter = elementPainter;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Color paint) {
        this.paint = paint;
    }
/*
    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = (SerializableStrokeAdapter) stroke;
    }

    public String toString(){
        return name;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    */
}
