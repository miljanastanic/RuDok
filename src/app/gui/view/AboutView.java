package app.gui.view;



import javax.swing.*;
import java.awt.*;

public class AboutView extends JDialog {

    public AboutView(Frame owner, boolean modal) {
        super(owner, modal);

        Dimension size = new Dimension(500,250);
        int windowWidth = size.width;
        int windowHeight = size.height;
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(owner);
        setTitle("About View");


        JPanel APanel = new JPanel();
        APanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
        APanel.setLayout(new BorderLayout(20,20));


        JLabel ALabel = new JLabel(new ImageIcon("Images/aleksandra.png"));
        APanel.add(ALabel, BorderLayout.NORTH);

        JTextField AName = new JTextField("Aleksandra Petrovic RN 86/20");
        AName.setHorizontalAlignment(SwingConstants.CENTER);
        AName.setPreferredSize(new Dimension(50,50));
        AName.setEditable(false);
        APanel.add(AName, BorderLayout.SOUTH);

        add(APanel, BorderLayout.WEST);

        JPanel MPanel = new JPanel();
        MPanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
        MPanel.setLayout(new BorderLayout(20,20));

        JLabel MLabel = new JLabel(new ImageIcon("Images/miljana.png"));
        MPanel.add(MLabel, BorderLayout.NORTH);

        JTextField MName = new JTextField("Miljana Stanic RN 58/19");
        MName.setHorizontalAlignment(SwingConstants.CENTER);
        MName.setPreferredSize(new Dimension(50,50));
        MName.setEditable(false);
        MPanel.add(MName, BorderLayout.SOUTH);


        add(MPanel, BorderLayout.EAST);

    }

}
