package dsw.rudok.app;

import dsw.rudok.app.core.ApplicationFramework;
import dsw.rudok.app.core.Gui;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.SwingGui;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.repository.RepositoryImpl;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance==null){
            instance = new AppCore();
        }
        return instance;
    }


    public void run(){
        this.gui.start();
    }

    public static void main(String[] args) {
        Repository repository = new RepositoryImpl();
        Gui gui = new SwingGui(repository);
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui, repository);
        appCore.run();

    }




}
