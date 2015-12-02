package com.java.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import sun.audio.*;

public class Dialog extends PathFolder {

    private final Object[] options = {"Result", "Download", "Exit"};
    private int lineNumber = 0;
    private int TotalFile = 0;
    private int choice = 0;
    private PathFolder PathFolderMusic;
    private InputStream InputStream;
    private long sec = 0;
    protected AudioStream Music;

    public static void setLAF() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.err.println("Failed to set LookAndFeel");

        }
    }

    public void StatProgram(Object[] options) {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Notify Messaging.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            choice = JOptionPane.showOptionDialog(null,
                    "Automatic Report Generation",
                    "Automatic Report Generation", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error Missing File",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void URLError() {
        Error();
        JOptionPane.showMessageDialog(null,
                "URL Error",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public void LineURLError() {
        Error();
        JOptionPane.showMessageDialog(null,
                "URL ERROR Start!!! Line = " + lineNumber,
                "No Connection!",
                JOptionPane.ERROR_MESSAGE);
        System.out.println("URL ERROR!!! Line = " + lineNumber);
    }

    public void FileError() {
        Error();
        JOptionPane.showMessageDialog(null,
                "File [" + (TotalFile + 1) + "] Error",
                "File Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    public void NoFolder() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Creating file storage... Please click again",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Error() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Error.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void NoErrorSuccess() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Success Result",
                    "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void NoErrorDownload() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Success Download.. Time = " + sec + " Sec\nClick And select Results please.",
                    "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object[] getOptions() {
        return options;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getChoice() {
        return choice;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setTotalFile(int TotalFile) {
        this.TotalFile = TotalFile;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setSec(long sec) {
        this.sec = sec;
    }

}
