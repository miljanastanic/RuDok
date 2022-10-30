package app.gui.view;



import app.repository.Page;
import app.repository.element.SlotDevice;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLWriter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Writer;

public class TextEditorView extends JDialog{
    SlotDevice slot;
    private JToolBar toolBar = new JToolBar();
    JTextPane textPane = new JTextPane();

    public TextEditorView(Frame owner, SlotDevice mySlot) {
        this.slot = mySlot;
        this.setLocationRelativeTo(owner);
        this.add(textPane, BorderLayout.CENTER);
        this.add(toolBar,BorderLayout.NORTH);
        textPane.setText(slot.getText());
        JButton bold = new JButton(new StyledEditorKit.BoldAction());
        JButton italic = new JButton(new StyledEditorKit.ItalicAction());
        JButton underline = new JButton(new StyledEditorKit.UnderlineAction());

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slot.writeInFile(setBoldText(textPane.getSelectedText()));
            }
        });

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textPane.getText());
                slot.writeInFile(textPane.getText());
                TextSlotView textSlotView = new TextSlotView(slot);
                textSlotView.setVisible(true);
            }
        });

        toolBar.add(bold);
        toolBar.add(italic);
        toolBar.add(underline);
        toolBar.add(save);

        this.setSize(300, 250);

    }

    public String setBoldText(String substring){


        String string = textPane.getText();

        int startIdx = string.indexOf(substring);
        int endIdx = startIdx + substring.length() - 1;

        System.out.println("pocetni indeks : " + startIdx + " krajnji indeks : " + endIdx);


        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.insert(startIdx,"<b>");
        stringBuffer.insert(endIdx + 4, "</b>");

        String s = String.valueOf(stringBuffer);
        System.out.println(s);
        return s;

    }




}

