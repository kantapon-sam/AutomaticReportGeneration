package com.java.myapp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Float.max;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class AutomaticReportGeneration {
    
    public static void main(String[] args) throws IOException {
        Dialog.setLAF();
        Desktop d = Desktop.getDesktop();
        PathFolder Folder = new PathFolder();
        PathFileCSV Csv = new PathFileCSV();
        Dialog Dialog = new Dialog();
        Dialog.StatProgram(Dialog.getOptions());
        try {
            switch (Dialog.getChoice()) {
                case 0:
                    int TotalFile = 0;
                    int index = -1;
                    float max[] = new float[7];
                    float most = 0;
                    if (Folder.getFoldeSuccess().exists()) {
                        d.open(Folder.getFolderReport());
                    }
                    Folder.getFoldeSuccess().mkdirs();
                    Folder.getFolderURL().mkdirs();
                    if (Csv.getFileWriteMax().exists()
                            || Csv.getFileMOST().exists()
                            || Csv.getFileWriteMax_space().exists()
                            || Csv.getFileMOST_space().exists()) {
                        Csv.getFileWriteMax().delete();
                        Csv.getFileMOST().delete();
                        Csv.getFileWriteMax_space().delete();
                        Csv.getFileMOST_space().delete();
                    } else {
                        Csv.getFileWriteMax().createNewFile();
                        Csv.getFileMOST().createNewFile();
                        Csv.getFileWriteMax_space().createNewFile();
                        Csv.getFileMOST_space().createNewFile();
                    }
                    
                    for (File fileURL : Folder.getFileURL()) {
                        fileURL.delete();
                    }
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
                        } catch (FileNotFoundException e) {
                            if (TotalFile != 0) {
                                Dialog.NoErrorSuccess();
                            }
                            break;
                        }
                        if (Checkline == 0) {
                            FileWriter NULL;
                            FileWriter NULL_space;
                            NULL = new FileWriter(Csv.getFileWriteMax(), true);
                            NULL_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                            Writer.Nolinebreaks(NULL, Folder, index);
                            Writer.Linespacing(NULL_space, Folder, index);
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
                        TotalFile++;
                    }
                    System.exit(0);
                    break;
                case 1:
                    long start = System.currentTimeMillis();
                    long stop = 0;
                    int Error = 0;
                    try {
                        Folder.getFolderURL().mkdirs();
                        Folder.getFoldeSuccess().mkdirs();
                        if (Folder.getFileURL().length == 0) {
                            d.open(Folder.getFolderURL());
                        }
                        for (File fileReport : Folder.getFileReport()) {
                            if (!fileReport.getAbsolutePath().equals(Folder.getPathFolderURL())) {
                                fileReport.delete();
                            }
                        }
                        for (File fileURL : Folder.getFileURL()) {
                            Scanner scan = new Scanner(fileURL);
                            BufferedReader br = new BufferedReader(new FileReader(fileURL));
                            String line;
                            int lineNumber = 0;
                            while ((line = br.readLine()) != null) {
                                
                                String[] arr = line.split(",");
                                if (arr.length == 1 || arr == line.split(",")) {
                                    continue;
                                } else {
                                    try {
                                        lineNumber++;
                                        Dialog.setLineNumber(lineNumber);
                                        URL url = new URL(arr[1]);
                                        HttpURLConnection http = (HttpURLConnection) url.openConnection();
                                        int statusCode = http.getResponseCode();
                                        if (statusCode == 200) {
                                            System.out.println(line.split(",")[0]);
                                        }
                                    } catch (UnknownHostException ex) {
                                        Dialog.LineURLError();
                                        Error++;
                                        break;
                                    }
                                }
                                d.browse(new URI(arr[1]));
                                Thread.sleep(1500);
                            }
                            stop = System.currentTimeMillis();
                            System.out.println("time = " + ((stop - start) / 1000));
                            Dialog.setSec((stop - start) / 1000);
                            if (Error == 0) {
                                Dialog.NoErrorDownload();
                            }
                            br.close();
                        }
                    } catch (NullPointerException ex) {
                        Dialog.NoFolder();
                        System.exit(0);
                    } catch (MalformedURLException | RuntimeException | URISyntaxException ex) {
                        Dialog.URLError();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
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
            Dialog.NoFolder();
            System.exit(0);
        }
    }
}
