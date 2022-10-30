package app.gui.node.controller;

import app.gui.node.view.RuTab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RuTabbedPane extends JTabbedPane {

    private List<RuTab> ruTabs = new ArrayList<>();

    public RuTabbedPane(){
        super();
    }

    @Override
    public void addTab(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
        RuTab ruTab =  new RuTab(component, title, icon);
        ruTabs.add(ruTab);
        setTabComponentAt(count, ruTab);
    }

    public List<RuTab> getRuTabs() {
        return ruTabs;
    }
}
