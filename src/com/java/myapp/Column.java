package com.java.myapp;

import static java.lang.Math.pow;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Column {

    public static void column_2(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_3(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[2];
        CalculateDiv6(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_7(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[6];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_8(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[7];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void HTTP(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void ControlCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void DataCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void CPUSlot3(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[3];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void CPUSlot2(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[2];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void CPUSlot8(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[8];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void ALUCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void CPUnew(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void IPPool(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void IPPoolDOCSIS(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[6];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_4(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[3];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_5(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[4];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void column_6(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[5];
        Calculate(arr, s, column, lineNumber, arrData, length, date_start);
    }

    public static void ConnectionRate(String[] arr, int lineNumber, float[] column, float[][] arrData, int length, long date_start) {
        String[] s = new String[1];
        CalculateDiv6(arr, s, column, lineNumber, arrData, length, date_start);

    }

    public static void Calculate(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData, int length, long date_start) {

        if (length > 1) {
            long dateCSV = Date(arr[0]);
            if (dateCSV >= date_start) {
                for (int i = 0; i < s.length; i++) {
                    s[i] = arr[i + 1].split("\"")[1];
                    if (s[i].equals("NaN")) {
                        s[i] = "0";
                    }
                    column[i] = (float) (Float.parseFloat(s[i]));
                    arrData[i][lineNumber] = column[i];
                }
            }
        }
    }

    public static void CalculateDiv6(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData, int length, long date_start) {
        if (length > 1) {
            long dateCSV = Date(arr[0]);
            if (dateCSV >= date_start) {

                for (int i = 0; i < s.length; i++) {
                    s[i] = arr[i + 1].split("\"")[1];

                    if (s[i].equals("NaN")) {
                        s[i] = "0";
                    }
                    column[i] = (float) (Float.parseFloat(s[i]) / pow(10, 6));
                    arrData[i][lineNumber] = column[i];
                }
            }
        }
    }

    private static long Date(String arr) {
        String[] arr1 = arr.split("\"");
        String[] arr2 = arr1[1].split("-");

        String year_str = arr2[0];
        String month_str = arr2[1];
        String day_str = arr2[2].substring(0, 2);
        int day = Integer.valueOf(day_str);
        int month = Integer.valueOf(month_str) - 1;
        int year = Integer.valueOf(year_str);

        Calendar date = new GregorianCalendar(year, month, day);
        return (date.getTimeInMillis() / 1000);
    }
}
