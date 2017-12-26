package com.java.myapp;

import static java.lang.Math.pow;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Column {

    private static String s_arr3 = "";

    public static void column(String[] arr, int lineNumber, float[] column, float[][] arrData, int arr2_length, String[] arr3, long date_start, int num_column) {
        String[] s = new String[num_column - 1];
        if (num_column == 3) {
            CalculateDiv6(arr, s, column, lineNumber, arrData, arr2_length, arr3, date_start);
        } else {
            Calculate(arr, s, column, lineNumber, arrData, arr2_length, arr3, date_start);
        }
    }

    public static void Calculate(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData, int arr2_length, String[] arr3, long date_start) {

        if (arr3.length > 1) {
            s_arr3 = arr3[1].split(",")[1].split("\"")[1];

        }
        if (arr2_length > 1) {
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

    public static void CalculateDiv6(String[] arr, String[] s, float[] column, int lineNumber, float[][] arrData, int arr2_length, String[] arr3, long date_start) {
        if (arr3.length > 1) {
            s_arr3 = arr3[1].split(",")[1].split("\"")[1];
        }
        if (arr2_length > 1) {
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

    public static String getS_arr3() {
        return s_arr3;
    }

}
