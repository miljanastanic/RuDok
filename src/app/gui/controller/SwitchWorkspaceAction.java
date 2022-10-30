package app.gui.controller;

import app.gui.node.view.DocumentView;
import app.gui.node.view.PageView;
import app.gui.view.MainFrame;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class SwitchWorkspaceAction extends AbstractManagerAction {

    public SwitchWorkspaceAction() {
      //  putValue(SMALL_ICON, loadIcon("Images/share.png"));
        putValue(NAME, "Switch WS");
        putValue(SHORT_DESCRIPTION, "Switch WS");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new TextFileFilter());

        ArrayList<String> paths = new ArrayList<>();

        if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            try {
                BufferedReader br = new BufferedReader(new FileReader(jfc.getSelectedFile()));

                String line = br.readLine();

                while (line != null) {
                    paths.add(line);

                    line = br.readLine();
                }

                br.close();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            for (String curr : paths) {
                try {
                    ObjectInputStream os = new ObjectInputStream(new FileInputStream(curr));

                    Project p = null;
                    try {
                        p = (Project) os.readObject();
                    } catch (ClassNotFoundException el) {
                        el.printStackTrace();
                    }


                    MainFrame.getInstance().getRuTree().addProject(p);

                    for (Document d : p.getDocuments()) {

                        DocumentView documentView = new DocumentView(d, (Project) d.getParent());

                        String docName = d.getName();
                        String projName = p.getName();

                        MainFrame.getInstance().addMyTabToTabbedPane(documentView, projName + docName);

                        for (Page page : d.getPages()) {
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
}
