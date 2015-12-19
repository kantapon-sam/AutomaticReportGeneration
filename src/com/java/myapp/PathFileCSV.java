package com.java.myapp;

import java.io.File;
import java.io.IOException;

public class PathFileCSV {

    private String PathWriteMax;
    private File FileWriteMax;
    private String PathWriteMOST;
    private File FileMOST;
    private String PathWriteMax_space;
    private File FileWriteMax_space;
    private String PathWriteMOST_space;
    private File FileMOST_space;
    private String PathWriteIN_OUTsingle_row;
    private File FileWriteIN_OUTsingle_row;
    public PathFileCSV() {
        try {
            PathWriteMax = new File(".").getCanonicalPath() + "\\Report\\Success\\Max.csv";
            FileWriteMax = new File(PathWriteMax);
            PathWriteMOST = new File(".").getCanonicalPath() + "\\Report\\Success\\MOST.csv";
            FileMOST = new File(PathWriteMOST);
            PathWriteMax_space = new File(".").getCanonicalPath() + "\\Report\\Success\\Max-space.csv";
            FileWriteMax_space = new File(PathWriteMax_space);
            PathWriteMOST_space = new File(".").getCanonicalPath() + "\\Report\\Success\\MOST-space.csv";
            FileMOST_space = new File(PathWriteMOST_space);
            PathWriteIN_OUTsingle_row = new File(".").getCanonicalPath() + "\\Report\\Success\\IN_OUTsingle_row.csv";
            FileWriteIN_OUTsingle_row = new File(PathWriteIN_OUTsingle_row);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getPathWriteMax() {
        return PathWriteMax;
    }

    public File getFileWriteMax() {
        return FileWriteMax;
    }

    public String getPathWriteMOST() {
        return PathWriteMOST;
    }

    public File getFileMOST() {
        return FileMOST;
    }

    public String getPathWriteMax_space() {
        return PathWriteMax_space;
    }

    public File getFileWriteMax_space() {
        return FileWriteMax_space;
    }

    public String getPathWriteMOST_space() {
        return PathWriteMOST_space;
    }

    public File getFileMOST_space() {
        return FileMOST_space;
    }

    public String getPathWriteIN_OUTsingle_row() {
        return PathWriteIN_OUTsingle_row;
    }

    public File getFileWriteIN_OUTsingle_row() {
        return FileWriteIN_OUTsingle_row;
    }

}
