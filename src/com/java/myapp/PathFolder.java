package com.java.myapp;

import java.io.File;
import java.io.IOException;

public class PathFolder {

    private String PathFolderURL;
    private String PathFolderReport;
    private File FolderURL;
    private File[] FileURL;
    private File FolderReport;
    private File[] FileReport;
    private String PathFolderSuccess;
    private File FoldeSuccess;
    private File[] FileSuccess;
    private String PathFolderMusic;
    private File FolderMusic;

    public PathFolder() {
        try {
            PathFolderURL = new File(".").getCanonicalPath() + "\\Report\\URL";
            FolderURL = new File(PathFolderURL);
            FileURL = FolderURL.listFiles();
            PathFolderReport = new File(".").getCanonicalPath() + "\\Report";
            FolderReport = new File(PathFolderReport);
            FileReport = FolderReport.listFiles();
            PathFolderSuccess = new File(".").getCanonicalPath() + "\\Report\\Success";
            FoldeSuccess = new File(PathFolderSuccess);
            FileSuccess = FoldeSuccess.listFiles();
            PathFolderMusic = new File(".").getCanonicalPath() + "\\Media";
            FolderMusic = new File(PathFolderMusic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getPathFolderURL() {
        return PathFolderURL;
    }

    public String getPathFolderReport() {
        return PathFolderReport;
    }

    public File getFolderURL() {
        return FolderURL;
    }

    public File[] getFileURL() {
        return FileURL;
    }

    public File getFolderReport() {
        return FolderReport;
    }

    public File[] getFileReport() {
        return FileReport;
    }

    public String getPathFolderSuccess() {
        return PathFolderSuccess;
    }

    public File getFoldeSuccess() {
        return FoldeSuccess;
    }

    public String getPathFolderMusic() {
        return PathFolderMusic;
    }

    public File getFolderMusic() {
        return FolderMusic;
    }

    public File[] getFileSuccess() {
        return FileSuccess;
    }

}
