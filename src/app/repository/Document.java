package app.repository;

import app.repository.node.RuNode;
import app.repository.node.RuNodeComposite;

import java.io.Serializable;
import java.util.ArrayList;

public class Document extends RuNodeComposite implements Serializable {

    public static int pageCount = 1;
    private ArrayList<Page> pages = new ArrayList<>();

    public Document(String name, RuNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child != null && child instanceof Page) {
            Page page = (Page) child;
            if (!this.getChildren().contains(page)) {
                this.getChildren().add(page);
                pages.add(page);
                this.notifySubscriber(page);
            }
        }
    }


    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public void increaseCount() {
        pageCount++;
    }


    public ArrayList<Page> getPages() {
        return pages;
    }
}
