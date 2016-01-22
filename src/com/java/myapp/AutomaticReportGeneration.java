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
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class AutomaticReportGeneration extends JFrame {

    public static void main(String[] args) {
        Dialog.setLAF();
        Desktop d = Desktop.getDesktop();
        PathFolder Folder = new PathFolder();
        PathFileCSV Csv = new PathFileCSV();
        Dialog Dialog = new Dialog();
        Dialog.StatProgram(Dialog.getOptions());
        Object[] options = {"OK", "Exit"};
        try {
            switch (Dialog.getChoice()) {
                case 0:
                    long StartResult = System.currentTimeMillis();

                    int TotalFile = 0;
                    int index = -1;
                    float max[] = new float[20];
                    float most = 0;
                    long date_start;
                    while (true) {

                        SpinnerDateModel dateModel = new SpinnerDateModel(
                                new Date(), null, null, Calendar.DAY_OF_MONTH);
                        JSpinner dateSpinner = new JSpinner(dateModel);
                        dateSpinner.setEditor(
                                new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
                        Calendar Current = new GregorianCalendar();
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.DAY_OF_MONTH, Current.getTime().getDate() - 7);
                        dateSpinner.setValue(cal.getTime());
                        int num = JOptionPane.showOptionDialog(
                                null, dateSpinner,
                                "Date Start", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        System.out.println(dateSpinner.getValue());
                        if (num == 1) {
                            System.exit(0);
                        }
                        int day = dateModel.getDate().getDate();
                        int month = dateModel.getDate().getMonth();
                        int year = (dateModel.getDate().getYear()) + 1900;
                        Calendar Date_Start = new GregorianCalendar(year, month, day);
                        long START = Current.getTimeInMillis() - Date_Start.getTimeInMillis();
                        date_start = Date_Start.getTimeInMillis() / 1000;
                        if (START >= 0) {
                            break;
                        } else {
                            Dialog.OverCurrent();
                        }
                    }
                    Wait wait = new Wait();
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
                    Csv.getFileWriteIN_OUTsingle_row().createNewFile();
                    Arrays.sort(Folder.getFileReport(), new Comparator<File>() {
                        public int compare(File f1, File f2) {
                            return Long.compare(f1.lastModified(), f2.lastModified());
                        }
                    });
                    for (int n = 0; n < Folder.getFileReport().length; n++) {
                        index = n;
                        String[] arr = null;
                        String[] arr2 = null;
                        int lineNumber = 0;
                        int Checkline = 0;
                        try {
                            float arrData[][] = new float[20][30000];
                            Scanner scan = new Scanner(Folder.getFileReport()[n]);
                            float[] column = new float[20];
                            BufferedReader br = new BufferedReader(new FileReader(Folder.getFileReport()[n]));
                            BufferedReader br_Checkline = new BufferedReader(new FileReader(Folder.getFileReport()[n]));
                            String line;
                            try {
                                while ((line = br_Checkline.readLine()) != null) {
                                    Checkline++;

                                }
                                if (Folder.getFileReport()[n].getCanonicalPath().contains("Control CPU")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        Column.ControlCPU(arr, lineNumber, column, arrData, arr2.length, date_start);
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU new")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        Column.CPUnew(arr, lineNumber, column, arrData, arr2.length, date_start);
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU Usage Slot")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        switch (arr.length) {
                                            case 4:
                                                Column.CPUSlot3(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 3:
                                                Column.CPUSlot2(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 9:
                                                Column.CPUSlot8(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            default:
                                                break;
                                        }
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Data CPU")
                                        || Folder.getFileReport()[n].getCanonicalPath().contains("User Quota")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");

                                        Column.DataCPU(arr, lineNumber, column, arrData, arr2.length, date_start);
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("HTTP")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        Column.HTTP(arr, lineNumber, column, arrData, arr2.length, date_start);
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Connection Rate")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        Column.ConnectionRate(arr, lineNumber, column, arrData, arr2.length, date_start);
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                } else if (Folder.getFileReport()[n].getCanonicalPath().contains("IP Pool")) {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        switch (arr.length) {
                                            case 2:
                                                Column.IPPool(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 7:
                                                Column.IPPoolDOCSIS(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            default:
                                                break;
                                        }
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }

                                    }
                                } else {

                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        switch (arr.length) {
                                            case 2:
                                                Column.column_2(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 3:
                                                Column.column_3(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 4:
                                                Column.column_4(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 5:
                                                Column.column_5(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 6:
                                                Column.column_6(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 7:
                                                Column.column_7(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            case 8:
                                                Column.column_8(arr, lineNumber, column, arrData, arr2.length, date_start);
                                                break;
                                            default:
                                                break;
                                        }
                                        if (arr2.length > 1) {
                                            lineNumber++;
                                        }
                                    }
                                }
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                Dialog.setTotalFile(TotalFile);
                                Dialog.FileError(index);
                                System.exit(0);
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
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU Usage Slot")) {
                                switch (arr.length) {
                                    case 4:
                                        System.out.printf("CPUSlot1,\t%.0f \n", max[0]);
                                        System.out.printf("CPUSlot2,\t%.0f \n", max[1]);
                                        System.out.printf("CPUSlot3,\t%.0f \n", max[2]);
                                        break;
                                    case 3:
                                        System.out.printf("CPUSlot1,\t%.0f \n", max[0]);
                                        System.out.printf("CPUSlot2,\t%.0f \n", max[1]);
                                        break;
                                    case 9:
                                        System.out.printf("CPUSlot1,\t%.0f \n", max[0]);
                                        System.out.printf("CPUSlot2,\t%.0f \n", max[1]);
                                        System.out.printf("CPUSlot3,\t%.0f \n", max[2]);
                                        System.out.printf("CPUSlot4,\t%.0f \n", max[3]);
                                        System.out.printf("CPUSlot5,\t%.0f \n", max[4]);
                                        System.out.printf("CPUSlot6,\t%.0f \n", max[5]);
                                        System.out.printf("CPUSlot7,\t%.0f \n", max[6]);
                                        System.out.printf("CPUSlot8,\t%.0f \n", max[7]);
                                        break;
                                    default:
                                        break;
                                }
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Control CPU")) {
                                System.out.printf("CPU,\t%.2f \n", max[0]);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Data CPU")
                                    || Folder.getFileReport()[n].getCanonicalPath().contains("User Quota")) {
                                System.out.printf("CPU,\t%.0f \n", max[0]);

                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU new")) {
                                System.out.printf("CPU,\t%.2f \n", max[0]);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Connection Rate")) {
                                System.out.printf("CPU,\t%.2f \n", max[0]);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("IP Pool")) {
                                switch (arr.length) {
                                    case 2:
                                        System.out.printf("CPU,\t%.2f \n", max[0]);
                                        break;
                                    case 7:
                                        System.out.printf("Platinum,\t%.0f \n", max[0]);
                                        System.out.printf("Gold,\t%.0f \n", max[1]);
                                        System.out.printf("Silver1,\t%.0f \n", max[2]);
                                        System.out.printf("Silver2,\t%.0f \n", max[3]);
                                        System.out.printf("Bronze,\t%.0f \n", max[4]);
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                switch (arr.length) {
                                    case 2:
                                        System.out.printf("CPU,\t%.0f \n", max[0]);
                                        break;
                                    case 3:
                                        System.out.printf("IN,\t%.2f \n", max[0]);
                                        System.out.printf("OUT,\t%.2f \n", max[1]);
                                        most = max(max[0], max[1]);
                                        System.out.printf("MOST,\t%.2f \n", most);
                                        break;
                                    case 4:
                                        System.out.printf("CPU,\t%.2f \n", max[0]);
                                        System.out.printf("CPU,\t%.2f \n", max[1]);
                                        System.out.printf("CPU,\t%.2f \n", max[2]);
                                        break;
                                    case 5:
                                        System.out.printf("CPU,\t%.2f \n", max[0]);
                                        System.out.printf("CPU,\t%.2f \n", max[1]);
                                        System.out.printf("CPU,\t%.2f \n", max[2]);
                                        System.out.printf("CPU,\t%.2f \n", max[3]);
                                        break;
                                    case 6:
                                        System.out.printf("CPU,\t%.2f \n", max[0]);
                                        System.out.printf("CPU,\t%.2f \n", max[1]);
                                        System.out.printf("CPU,\t%.2f \n", max[2]);
                                        System.out.printf("CPU,\t%.2f \n", max[3]);
                                        System.out.printf("CPU,\t%.2f \n", max[4]);
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
                                Dialog.Success();
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
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU Usage Slot")) {
                                switch (arr.length) {
                                    case 4: {
                                        FileWriter CPUSlot;
                                        FileWriter CPUSlot_space;
                                        CPUSlot = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPUSlot_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.CPUSlot3Nolinebreaks(CPUSlot, Folder, index, max);
                                        Writer.CPUSlot3Linespacing(CPUSlot_space, Folder, index, max);
                                        break;
                                    }
                                    case 3: {
                                        FileWriter CPUSlot;
                                        FileWriter CPUSlot_space;
                                        CPUSlot = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPUSlot_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.CPUSlot2Nolinebreaks(CPUSlot, Folder, index, max);
                                        Writer.CPUSlot2Linespacing(CPUSlot_space, Folder, index, max);
                                        break;
                                    }
                                    case 9: {
                                        FileWriter CPUSlot;
                                        FileWriter CPUSlot_space;
                                        CPUSlot = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPUSlot_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.CPUSlot8Nolinebreaks(CPUSlot, Folder, index, max);
                                        Writer.CPUSlot8Linespacing(CPUSlot_space, Folder, index, max);
                                        break;
                                    }
                                    default:
                                        break;
                                }
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("CPU new")) {
                                FileWriter CPU;
                                FileWriter CPU_space;
                                CPU = new FileWriter(Csv.getFileWriteMax(), true);
                                CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Writer.CPUnewNolinebreaks(CPU, Folder, index, max);
                                Writer.CPUnewLinespacing(CPU_space, Folder, index, max);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Control CPU")) {
                                FileWriter CPU;
                                FileWriter CPU_space;
                                CPU = new FileWriter(Csv.getFileWriteMax(), true);
                                CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Writer.ControlCPUNolinebreaks(CPU, Folder, index, max);
                                Writer.ControlCPULinespacing(CPU_space, Folder, index, max);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Data CPU")
                                    || Folder.getFileReport()[n].getCanonicalPath().contains("User Quota")) {
                                FileWriter CPU;
                                FileWriter CPU_space;
                                CPU = new FileWriter(Csv.getFileWriteMax(), true);
                                CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Writer.DataCPUNolinebreaks(CPU, Folder, index, max);
                                Writer.DataCPULinespacing(CPU_space, Folder, index, max);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("HTTP")) {
                                FileWriter HTTP;
                                FileWriter HTTP_space;
                                HTTP = new FileWriter(Csv.getFileWriteMax(), true);
                                HTTP_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Writer.HTTPNolinebreaks(HTTP, Folder, index, max);
                                Writer.HTTPLinespacing(HTTP_space, Folder, index, max);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("Connection Rate")) {
                                FileWriter ConnectionRate;
                                FileWriter ConnectionRate_space;
                                ConnectionRate = new FileWriter(Csv.getFileWriteMax(), true);
                                ConnectionRate_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                Writer.ConnectionRateNolinebreaks(ConnectionRate, Folder, index, max);
                                Writer.ConnectionRateLinespacing(ConnectionRate_space, Folder, index, max);
                            } else if (Folder.getFileReport()[n].getCanonicalPath().contains("IP Pool")) {
                                switch (arr.length) {
                                    case 2:
                                        FileWriter CPUPool;
                                        FileWriter CPU_space;
                                        CPUPool = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.CPUPoolNolinebreaks(CPUPool, Folder, index, max);
                                        Writer.CPUPoolLinespacing(CPU_space, Folder, index, max);
                                        break;
                                    case 7:
                                        FileWriter IPPool;
                                        FileWriter IPPool_space;
                                        IPPool = new FileWriter(Csv.getFileWriteMax(), true);
                                        IPPool_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.DOCSISNolinebreaks(IPPool, Folder, index, max);
                                        Writer.DOCSISLinespacing(IPPool_space, Folder, index, max);
                                        break;
                                }
                            } else {
                                switch (arr.length) {
                                    case 2:
                                        FileWriter CPU;
                                        FileWriter CPU_space;
                                        CPU = new FileWriter(Csv.getFileWriteMax(), true);
                                        CPU_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.CPUNolinebreaks(CPU, Folder, index, max);
                                        Writer.CPULinespacing(CPU_space, Folder, index, max);
                                        break;
                                    case 3:
                                        FileWriter IN_OUT;
                                        FileWriter Most;
                                        FileWriter IN_OUT_space;
                                        FileWriter Most_space;
                                        FileWriter IN_OUTsingle_row;
                                        IN_OUT = new FileWriter(Csv.getFileWriteMax(), true);
                                        Most = new FileWriter(Csv.getFileMOST(), true);
                                        IN_OUT_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Most_space = new FileWriter(Csv.getFileMOST_space(), true);
                                        IN_OUTsingle_row = new FileWriter(Csv.getFileWriteIN_OUTsingle_row(), true);
                                        Writer.Nolinebreaks(IN_OUT, Most, Folder, index, max, most);
                                        Writer.Linespacing(IN_OUT_space, Most_space, Folder, index, max, most);
                                        Writer.single_rowNolinebreaks(IN_OUTsingle_row, Folder, index, max);
                                        break;
                                    case 4:
                                        FileWriter column4;
                                        FileWriter column4_space;
                                        column4 = new FileWriter(Csv.getFileWriteMax(), true);
                                        column4_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks4(column4, Folder, index, max);
                                        Writer.Linespacing4(column4_space, Folder, index, max);
                                        break;
                                    case 5:
                                        FileWriter column5;
                                        FileWriter column5_space;
                                        column5 = new FileWriter(Csv.getFileWriteMax(), true);
                                        column5_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks5(column5, Folder, index, max);
                                        Writer.Linespacing5(column5_space, Folder, index, max);
                                        break;
                                    case 6:
                                        FileWriter column6;
                                        FileWriter column6_space;
                                        column6 = new FileWriter(Csv.getFileWriteMax(), true);
                                        column6_space = new FileWriter(Csv.getFileWriteMax_space(), true);
                                        Writer.Nolinebreaks6(column6, Folder, index, max);
                                        Writer.Linespacing6(column6_space, Folder, index, max);
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
                    long Startday = 0;
                    long Endday = 0;
                    while (true) {
                        Calendar current = new GregorianCalendar();
                        SpinnerDateModel dateModelStart = new SpinnerDateModel(
                                new Date(), null, null, Calendar.DAY_OF_MONTH);
                        JSpinner dateSpinnerStart = new JSpinner(dateModelStart);
                        dateSpinnerStart.setEditor(
                                new JSpinner.DateEditor(dateSpinnerStart, "dd/MM/yyyy"));
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.DAY_OF_MONTH, current.getTime().getDate() - 7);
                        dateSpinnerStart.setValue(cal.getTime());
                        int num1 = JOptionPane.showOptionDialog(
                                null, dateSpinnerStart,
                                "Start Date", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        if (num1 == 1) {
                            System.exit(0);
                        }
                        SpinnerDateModel dateModelStop = new SpinnerDateModel(
                                new Date(), null, null, Calendar.DAY_OF_MONTH);
                        JSpinner dateSpinnerStop = new JSpinner(dateModelStop);
                        dateSpinnerStop.setEditor(
                                new JSpinner.DateEditor(dateSpinnerStop, "dd/MM/yyyy"));

                        int num2 = JOptionPane.showOptionDialog(
                                null, dateSpinnerStop,
                                "Stop Date", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        if (num2 == 1) {
                            System.exit(0);
                        }
                        int day_Start = dateModelStart.getDate().getDate();
                        int month_Start = dateModelStart.getDate().getMonth();
                        int year_Start = (dateModelStart.getDate().getYear()) + 1900;

                        Calendar start = new GregorianCalendar(year_Start, month_Start, day_Start);

                        int day_End = dateModelStop.getDate().getDate();
                        int month_End = dateModelStop.getDate().getMonth();
                        int year_End = dateModelStop.getDate().getYear() + 1900;
                        Calendar end = new GregorianCalendar(year_End, month_End, day_End);
                        long diffMillisStart = current.getTimeInMillis() - start.getTimeInMillis();
                        long diffDaysStart = diffMillisStart / (24 * 60 * 60 * 1000);
                        //Current
                        long diffMillisStop = current.getTimeInMillis() - end.getTimeInMillis();
                        long diffDaysEnd = diffMillisStop / (24 * 60 * 60 * 1000);
                        System.out.println(diffDaysEnd);
                        Startday = diffDaysStart * 86400;
                        Endday = diffDaysEnd * 86400;

                        System.out.println(Startday);

                        System.out.println(Endday);
                        if ((diffDaysStart - diffDaysEnd >= 0) && (diffDaysEnd >= 0) && (diffDaysStart >= 0)) {
                            break;
                        } else {
                            Dialog.DateTime();
                        }
                    }
                    SelectURL selectURL = new SelectURL();
                    URLConnection Connect = new URLConnection();
                    long startDownload = System.currentTimeMillis();

                    if (!Folder.getFoldeSuccess().exists()) {
                        Folder.getFoldeSuccess().mkdirs();
                        Dialog.NoFolder();
                        System.exit(0);
                    }
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
                            String[] str = new String[1];

                            while ((line = br_Checkline.readLine()) != null) {
                                Checkline++;
                                if (Checkline == 1) {
                                    str[0] = line;
                                }
                            }

                            br_Checkline.close();
                            String[] spac = new String[Checkline];
                            while ((line = br.readLine()) != null) {
                                String[] arr = line.split(",");

                                if (arr[1].charAt(0) == '/') {
                                    for (int i = 0; i < 100; i++) {
                                        String cacti = String.format("%02d", i);
                                        if (str[0].contains("Cacti".concat(cacti)) || str[0].contains("cacti".concat(cacti))) {
                                            arr[1] = "http://cacti".concat(cacti) + "/cacti/graph_xport.php?local_graph_id=0&rra_id=2&view_type=";
                                            break;
                                        }
                                    }

                                    Thread.sleep(300);
                                }
                                if (arr.length == 1 || arr == line.split(",")) {
                                    continue;
                                } else if (arr[1].contains("Login_Cacti") || arr[1].contains("login_cacti")) {
                                    arr[1] = arr[1];
                                } else if (arr[1].contains("cacti29") || arr[1].contains("Cacti29")) {
                                    arr[1] = rra_id7(arr[1]);
                                } else {
                                    lineNumber++;
                                    arr[1] = rra_id2(arr[1], Startday, Endday);
                                    Connect.CheckConnection(arr[1], line, lineNumber);
                                }
                                indexline++;
                                Dialog.setErrorline(indexline);
                                Process p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome \"" + arr[1] + "\""});
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
                                String[] str = new String[1];
                                while ((line = br_Checkline.readLine()) != null) {
                                    Checkline++;
                                    if (Checkline == 1) {
                                        str[0] = line;
                                    }
                                }
                                br_Checkline.close();
                                while ((line = br.readLine()) != null) {
                                    String[] arr = line.split(",");
                                    if (arr[1].charAt(0) == '/') {
                                        for (int i = 0; i < 100; i++) {
                                            String cacti = String.format("%02d", i);
                                            if (str[0].contains("Cacti".concat(cacti)) || str[0].contains("cacti".concat(cacti))) {
                                                arr[1] = "http://cacti".concat(cacti) + "/cacti/graph_xport.php?local_graph_id=0&rra_id=2&view_type=";
                                                break;
                                            }
                                        }
                                        Thread.sleep(300);
                                    }
                                    if (arr.length == 1 || arr == line.split(",")) {
                                        continue;
                                    } else if (arr[1].contains("Login_Cacti") || arr[1].contains("login_cacti")) {
                                        arr[1] = arr[1];
                                    } else if (arr[1].contains("cacti29") || arr[1].contains("Cacti29")) {
                                        arr[1] = rra_id7(arr[1]);
                                    } else {
                                        lineNumber++;
                                        arr[1] = rra_id2(arr[1], Startday, Endday);
                                        Connect.CheckConnection(arr[1], line, lineNumber);
                                    }
                                    indexline++;
                                    Dialog.setErrorline(indexline);
                                    Process p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome \"" + arr[1] + "\""});
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

    private static String rra_id7(String str) {
        String[] arr2 = str.split("rra_id=");
        long graph_end = System.currentTimeMillis() / 1000;
        long graph_start = graph_end - 604800;
        str = arr2[0] + "&rra_id=7&view_type=&graph_start=" + graph_start + "&graph_end=" + graph_end;
        return str;
    }

    private static String rra_id2(String str, long Startday, long Endday) {
        Date date = new Date();
        String[] arr2 = str.split("rra_id=");
        int one_day = (date.getHours() * 60 * 60) + (date.getMinutes() * 60) + (date.getSeconds() + 300);
        long graph_start = Startday + one_day;
        long graph_end = Endday + one_day;
        str = arr2[0] + "&rra_id=2&view_type=&graph_start=-" + graph_start + "&graph_end=-" + graph_end;
        return str;
    }
}
