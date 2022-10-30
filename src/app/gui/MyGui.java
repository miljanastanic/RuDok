package app.gui;


import app.core.GUI;
import app.core.Repository;
import app.eventHandler.Error;
import app.gui.view.MainFrame;



public class MyGui implements GUI {

    private MainFrame instance;
    private Repository repository;

    public MyGui(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setRepository(repository);
        instance.initialiseWorkspace();
        instance.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Error){
            MainFrame.getInstance().showError((Error) notification);
        }
    }
}
