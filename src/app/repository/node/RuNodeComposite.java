package app.repository.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode implements Serializable {

    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.children = new ArrayList<RuNode>();
    }

    public RuNodeComposite(String name, RuNode parent, List<RuNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(RuNode child);
    public abstract int getCount();
    public abstract void increaseCount();

    public void removeChild(RuNode child){
        if(child != null && this.getChildren().contains(child)) {
            this.getChildren().remove(child);
            this.notifySubscriber(child.getName());
        }
    }

    public RuNode getChildByName(String name) {
        for (RuNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }


    public List<RuNode> getChildren() {
        return children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }
}
