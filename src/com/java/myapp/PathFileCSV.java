package com.java.myapp;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PathFileCSV {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
    Date date = new Date();
    private String PathWriteSummary;
    private File FileWriteSummary;
    public PathFileCSV() {
        try {
            PathWriteSummary = new File(".").getCanonicalPath() + "\\Report\\Success\\Summary("+dateFormat.format(date)+").csv";
            FileWriteSummary = new File(PathWriteSummary);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File getFileWriteSummary() {
        return FileWriteSummary;
    }


}
