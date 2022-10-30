package app.gui.view;

import app.gui.controller.EditTextListener;
import app.repository.element.SlotDevice;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextSlotView extends JDialog {

    String text = "no text";
    SlotDevice mySlot;
    JTextArea textArea;

    public TextSlotView(SlotDevice selectedSlot){
        this.mySlot = selectedSlot;

        Dimension size = new Dimension(600,300);
        int windowWidth = size.width;
        int windowHeight = size.height;
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        setTitle("Text slot");

        JPanel TPanel = new JPanel();
        TPanel.setPreferredSize(new Dimension(windowWidth/2, windowHeight));
        TPanel.setLayout(new BorderLayout(20,20));

        JButton textButton = new JButton("Edit Text");
        textButton.addActionListener(new EditTextListener());

        TPanel.add(textButton, BorderLayout.NORTH);

        textArea = new JTextArea(text,10,10);
        textArea.setText(readFile(mySlot.getFile()));
        mySlot.setText(readFile(mySlot.getFile()));
        textArea.setEditable(false);

        TPanel.add(textArea);

        add(TPanel);
    }

    public String readFile(File file){

        String text = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(mySlot.getFile().getAbsolutePath()));

            String line = br.readLine();
            text = line;

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fajl nije pronadjen");
        } catch (IOException e) {
            System.out.println("I/O exception");
        }

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public String getText() {
        return text;
    }
}
