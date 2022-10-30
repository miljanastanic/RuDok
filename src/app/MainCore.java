package app;

import app.core.*;
import app.eventHandler.EventHandlerImp;
import app.gui.MyGui;
import app.repository.RepositoryImp;
import app.slotHandler.SlotHandlerImp;

public class MainCore extends ApplicationFramework {

    private static MainCore instance;

    private MainCore(){
    }


    public static void main(String[] args) {
        Repository repository = new RepositoryImp();
        GUI gui = new MyGui(repository);
        EventHandler eventHandler = new EventHandlerImp();
        ApplicationFramework appCore = MainCore.getInstance();
        SlotHandler slotHandler = new SlotHandlerImp();
        appCore.initialise(gui, repository, eventHandler,slotHandler);
        appCore.run();
    }

    public static EventHandler getEventHandler() {
    return instance.eventHandler;
    }

    public static SlotHandler getSlotHandler() { return instance.slotHandler; }


    @Override
    public void run() {
        this.gui.start();
    }

    public static MainCore getInstance(){
        if(instance==null){
            instance = new MainCore();
        }
        return instance;
    }
}
