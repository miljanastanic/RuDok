package app.gui.controller;

import app.MainCore;
import app.gui.node.view.DocumentView;
import app.gui.node.view.PageView;
import app.gui.view.MainFrame;
import app.observer.ISubscriber;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;
import app.repository.element.SlotDevice;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class OpenAction extends AbstractManagerAction {

    public OpenAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/open1.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new DiagramFileFilter());

       // List<Document> documentList = new ArrayList<>();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project p = null;
                try {
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException el) {
                    el.printStackTrace();
                }


                MainFrame.getInstance().getRuTree().addProject(p);

                for(Document d : p.getDocuments()){

                    DocumentView documentView = new DocumentView(d, (Project) d.getParent());

                    String docName = d.getName();
                    String projName = p.getName();

                    MainFrame.getInstance().addMyTabToTabbedPane(documentView,projName + docName);

                   // documentList.add(d);
                    //treba dodati u projekat stare dokumente, ovo ispod ne radi
                    //p.addChild(d);

                    for(Page page : d.getPages()){
                        PageView pageView = new PageView(page);
                        pageView.setPage(page);
                    }

                }

            } catch (FileNotFoundException e1) {
                System.out.println("file not found");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("i/o exception");
                e1.printStackTrace();
            }


        }


    }
    }

