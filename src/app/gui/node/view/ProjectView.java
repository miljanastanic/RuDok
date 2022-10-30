package app.gui.node.view;

import app.gui.view.MainFrame;
import app.observer.ISubscriber;
import app.repository.Document;
import app.repository.Project;
import app.repository.node.RuNode;

import javax.swing.*;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private Project project;
    private String name;

    public ProjectView(Project project) {
        this.project = project;
        this.project.addSubscriber(this);

        for(RuNode document : project.getChildren()){
            DocumentView documentView = new DocumentView((Document) document, project);
        }

        this.setName(project.getName());

    }


    public void makeProjectView(){

    }

    @Override
    public void update(Object notification) {

        if (notification instanceof Project){

            System.out.println("updateuje se proj view");
            Project newProject = (Project) notification;
            this.setName(newProject.getName());
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
            return;
        }

        }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
