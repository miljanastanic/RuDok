package app.gui.controller;

import app.gui.tree.model.RuTreeItem;
import app.gui.view.MainFrame;
import app.repository.Document;
import app.repository.Project;
import app.repository.Workspace;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ShareButton extends AbstractManagerAction {

    private List<String> listaProjekata= new ArrayList<>();

    public ShareButton() {
        putValue(SMALL_ICON, loadIcon("Images/share.png"));
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share document");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        RuNode document = MainFrame.getInstance().getRuTree().getSelectedNode();
        MainFrame mainFrame = MainFrame.getInstance();

        if(document instanceof Document) {

            for (RuNode node : MainFrame.getInstance().getWorkspace().getChildren()) {
                listaProjekata.add(node.getName());
            }

            String s = (String) JOptionPane.showInputDialog(mainFrame, "Izaberite projekat", "Input", JOptionPane.QUESTION_MESSAGE,
                    null, listaProjekata.toArray(), JOptionPane.INITIAL_SELECTION_VALUE_PROPERTY);

            System.out.println(document.getName());

            System.out.println(s);

            for (RuNode p : MainFrame.getInstance().getWorkspace().getChildren()) {
                if(p.getName().equals(s)){
                    System.out.println("isti su");
                    MainFrame.getInstance().getRuTree().shareNode(document, p);
                }
            }

        }

    }


}
