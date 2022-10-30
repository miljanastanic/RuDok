package app.gui.view;

import app.MainCore;
import app.core.EventHandler;
import app.eventHandler.Type;
import app.gui.controller.DiagramFileFilter;
import app.gui.controller.TextFileFilter;
import app.repository.Project;
import app.repository.Workspace;
import app.repository.node.RuNode;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class WorkspaceSaving extends WindowAdapter {

    private JFrame frame;
    private EventHandler eventHandler = MainCore.getEventHandler();
    private Workspace workspace = MainFrame.getInstance().getWorkspace();

    public WorkspaceSaving(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        Object[] choice = {"Yes","No","Cancel"};

        int answer = JOptionPane.showOptionDialog(frame, "Da li zelite da sacuvate trenutni Workspace", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

        if(answer == JOptionPane.YES_OPTION) {

                    JFileChooser jfc = new JFileChooser();
                    jfc.setFileFilter(new TextFileFilter());

                        File workspaceFile = workspace.getFile();

                        if (workspaceFile == null) {
                            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                                workspaceFile = jfc.getSelectedFile();
                                workspace.setFile(workspaceFile);

                                for (RuNode p : workspace.getChildren()) {
                                    File projectFile = ((Project) p).getProjectFile();
                                    if (projectFile == null) {
                                        eventHandler.generateError(Type.SACUVAJ_PROJEKAT);
                                        return;
                                    }
                                }

                            }else {
                                return;
                            }
                        }
                        MainFrame.getInstance().getWorkspace().writeInWFile(workspaceFile);


                    //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //System.exit(0);
        }
        else if(answer == JOptionPane.NO_OPTION) {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //System.exit(0);
        }
        else if(answer == JOptionPane.CANCEL_OPTION) {
            return;
        }
        }
    }


