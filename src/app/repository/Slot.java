package app.repository;

import app.repository.node.RuNode;

import java.io.Serializable;

public class Slot extends RuNode implements Serializable {

    public Slot(String name, RuNode parent) {
        super(name, parent);
    } //point dimension.

}
