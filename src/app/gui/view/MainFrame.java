package app.gui.view;

import app.core.Repository;
import app.core.SlotHandler;
import app.eventHandler.Error;
import app.gui.controller.ActionManager;
import app.gui.node.controller.RuTabbedPane;
import app.gui.node.view.DocumentView;
import app.gui.node.view.PageView;
import app.gui.node.view.RuTab;
import app.gui.tree.RuTree;
import app.gui.tree.view.RuTreeImplementation;
import app.repository.Document;
import app.repository.Project;
import app.repository.Workspace;
import app.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private RuTree ruTree;
    private JTree tree;
    private Repository repository;
    private RuTabbedPane tabbedPane;
    private Project project;
    private Workspace workspace;
    private JScrollPane documentPanel;


    private MainFrame() {
    }

    private void makeFrame(){

        actionManager = new ActionManager();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(screenWidth/2, screenHeight/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok");

        JScrollPane panelTree = new JScrollPane(tree);
        panelTree.setMinimumSize(new Dimension(150,150));

        documentPanel = new JScrollPane(tabbedPane);
        panelTree.setMinimumSize(new Dimension(150,130));


        JSplitPane panelSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelTree, documentPanel);

        getContentPane().add(panelSplit,BorderLayout.CENTER);
        panelSplit.setDividerLocation(200);
        panelSplit.setOneTouchExpandable(true);

        addWindowListener(new WorkspaceOpening(this));
        addWindowListener(new WorkspaceSaving(this));

        MenuBar menuBar = new MenuBar();
        this.setJMenuBar(menuBar);

        ToolBar toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);

        StateBar stateBar = new StateBar();
        add(stateBar, BorderLayout.EAST);

    }

    public static MainFrame getInstance(){

        if(instance == null){
            instance = new MainFrame();

        }

        return instance;

    }

    public void initialiseWorkspace(){
        ruTree = new RuTreeImplementation();
        tree = ruTree.generateTree(repository.getWorkspace());
        this.createTabbedPane();
        makeFrame();

    }

    private void createTabbedPane() {
        this.tabbedPane = new RuTabbedPane();
    }

    public void addMyTabToTabbedPane(DocumentView documentView, String name) {
        ImageIcon icon = createImageIcon("Images/tabIcon.png",true);

        boolean exists = false;

        for(RuTab ruTab : tabbedPane.getRuTabs()){
            if(ruTab.getTitle().equals(name)){
                exists = true;
                System.out.println("postoji takav tab");
            }
        }
        if(!exists) {
            System.out.println("ne postoji takav tab");
            tabbedPane.addTab(name, icon, documentView, "");
        }

        System.out.println(tabbedPane.getRuTabs().toString());
    }

    protected static ImageIcon createImageIcon(String path, boolean scaleImage) {
        if (scaleImage) {
            ImageIcon imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            return imageIcon;

        } else {
            return new ImageIcon(path);
        }
    }

    public RuTabbedPane getTabbedPane(){ return tabbedPane; }
    public ActionManager getActionManager() {
        return actionManager;
    }
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
    public Repository getRepository() { return this.repository; }
    public JTree getTree() {
        return tree;
    }
    public void setTree(JTree tree) {
        this.tree = tree;
    }
    public RuTree getRuTree() {
        return ruTree;
    }
    public Workspace getWorkspace(){return repository.getWorkspace();}

    public JScrollPane getDocumentPanel() { return documentPanel; }

    public void showError(Error notification) {
      System.out.println(notification.getMessage());
      JOptionPane.showMessageDialog(this, notification.getMessage(),
              notification.getTitle(), JOptionPane.WARNING_MESSAGE);
    }
}
