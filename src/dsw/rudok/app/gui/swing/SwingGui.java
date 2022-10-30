package dsw.rudok.app.gui.swing;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.view.MainFrame;
import dsw.rudok.app.core.Gui;

import javax.swing.*;

public class SwingGui implements Gui {

    private MainFrame instance;
    private Repository documentRepository;

    public SwingGui(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setDocumentRepository(documentRepository);
        instance.initialiseWorkspaceTree();
        instance.setVisible(true);
    }


}
