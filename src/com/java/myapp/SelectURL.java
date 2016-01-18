package com.java.myapp;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectURL {

    private final File URL;
    private final File[] URLinFolder;
    private String choosertitle;
    private final JFileChooser chooser;

    public SelectURL() {
        Image image = new ImageIcon("image\\custom-reports.png").getImage();
        JFrame f = new JFrame();
        f.setIconImage(image);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text or Csv", "txt", "csv"));
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
            System.exit(0);
        }
        URL = new File(getChooser().getSelectedFile().toString());
        URLinFolder = URL.listFiles();
    }

    public JFileChooser getChooser() {
        return chooser;
    }

    public File getURL() {
        return URL;
    }

    public File[] getURLinFolder() {
        return URLinFolder;
    }

}
