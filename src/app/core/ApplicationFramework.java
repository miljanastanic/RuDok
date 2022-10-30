package app.core;

import app.repository.Slot;

public abstract class ApplicationFramework {

    protected GUI gui;
    protected Repository repository;
    protected EventHandler eventHandler;
    protected SlotHandler slotHandler;

    public abstract void run();

    public void initialise(GUI gui, Repository repository, EventHandler eventHandler, SlotHandler slotHandler){
        this.gui = gui;
        this.repository = repository;
        this.eventHandler = eventHandler;
        this.eventHandler.addSubscriber(gui);
        this.slotHandler = slotHandler;
    }
    
}
