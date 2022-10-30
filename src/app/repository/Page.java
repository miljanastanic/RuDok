package app.repository;

import app.command.CommandManager;
import app.observer.IPublisher;
import app.observer.ISubscriber;
import app.repository.element.SlotDevice;
import app.repository.element.SlotElement;
import app.repository.node.RuNode;
import app.repository.node.RuNodeComposite;
import app.state.StateManager;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Page extends RuNodeComposite implements Serializable {
    //sve iz pageModela da ubacimo u Page i samim tim ih spojimo.

    protected ArrayList<SlotDevice> slotElements =new ArrayList <>();
    private transient StateManager stateManager= new StateManager(this);
    private transient List<ISubscriber> subscribers;
    private static int count=0;
    private SlotDevice selectedSlot;
    private ArrayList<SlotDevice> selectedSlots = new ArrayList<>();
    public static int slotCount = 1;
    private transient CommandManager commandManager = new CommandManager();

    public Page(String name, RuNode parent) {
        super(name, parent);
    }

    private Object readResolve(){
        subscribers = new ArrayList<ISubscriber>();
        return this;
    }

    @Override
    public void addChild(RuNode child) {
        if (child != null && child instanceof Slot) {
            Slot slot = (Slot) child;
            if (!this.getChildren().contains(slot)) {
                this.getChildren().add(slot);
            }
        }
    }

    public int getDeviceAtPosition(Point2D point) {
        for(int i=getDeviceCount()-1;i>=0;i--){
            SlotElement element = getDeviceAt(i);
            if(element.getPainter().elementAt((Point)point)){
                return i;
            }
        }
        return -1;
    }

    public int getDeviceCount(){
        return slotElements.size();
    }

    public SlotDevice getDeviceAt(int i){
        return slotElements.get(i);
    }

    public int getElementCount(){
        return slotElements.size();
    }

    public Iterator<SlotDevice> getDeviceIterator(){
        return slotElements.iterator();
    }

    public void addSelectedSlotToList(SlotDevice element){
        selectedSlots.add(element);
        notifySubscriber(element);
    }

    public void clearSelectedSlotFromList(SlotDevice element){
        selectedSlots.remove(element);
        notifySubscriber(element);
    }

    public void isSelectedInList(SlotDevice element){
        selectedSlots.contains(element);
        notifySubscriber(element);
    }

    public void addSlotElement(SlotDevice element){
        if(!slotElements.contains(element)) {
            slotElements.add(element);
        }
        notifySubscriber(element);
    }

    public void removeSlotElements(SlotDevice element){
               slotElements.remove(element);
               notifySubscriber(element);
    }

    public ArrayList<SlotDevice> getSelectedSlots() {
        return selectedSlots;
    }

    public void setSelectedSlots(ArrayList<SlotDevice> selectedSlots) {
        this.selectedSlots = selectedSlots;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(subscribers==null){
            subscribers = new ArrayList<ISubscriber>();
        }
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscriber!=null){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber(Object notification) {
        if(subscribers == null || subscribers.isEmpty() || notification == null){
            return;
        }

        for (ISubscriber subscriber: subscribers) {
            subscriber.update(notification);
        }
    }

    public void startCircleState() {
        stateManager.setCircleState();
    }

    public void startRectangleState(){ stateManager.setRectangleState(); }

    public void startTriangleState(){ stateManager.setTriangleState(); }

    public void startSelectState(){ stateManager.setSelectState();}

    public void startMoveState(){stateManager.setMoveState();}

    public void startResizeState(){stateManager.setResizeState();}

    public void startRotateState(){stateManager.setRotateState();}

    public void startDeleteState(){stateManager.setDeleteState();}

    public void startLassoState(){stateManager.setLassoState();}



    public StateManager getStateManager() {
        return stateManager;
    }

    public ArrayList<SlotDevice> getSlotElements() {
        return slotElements;
    }

    @Override
    public int getCount() {
        return slotCount;
    }

    @Override
    public void increaseCount() {
        slotCount++;
    }

    public SlotDevice getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(SlotDevice selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void deleteSelectedSlots() {

        slotElements.removeAll(selectedSlots);
        selectedSlots.clear();
        notifySubscriber(selectedSlots);

    }

    public void addSlotElements(ArrayList<SlotDevice> selectedSlots) {
        if(!slotElements.contains(selectedSlots)) {
            slotElements.addAll(selectedSlots);
        }
        notifySubscriber(selectedSlots);
    }
}
