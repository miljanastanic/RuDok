package app.repository;

import app.repository.node.RuNode;
import app.repository.node.RuNodeComposite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Workspace extends RuNodeComposite implements Serializable {

    public Workspace(String name) {
        super(name, null);
    }
    public static int projectCount = 1;
    private File file = null;


    @Override
    public void addChild(RuNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
                this.notifySubscriber(child);
            }
        }
    }

    public void writeInWFile(File file){

        try {
            PrintWriter out = new PrintWriter(file.getAbsolutePath());

            for (RuNode child: this.getChildren()) {
                out.println(((Project)child).getProjectFile().getAbsolutePath());
            }
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fajl nije ucitan");
        }

    }

    @Override
    public int getCount() {
        return projectCount;
    }

    @Override
    public void increaseCount() {
        projectCount++;
    }

    public Workspace getWorkspace(){
        return this;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}