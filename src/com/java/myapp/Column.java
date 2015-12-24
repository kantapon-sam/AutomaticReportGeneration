package com.java.myapp;

import static java.lang.Math.pow;

public class Column {

    public static void column_2(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void column_3(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        if (length > 1) {
            String[] s = new String[2];
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

    public static void column_7(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[6];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void column_8(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[7];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void HTTP(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void ControlCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void DataCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void CPUSlot3(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[3];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void CPUSlot2(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[2];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void CPUSlot8(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[8];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void ALUCPU(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void CPUnew(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void IPPool(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[1];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void IPPoolDOCSIS(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[6];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void Calculate(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData, int length) {
        if (length > 1) {
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

    public static void column_4(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[3];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void column_5(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[4];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }

    public static void column_6(String[] arr, int lineNumber, float[] column, float[][] arrData, int length) {
        String[] s = new String[5];
        Calculate(arr, s, column, lineNumber, arrData, length);
    }
}
