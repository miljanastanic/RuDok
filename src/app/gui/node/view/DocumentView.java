package app.gui.node.view;

import app.gui.node.controller.RuTabbedPane;
import app.gui.view.MainFrame;
import app.observer.ISubscriber;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;
import app.repository.node.RuNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentView extends JPanel implements ISubscriber {

    //to je prikaz otvorenog taba, odnosno ovde odlucujemo sta ce biti napisano na desnom panelu
    //kada otvorimo odredjeni tab
    //prikaz zavisi od selektovanog taba

    private Document document;
    private Project project;
    private PageView pageView;
    private JLabel label;
    private String name;
    private RuTabbedPane ruTabbedPane = MainFrame.getInstance().getTabbedPane();
    private boolean contains = false;
    private List<PageView> pageViews = new ArrayList<PageView>();

    public DocumentView(Document document, Project project) {
        this.document = document;
        this.document.addSubscriber(this);
        this.project=project;
        this.project.addSubscriber(this);

        for(RuNode node : document.getChildren()){
            Page page = (Page) node;
            pageView = new PageView(page);
            pageViews.add(pageView);
            this.add(pageView);
        }

        this.setName(project.getName() + " " + document.getName());

       MainFrame.getInstance().addMyTabToTabbedPane(this, name);

    }

    @Override
    public void update(Object notification) {

        if (notification instanceof Page){
            Page page = (Page) notification;
            PageView pageView = new PageView(page);
            this.add(pageView);
            MainFrame.getInstance().addMyTabToTabbedPane(this, name);
        }

        if (notification instanceof Project){
            Project newProject = (Project) notification;
            this.setName(newProject.getName() + " " + this.document.getName());
            MainFrame.getInstance().addMyTabToTabbedPane(this, name);
            return;
        }

        if (notification instanceof Document){
            Document newDocument = (Document) notification;
            this.setName(this.project.getName() + " " + newDocument.getName());

            for(RuTab ruTab : ruTabbedPane.getRuTabs()){
                if(ruTab.getName().equals(newDocument.getOldName())){
                    ruTab.setName(newDocument.getName());
                }

            }

            MainFrame.getInstance().addMyTabToTabbedPane(this, name);
            return;
        }


        if (notification instanceof String){
           String s = (String)notification;

           for(PageView pv : pageViews) {

               if (pv.getPage().getName().equals(s)) {
                   this.remove(pv);
                   MainFrame.getInstance().addMyTabToTabbedPane(this, name);
               }
           }

       }



    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
