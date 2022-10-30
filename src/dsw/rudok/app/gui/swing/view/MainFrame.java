package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.controller.ActionManager;
import dsw.rudok.app.gui.swing.tree.RuTree;
import dsw.rudok.app.gui.swing.tree.view.RuTreeImplementation;
import dsw.rudok.app.gui.swing.tree.view.RuTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class MainFrame extends JFrame {


    private static MainFrame instance;
    private ActionManager actionManager;
    private Repository documentRepository;
    private RuTree tree;
    private JMenuBar menu;
    private JToolBar toolBar;
    private JTree workspaceTree;

    private MainFrame(){

    }

    private void initialise() {
        actionManager = new ActionManager();
    }

    public void initialiseWorkspaceTree() {
        tree = new RuTreeImplementation();
        workspaceTree = tree.generateTree(documentRepository.getWorkspace());
        initialiseGUI();
    }

    private void initialiseGUI() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok app");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        JPanel desktop = new JPanel();

        JScrollPane scroll=new JScrollPane(workspaceTree);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);



    }

    public static MainFrame getInstance(){
        if(instance==null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
    public void setDocumentRepository(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public JTree getWorkspaceTree() {
        return workspaceTree;
    }
    public void setWorkspaceTree(JTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }
    public RuTree getTree() {
        return tree;
    }
}
