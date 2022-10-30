package app.gui.view;

import app.gui.controller.EditImageListener;
import app.gui.controller.EditTextListener;
import app.gui.controller.ImageButtonListener;
import app.gui.controller.TextButtonListener;
import app.repository.element.SlotDevice;

import javax.swing.*;
import java.awt.*;

public class SlotDetailsDialog extends JDialog {

    String imagePath = "";
    String text = "no text";
    SlotDevice mySlot;
    JTextArea textArea;

    public SlotDetailsDialog(Frame owner, boolean modal, SlotDevice selectedSlot) {
        super(owner, modal);
        this.mySlot = selectedSlot;
        System.out.println(selectedSlot.toString());


        if(mySlot.getType().equals("")){

            Dimension size = new Dimension(600,300);
            int windowWidth = size.width;
            int windowHeight = size.height;
            setSize(windowWidth,windowHeight);
            setLocationRelativeTo(owner);
            setTitle("Choose type");

            JButton imageButton = new JButton("Image");
            imageButton.addActionListener(new ImageButtonListener());
            JButton textButton = new JButton("Text");
            textButton.addActionListener(new TextButtonListener());

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
            panel.add(imageButton, BorderLayout.WEST);
            panel.add(textButton,BorderLayout.EAST);

            add(panel);

        }

      /*  if(mySlot.getType().equals("text")){

            //TextSlotView textSlotView = new TextSlotView(mySlot);

           /* Dimension size = new Dimension(600,300);
            int windowWidth = size.width;
            int windowHeight = size.height;
            setSize(windowWidth,windowHeight);
            setLocationRelativeTo(owner);
            setTitle("Text slot");

            JPanel TPanel = new JPanel();
            TPanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
            TPanel.setLayout(new BorderLayout(20,20));

            JButton textButton = new JButton("Edit Text");
            textButton.addActionListener(new EditTextListener());

            TPanel.add(textButton, BorderLayout.NORTH);

            textArea = new JTextArea(text,10,10);
            textArea.setText(mySlot.getText());
            textArea.setEditable(false);

            TPanel.add(textArea);

            add(TPanel);

            */


        }

/*
        if(mySlot.getType().equals("image")){

            if(mySlot.getFile()!=null){
                setImagePath(mySlot.getFile().getPath());
            }

            Dimension size = new Dimension(600,300);
            int windowWidth = size.width;
            int windowHeight = size.height;
            setSize(windowWidth,windowHeight);
            setLocationRelativeTo(owner);
            setTitle("Image slot");

            JPanel IPanel = new JPanel();
            IPanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
            IPanel.setLayout(new BorderLayout(20,20));

            JButton IButton = new JButton("Edit Image");
            IButton.addActionListener(new EditImageListener());

            IPanel.add(IButton, BorderLayout.NORTH);

            JLabel label = new JLabel(new ImageIcon(imagePath));
            label.setPreferredSize(new Dimension(80, 80));
            label.setHorizontalAlignment(0);
            label.setVerticalAlignment(0);
            IPanel.add(label);


            add(IPanel);

        }




    }

 */


    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
