package app.core;

import app.repository.Workspace;

public interface Repository {

    Workspace getWorkspace();
    void setRoot(Workspace root);


}
