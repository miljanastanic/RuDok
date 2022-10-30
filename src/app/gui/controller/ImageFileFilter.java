package app.gui.controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".png"));
    }

    @Override
    public String getDescription() {
        return "Image Files (*.png)";
    }
}