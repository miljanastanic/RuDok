package app.repository;

import app.core.Repository;

public class RepositoryImp implements Repository {

    private Workspace root;

    public RepositoryImp() {
        root = new Workspace("Workspace");
    }

    @Override
    public Workspace getWorkspace() {
        return root;
    }

    public Workspace getRoot() {
        return root;
    }

    public void setRoot(Workspace root) {
        this.root = root;
    }
}