package com.java.myapp;

import static java.lang.Math.pow;

public class Column {

    public static void column_2(String[] arr, int lineNumber, int Checkline, float[] column, float[][] arrData) {
        if (lineNumber >= 11 && Checkline == 346) {
            calculateCPU(arr, column, arrData, lineNumber, Checkline);
        } else if (lineNumber >= 13 && Checkline == 348) {
            calculateCPU(arr, column, arrData, lineNumber, Checkline);
        }
    }

    public static void column_3(String[] arr, int lineNumber, float[] column, float[][] arrData) {

        if (lineNumber >= 11) {
            String[] s = new String[2];
            for (int i = 0; i < s.length; i++) {
                s[i] = arr[i + 1].split("\"")[1];

                if (s[i].equals("NaN")) {
                    s[i] = "0";
                }
                column[i] = (float) (Float.parseFloat(s[i]) / pow(10, 6));
                arrData[i][lineNumber - 11] = column[i];
            }
        }

    }

    public static void column_7(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[6];
            for (int i = 0; i < s.length; i++) {
                s[i] = arr[i + 1].split("\"")[1];

                if (s[i].equals("NaN")) {
                    s[i] = "0";

                }
                column[i] = (float) (Float.parseFloat(s[i]));
                arrData[i][lineNumber - 11] = column[i];

            }
        }
    }

    public static void column_8(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[7];
            for (int i = 0; i < s.length; i++) {
                s[i] = arr[i + 1].split("\"")[1];

                if (s[i].equals("NaN")) {
                    s[i] = "0";

                }
                column[i] = (float) (Float.parseFloat(s[i]));
                arrData[i][lineNumber - 11] = column[i];

            }
        }
    }

    private static void calculateCPU(String[] arr, float[] column, float[][] arrData, int lineNumber, int Checkline) {
        String[] s = new String[1];
        for (int i = 0; i < s.length; i++) {
            s[i] = arr[i + 1].split("\"")[1];
            if (s[i].equals("NaN")) {
                s[i] = "0";
            }
            column[i] = (float) (Float.parseFloat(s[i]));
            if (Checkline == 346) {
                arrData[i][lineNumber - 11] = column[i];
            } else if (Checkline == 348) {
                arrData[i][lineNumber - 13] = column[i];
                if (arrData[i][lineNumber - 13] >= 100) {
                    arrData[i][lineNumber - 13] = (float) (arrData[i][lineNumber - 13] / pow(10, 3));
                }
            }

        }
    }

    public static void HTTP(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 13) {
            String[] s = new String[1];
            for (int i = 0; i < s.length; i++) {
                s[i] = arr[i + 1].split("\"")[1];

                if (s[i].equals("NaN")) {
                    s[i] = "0";
                }
                column[i] = (float) (Float.parseFloat(s[i]));
                arrData[i][lineNumber - 13] = column[i];

            }
        }
    }

}
