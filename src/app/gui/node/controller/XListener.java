package app.gui.node.controller;

import app.gui.node.view.RuTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class XListener implements MouseListener {

    private Component tab;

    public XListener(Component tab) {
        this.tab = tab;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            RuTabbedPane tabbedPane = (RuTabbedPane) clickedButton.getParent().getParent().getParent();
            tabbedPane.remove(tab);

            for(RuTab ruTab : tabbedPane.getRuTabs()){
                if(ruTab.getName().equals(tab.getName())){
                    System.out.println("rutab name " + ruTab.getName());
                    tabbedPane.getRuTabs().remove(ruTab);
                    System.out.println("tab removed: " + ruTab.toString());
                    break;
                }
            }

            System.out.println(tabbedPane.getRuTabs().toString());

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            clickedButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            clickedButton.setBorder(BorderFactory.createLineBorder(Color.lightGray,3));
        }
    }
}
