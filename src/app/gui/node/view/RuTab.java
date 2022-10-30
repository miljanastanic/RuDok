package app.gui.node.view;

import app.gui.node.controller.XListener;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;

public class RuTab extends JPanel {

    private Component tab;
    private String title;
    private String name;

    public RuTab(final Component tab, String title, Icon icon) {
        this.tab = tab;
        this.title = title;
        this.name = tab.getName();
        setOpaque(false);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        setLayout(flowLayout);

        JLabel jLabel = new JLabel(title);
        jLabel.setIcon(icon);
        add(jLabel);

        JButton button = new JButton(MetalIconFactory.getInternalFrameCloseIcon(14));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addMouseListener(new XListener(tab));
        add(button);

    }

    public String getTitle() {
        return title;
    }

    public Component getTab() {
        return tab;
    }

    @Override
    public String toString() {
        return "RuTab{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
