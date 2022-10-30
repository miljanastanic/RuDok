package app.gui.controller;

import app.MainCore;
import app.gui.view.MainFrame;
import app.repository.Project;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

import static app.eventHandler.Type.NIJE_PROJEKAT;

public class SaveAction extends AbstractManagerAction {

    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("desise1");
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new DiagramFileFilter());

        if (MainFrame.getInstance().getRuTree().getSelectedNode() instanceof Project) {

            RuNode project = MainFrame.getInstance().getRuTree().getSelectedNode();
            File projectFile = ((Project) project).getProjectFile();

            if (!((Project) project).isChanged()) {
                System.out.println("desise2");
                return;
            }


            if (((Project) project).getProjectFile() == null) {
                System.out.println("desise3");
                if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    projectFile = jfc.getSelectedFile();

                } else {
                    return;
                }

            }


            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                ((Project) project).setProjectFile(projectFile);
                ((Project) project).setChanged(false);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            MainCore.getEventHandler().generateError(NIJE_PROJEKAT);
        }
    }
}
