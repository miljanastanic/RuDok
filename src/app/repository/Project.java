package app.repository;

import app.repository.node.RuNode;
import app.repository.node.RuNodeComposite;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Project extends RuNodeComposite implements Serializable {


    private static final long serialVersionUID = 4720293973156888970L;
    public static int documentCount = 1;
    private File projectFile;
    private transient boolean changed;
    private ArrayList<Document> documents = new ArrayList<>();



    public Project(String name, RuNode parent) {
        super(name, parent);
        this.changed=false;
        this.projectFile=null;
    }

    @Override
    public void addChild(RuNode child) {
        if (child != null && child instanceof Document) {
            Document document = (Document) child;
            if (!this.getChildren().contains(document)) {
                this.getChildren().add(document);
                documents.add(document);
                this.notifySubscriber("makeDocTab");
            }
        }
    }

    public String toString() {
        return ((changed ? "* " : "") + this.getName());
    }

    @Override
    public int getCount() {
        return documentCount;
    }

    @Override
    public void increaseCount() {
        documentCount++;
    }

    public boolean isChanged() {
        return changed;
    }


    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;

            //((RuTreeItem)(MainFrame.getInstance().getTree().getLastSelectedPathComponent())).setName(getName() + "*");
           // this.setName(getName() + "*");
            //SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public int getDocumentCount() {
        return documents.size();
    }

    public File getProjectFile() {
        return projectFile;
    }


    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

}

