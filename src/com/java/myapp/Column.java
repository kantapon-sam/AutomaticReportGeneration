package com.java.myapp;

import static java.lang.Math.pow;

public class Column {

    public static void column_2(String[] arr, int lineNumber, float[] column, float[][] arrData, int Checkline) {
        if (lineNumber >= 11 && Checkline == 346) {
            String[] s = new String[1];
            lineNumber11(arr, s, column, lineNumber, arrData);
        } else if (lineNumber >= 13 && Checkline == 348) {
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
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void column_8(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[7];
            lineNumber11(arr, s, column, lineNumber, arrData);
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

    public static void ControlCPU(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[1];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void DataCPU(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[1];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void CPUSlot3(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[3];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void CPUSlot2(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[2];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void CPUSlot8(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[8];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void ALUCPU(String[] arr, int lineNumber, float[] column, float[][] arrData) {
        if (lineNumber >= 11) {
            String[] s = new String[1];
            lineNumber11(arr, s, column, lineNumber, arrData);
        }
    }

    public static void CPUnew(String[] arr, int lineNumber, float[] column, float[][] arrData) {
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

    public static void lineNumber11(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData) {
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
