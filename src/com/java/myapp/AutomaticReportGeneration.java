package com.java.myapp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Float.max;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

public class AutomaticReportGeneration {

    public static void main(String[] args) {
        Dialog.setLAF();
        Desktop d = Desktop.getDesktop();
        PathFolder Folder = new PathFolder();
        PathFileCSV Csv = new PathFileCSV();
        Dialog Dialog = new Dialog();
        Dialog.StatProgram(Dialog.getOptions());
        try {
            switch (Dialog.getChoice()) {
                case 0:
                    long StartResult = System.currentTimeMillis();
                    Wait wait = new Wait();
                    int TotalFile = 0;
                    int index = -1;
                    float max[] = new float[7];
                    float most = 0;

                    if (!Folder.getFoldeSuccess().exists()) {
                        Folder.getFoldeSuccess().mkdirs();
                        Dialog.NoFolder();
                        System.exit(0);
                    }
                    for (File fileSuccess : Folder.getFileSuccess()) {
                        fileSuccess.delete();
                    }
                    Csv.getFileWriteMax().createNewFile();
                    Csv.getFileMOST().createNewFile();
                    Csv.getFileWriteMax_space().createNewFile();
                    Csv.getFileMOST_space().createNewFile();

                    long[] TimeData = new long[Folder.getFileReport().length];

                    for (int i = 0; i < Folder.getFileReport().length; i++) {
                        TimeData[i] = Folder.getFileReport()[i].lastModified();
                    }
                    Arrays.sort(TimeData);
                    while (TotalFile < Folder.getFileReport().length) {

                        String[] arr = null;
                        int lineNumber = 0;
                        int Checkline = 0;
                        try {

                            float arrData[][] = new float[7][336];
                            for (int i = 0; i < Folder.getFileReport().length; i++) {
                                if (TimeData[TotalFile] == Folder.getFileReport()[i].lastModified()) {
                                    index = i;
                                    Folder.getFileReport()[index].getName();
                                    break;
                                }
                            }

                            Scanner scan = new Scanner(Folder.getFileReport()[index]);
                            float[] column = new float[7];
                            BufferedReader br = new BufferedReader(new FileReader(Folder.getFileReport()[index]));
                            BufferedReader br_Checkline = new BufferedReader(new FileReader(Folder.getFileReport()[index]));
                            String line;

                            try {
                                while ((line = br_Checkline.readLine()) != null) {
                                    Checkline++;
                                }
                                if (!Folder.getFileReport()[index].getCanonicalPath().contains("HTTP")) {
                                    System.out.println(Checkline + " line");
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        lineNumber++;
                                        switch (arr.length) {
                                            case 2:
                                                Column.column_2(arr, lineNumber, Checkline, column, arrData);
                                                break;
                                            case 3:
                                                Column.column_3(arr, lineNumber, column, arrData);
                                                break;
                                            case 7:
                                                Column.column_7(arr, lineNumber, column, arrData);
                                                break;
                                            case 8:
                                                Column.column_8(arr, lineNumber, column, arrData);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                } else {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        lineNumber++;
                                        switch (arr.length) {
                                            case 2:
                                                Column.HTTP(arr, lineNumber, column, arrData);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                Dialog.setTotalFile(TotalFile);
                                Dialog.FileError();
                            }
                            br.close();
                            br_Checkline.close();
                            for (int i = 0; i < max.length; i++) {
                                Arrays.sort(arrData[i]);
                            }
                            for (int i = 0; i < max.length; i++) {
                                max[i] = arrData[i][arrData[i].length - 1];
                            }
                            if (Checkline == 0) {
                                System.out.println("GRAPH DOES NOT EXIST");
                            } else {
                                switch (arr.length) {
                                    case 2:
                                        if (Checkline == 346) {
                                            System.out.printf("CPU,\t%.0f \n", max[0]);
                                        } else if (Checkline == 348) {
                                            System.out.printf("CPU,\t%.2f \n", max[0]);
                                        }
                                        break;
                                    case 3:
                                        System.out.printf("IN,\t%.2f \n", max[0]);
                                        System.out.printf("OUT,\t%.2f \n", max[1]);
                                        most = max(max[0], max[1]);
                                        System.out.printf("MOST,\t%.2f \n", most);
                                        break;
                                    case 7:
                                        System.out.printf("PNC1,\t%.2f \n", max[0]);
                                        System.out.printf("PNC2,\t%.2f \n", max[1]);
                                        System.out.printf("TSG,\t%.2f \n", max[2]);
                                        System.out.printf("LTY,\t%.2f \n", max[3]);
                                        System.out.printf("MTG,\t%.2f \n", max[4]);
                                        System.out.printf("UPC,\t%.2f \n", max[5]);
                                        break;
                                    case 8:
                                        System.out.printf("PNC1,\t%.2f \n", max[0]);
                                        System.out.printf("PNC2,\t%.2f \n", max[1]);
                                        System.out.printf("TSG,\t%.2f \n", max[2]);
                                        System.out.printf("LTY,\t%.2f \n", max[3]);
                                        System.out.printf("MTG,\t%.2f \n", max[4]);
                                        System.out.printf("MTG2,\t%.2f \n", max[5]);
                                        System.out.printf("UPC,\t%.2f \n", max[6]);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (FileNotFoundException ex) {
                            if (TotalFile != 0) {
                                if (Folder.getFoldeSuccess().exists()) {
                                    d.open(Folder.getFoldeSuccess());
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                wait.dispose();
                                long StopResult = System.currentTimeMillis();
                                Dialog.setSecResult((StopResult - StartResult) / 1000);
                                Dialog.NoErrorSuccess();
                            } else {
                                wait.dispose();
                                Dialog.NoFile();
                            }
                            System.exit(0);
                            break;
                        }
                        try {
                            if (Checkline == 0) {
                                FileWriter NULL;
                                FileWriter Most;
                                FileWriter NULL_space;
                                FileWriter Most_space;
                                NULL = new FileWriter(Csv.getFileWriteMax(), true);
                                Most = new FileWriter(Csv.getFileMOST(), true);
                                NULL_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Most_space = new FileWriter(Csv.getFileMOST_space(), true);
                                Writer.Nolinebreaks(NULL, Most);
                                Writer.Linespacing(NULL_space, Most_space);
                            } else {
                                switch (arr.length) {
                                    case 2:
                                        FileWriter CPU;
                                        FileWriter CPU_space;
                                        CPU = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks(CPU, Folder, index, max, Checkline);
                                        Writer.Linespacing(CPU_space, Folder, index, max, Checkline);
                                        break;
                                    case 3:
                                        FileWriter IN_OUT;
                                        FileWriter Most;
                                        FileWriter IN_OUT_space;
                                        FileWriter Most_space;
                                        IN_OUT = new FileWriter(Csv.getFileWriteMax(), true);
                                        Most = new FileWriter(Csv.getFileMOST(), true);
                                        IN_OUT_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Most_space = new FileWriter(Csv.getFileMOST_space(), true);
                                        Writer.Nolinebreaks(IN_OUT, Most, Folder, index, max, most);
                                        Writer.Linespacing(IN_OUT_space, Most_space, Folder, index, max, most);

                                        break;
                                    case 7:
                                        FileWriter IPPool7;
                                        FileWriter IPPool7_space;
                                        IPPool7 = new FileWriter(Csv.getFileWriteMax(), true);
                                        IPPool7_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks7(IPPool7, Folder, index, max);
                                        Writer.Linespacing7(IPPool7_space, Folder, index, max);
                                        break;
                                    case 8:
                                        FileWriter IPPool8;
                                        FileWriter IPPool8_space;
                                        IPPool8 = new FileWriter(Csv.getFileWriteMax(), true);
                                        IPPool8_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks8(IPPool8, Folder, index, max);
                                        Writer.Linespacing8(IPPool8_space, Folder, index, max);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (FileNotFoundException ex) {
                            Dialog.fileOpen();
                        }
                        TotalFile++;
                    }
                    System.exit(0);
                    break;
                case 1:
                    SelectURL selectURL = new SelectURL();
                    URLConnection Connect = new URLConnection();
                    long startDownload = System.currentTimeMillis();
                    try {
                        if (Folder.getFoldeSuccess().isDirectory()) {
                            for (File fileSuccess : Folder.getFileSuccess()) {
                                fileSuccess.delete();
                            }
                        }
                        for (File fileReport : Folder.getFileReport()) {
                            if (!fileReport.getAbsolutePath().equals(Folder.getPathFolderURL())
                                    && !fileReport.getAbsolutePath().equals(Folder.getPathFolderSuccess())) {
                                fileReport.delete();
                            }
                        }
                        if (selectURL.getChooser().getSelectedFile().getName().contains(".txt")
                                || selectURL.getChooser().getSelectedFile().getName().contains(".csv")) {
                            while (true) {
                                Dialog.delay();
                                if (Dialog.getDelay() >= 1500) {
                                    break;
                                }
                            }
                            Connect.Login(new URI("http://nocweb02/cactiportal/Login.aspx"));
                            new StopProgram();
                            Scanner scan = new Scanner(selectURL.getURL());
                            BufferedReader br = new BufferedReader(new FileReader(selectURL.getURL()));
                            BufferedReader br_Checkline = new BufferedReader(new FileReader(selectURL.getURL()));
                            String line;
                            int indexline = 0;
                            int Checkline = 0;
                            int lineNumber = 0;
                            while ((line = br_Checkline.readLine()) != null) {
                                Checkline++;
                            }
                            System.out.println(Checkline);
                            br_Checkline.close();
                            String[] spac = new String[Checkline];
                            while ((line = br.readLine()) != null) {
                                String[] arr = line.split(",");
                                spac[indexline] = arr[1].split("cacti/")[0];

                                if (arr[1].charAt(0) == '/') {
                                    arr[1] = linespacing(spac[1]);
                                    Thread.sleep(300);
                                }
                                if (arr.length == 1 || arr == line.split(",")) {
                                    continue;
                                } else {
                                    lineNumber++;
                                    Connect.CheckConnection(arr[1], line, lineNumber);
                                }
                                indexline++;
                                Dialog.setErrorline(indexline);
                                d.browse(new URI(arr[1]));
                                Thread.sleep(Dialog.getDelay());
                            }
                            br.close();
                        } else {
                            while (true) {
                                Dialog.delay();
                                if (Dialog.getDelay() >= 1500) {
                                    break;
                                }
                            }
                            Connect.Login(new URI("http://nocweb02/cactiportal/Login.aspx"));
                            new StopProgram();
                            for (File fileURL : selectURL.getURLinFolder()) {
                                Scanner scan = new Scanner(fileURL);
                                BufferedReader br = new BufferedReader(new FileReader(fileURL));
                                BufferedReader br_Checkline = new BufferedReader(new FileReader(fileURL));
                                String line;
                                int indexline = 0;
                                int Checkline = 0;
                                int lineNumber = 0;
                                while ((line = br_Checkline.readLine()) != null) {
                                    Checkline++;
                                }
                                br_Checkline.close();
                                String[] spac = new String[Checkline];
                                while ((line = br.readLine()) != null) {
                                    String[] arr = line.split(",");
                                    spac[indexline] = arr[1].split("cacti/")[0];
                                    if (arr[1].charAt(0) == '/') {
                                        arr[1] = linespacing(spac[1]);
                                    }
                                    if (arr.length == 1 || arr == line.split(",")) {
                                        continue;
                                    } else {
                                        lineNumber++;
                                        Connect.CheckConnection(arr[1], line, lineNumber);
                                    }
                                    indexline++;
                                    Dialog.setErrorline(indexline);
                                    d.browse(new URI(arr[1]));
                                    Thread.sleep(Dialog.getDelay());
                                }
                                br.close();
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        Dialog.format();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                        Dialog.NoFile();
                        System.exit(0);
                    } catch (MalformedURLException | RuntimeException | URISyntaxException ex) {
                        ex.printStackTrace();
                        Dialog.URLError();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    long stopDownload = System.currentTimeMillis();
                    System.out.println("time = " + ((stopDownload - startDownload) / 1000));
                    Dialog.setSecDownload((stopDownload - startDownload) / 1000);
                    if (Connect.getError() == 0) {
                        Dialog.NoErrorDownload();
                    }
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            System.exit(0);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    private static String linespacing(String str) {
        String linespacing;
        linespacing = str + "cacti/graph_xport.php?local_graph_id=0&rra_id=2&view_type=";
        return linespacing;
    }

}
