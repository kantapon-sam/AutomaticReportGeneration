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
    private final Object[] login = {"OK", "Cancel"};
    private int Numberlogin = 0;
    private int lineNumber = 0;
    private int TotalFile = 0;
    private int choice = 0;
    private PathFolder PathFolderMusic;
    private InputStream InputStream;
    private long secDownload = 0;
    private long secResult = 0;
    private long delay = 0;
    int Errorline = 0;
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

    public void login() {
        Numberlogin = JOptionPane.showOptionDialog(null,
                "Login",
                "Question", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, login, login[1]);
        System.out.print(Numberlogin);
        if (Numberlogin == 1) {
            System.exit(0);
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

    public void NoLAN() {
        Error();
        JOptionPane.showMessageDialog(null,
                "Please connect LAN",
                "No Connection!",
                JOptionPane.ERROR_MESSAGE);
    }

    public void FileError() {
        Error();
        JOptionPane.showMessageDialog(null,
                "File [" + (TotalFile + 1) + "] Error",
                "File Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    public void NoFile() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Invalid file",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void NoFolder() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "No folder, please click again.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void format() {
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Invalid format\n"
                    + "line = " + (Errorline + 1),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    public void fileOpen() {
        Error();
        JOptionPane.showMessageDialog(null,
                "Please close the file",
                "No Connection!",
                JOptionPane.ERROR_MESSAGE);
        System.exit(0);
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
        long minute = 0;
        try {
            InputStream = new FileInputStream(new File(getPathFolderMusic() + "\\Windows Background.wav"));
            Music = new AudioStream(InputStream);
            AudioPlayer.player.start(Music);
            JOptionPane.showMessageDialog(null,
                    "Success Result Time = " + (secResult / 60) + " : " + (secResult - (60 * (secResult / 60))) + " Minute",
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
                    "Success Download.. Time = " + (secDownload / 60) + " : " + (secDownload - (60 * (secDownload / 60))) + " Minute\nClick And select Results please.",
                    "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void delay() {
        try {
            String s = (String) JOptionPane.showInputDialog(
                    null,
                    "Please put number delay download\n"
                    + "\"Input number >=1.5\"",
                    "Delay Download",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "1.5");
            float n = Float.parseFloat(s);
            delay = (long) (n * 1000);
        } catch (NullPointerException ex) {
            System.exit(0);
        } catch (NumberFormatException ex) {
            Error();
            JOptionPane.showMessageDialog(null,
                    "Number Format !!!",
                    "Number Format",
                    JOptionPane.ERROR_MESSAGE);
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

    public void setSecDownload(long secDownload) {
        this.secDownload = secDownload;
    }

    public void setSecResult(long secResult) {
        this.secResult = secResult;
    }

    public long getDelay() {
        return delay;
    }

    public void setErrorline(int Errorline) {
        this.Errorline = Errorline;
    }

}
