package com.java.myapp;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                    int TotalFile = 0;
                    int index = -1;
                    float max[] = new float[50];
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
                        if (num == 1 || num == -1) {
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
                    Csv.getFileWriteSummary().createNewFile();
                    Arrays.sort(Folder.getFileReport(), new Comparator<File>() {
                        public int compare(File f1, File f2) {
                            return Long.compare(f1.lastModified(), f2.lastModified());
                        }
                    });
                    for (int n = 0; n < Folder.getFileReport().length; n++) {
                        index = n;
                        String[] arr = null;
                        String[] arr2 = null;
                        String[] arr3 = null;
                        float[] sum = new float[50];
                        float Traffic[][] = new float[50][30000];
                        int count = 0;
                        int t = 0;
                        int lineNumber = 0;
                        try {
                            float arrData[][] = new float[50][30000];
                            // Scanner scan = new Scanner(Folder.getFileReport()[n]);
                            float[] column = new float[50];
                            try (BufferedReader br = new BufferedReader(new FileReader(Folder.getFileReport()[n]))) {
                                String line;
                                try {
                                    while ((line = br.readLine()) != null) {
                                        arr = line.split(",");
                                        arr2 = line.split("\\+");
                                        arr3 = line.split("Graph ID:");
                                        Column.column(arr, lineNumber, column, arrData, arr2.length, arr3, date_start, arr.length);
                                        lineNumber++;
                                    }

                                } catch (ArrayIndexOutOfBoundsException ex) {
                                    Dialog.setTotalFile(TotalFile);
                                    Dialog.FileError(index);
                                    System.exit(0);
                                }

                            }
                            for (int i = 0; i < arr2.length - 1; i++) {
                                for (int j = 0; j < arrData[0].length; j++) {
                                    if (arrData[i][j] != 0) {
                                        sum[i] += arrData[i][j];
                                        count++;
                                        if (count % 5 == 0) {
                                            sum[i] /= 5;
                                            Traffic[i][t] = sum[i];
                                            t++;
                                            sum[i] = 0;
                                        }
                                    }
                                }
                            }

                            for (int i = 0; i < arr2.length - 1; i++) {
                                //Arrays.sort(arrData[i]);
                                Arrays.sort(Traffic[i]);

                            }

                            for (int i = 0; i < arr2.length - 1; i++) {
                                //max[i] = arrData[i][arrData[i].length - 1];
                                max[i] = Traffic[i][Traffic[i].length - 1];
                            }
                            if (lineNumber == 0) {
                                System.out.println("GRAPH DOES NOT EXIST");
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
                            if (lineNumber == 0) {
                                System.out.println("aaa");
                            } else {
                                FileWriter Summary;
                                Summary = new FileWriter(Csv.getFileWriteSummary(), true);
                                Writer.Column(Summary, Folder, index, max, Column.getS_arr3(), arr.length);
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
                        if (num1 == 1 || num1 == -1) {
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
                        if (num2 == 1 || num2 == -1) {
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
                        int indexline = 0;
                        int Checkline = 0;

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
                            /*   while (true) {
                                Dialog.delay();
                                if (Dialog.getDelay() >= 1500) {
                                    break;
                                }
                            }*/
                            Connect.Login(new URI("http://nocweb02/cactiportal/Login.aspx"));
                            new StopProgram();
                            Scanner scan = new Scanner(selectURL.getURL());
                            BufferedReader br = new BufferedReader(new FileReader(selectURL.getURL()));
                            BufferedReader br_Checkline = new BufferedReader(new FileReader(selectURL.getURL()));
                            String line;
                            String[] str = new String[1];
                            String Name_file = selectURL.getChooser().getSelectedFile().getName();
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
                                indexline++;
                                if (arr.length == 1 || arr == line.split(",")) {
                                    continue;
                                } else if (arr[1].contains("Login_Cacti") || arr[1].contains("login_cacti")) {
                                    arr[1] = arr[1];
                                } else if (arr[1].contains("cacti29") || arr[1].contains("Cacti29") || arr[1].contains("cacti27") || arr[1].contains("Cacti27")) {
                                    arr[1] = rra_id2_7_3_8(arr[1], Startday, Endday);
                                } else {
                                    arr[1] = rra_id2(arr[1], Startday, Endday);
                                    Connect.CheckConnection(arr[1], line, indexline, Name_file);
                                }

                                Dialog.setErrorline(indexline);
                                Process p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome \"" + arr[1] + "\""});
                                if (arr[1].contains("Login_Cacti")) {
                                    Thread.sleep(2000);
                                } else {
                                    Thread.sleep(1000);
                                }
                            }

                            br.close();

                        } else {

                            /*   while (true) {
                                Dialog.delay();
                                if (Dialog.getDelay() >= 1500) {
                                    break;
                                }
                            }*/
                            Connect.Login(new URI("http://nocweb02/cactiportal/Login.aspx"));
                            new StopProgram();
                            for (File fileURL : selectURL.getURLinFolder()) {
                                Scanner scan = new Scanner(fileURL);
                                BufferedReader br = new BufferedReader(new FileReader(fileURL));
                                BufferedReader br_Checkline = new BufferedReader(new FileReader(fileURL));
                                String line;
                                String[] str = new String[1];
                                String Name_file = fileURL.getName();
                                while ((line = br_Checkline.readLine()) != null) {
                                    Checkline++;
                                    if (Checkline == 1) {
                                        str[0] = line;
                                    }
                                }
                                br_Checkline.close();
                                while ((line = br.readLine()) != null) {
                                    String[] arr = line.split(",");
                                    indexline++;
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
                                    } else if (arr[1].contains("cacti29") || arr[1].contains("Cacti29") || arr[1].contains("cacti27") || arr[1].contains("Cacti27")) {
                                        arr[1] = rra_id2_7_3_8(arr[1], Startday, Endday);
                                    } else {
                                        arr[1] = rra_id2(arr[1], Startday, Endday);
                                        Connect.CheckConnection(arr[1], line, indexline, Name_file);
                                    }

                                    Dialog.setErrorline(indexline);
                                    Process p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome \"" + arr[1] + "\""});
                                    if (arr[1].contains("Login_Cacti")) {
                                        Thread.sleep(2000);
                                    }

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

    private static String rra_id2(String str, long Startday, long Endday) {
        Date date = new Date();
        String[] arr2 = str.split("&rra_id=");
        int one_day = (date.getHours() * 60 * 60) + (date.getMinutes() * 60) + (date.getSeconds() + 300);
        long graph_start = Startday + one_day;
        long graph_end = Endday + one_day;
        str = arr2[0] + "&rra_id=2&view_type=&graph_start=-" + graph_start + "&graph_end=-" + graph_end;
        return str;
    }

    private static String rra_id2_7_3_8(String str, long Startday, long Endday) {
        Date date = new Date();
        String[] arr2 = str.split("&rra_id=");
        int one_day = (date.getHours() * 60 * 60) + (date.getMinutes() * 60) + (date.getSeconds());
        long end = Endday + one_day;
        long graph_end = (System.currentTimeMillis() / 1000) - end;
        long graph_start = graph_end - 604800;
        str = arr2[0] + "&rra_id=8&view_type=&graph_start=" + graph_start + "&graph_end=" + graph_end;
        return str;
    }

}
