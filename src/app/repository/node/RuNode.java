package app.repository.node;

import app.observer.IPublisherImp;

import java.io.Serializable;

public abstract class RuNode extends IPublisherImp implements Serializable {

    private String name;
    private RuNode parent;
    private String oldName;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof RuNode) {
            RuNode otherObj = (RuNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;

    }

    public RuNode getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setOldName(this.name);
        this.name = name;
        notifySubscriber(this);
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

}
