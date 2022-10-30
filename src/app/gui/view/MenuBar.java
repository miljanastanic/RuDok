package app.gui.view;


import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(){

        JMenu MFile = new JMenu("File");
        JMenu MEdit = new JMenu("Edit");
        JMenu MSource = new JMenu("Source");

        MFile.add(MainFrame.getInstance().getActionManager().getAddButton());
        MFile.add(MainFrame.getInstance().getActionManager().getDeleteButton());
        MFile.addSeparator();
        MFile.add(MainFrame.getInstance().getActionManager().getAboutButton());
        MFile.addSeparator();
        MFile.add(MainFrame.getInstance().getActionManager().getExitButton());

        add(MFile);
        add(MEdit);
        add(MSource);

        setVisible(true);
    }


}
