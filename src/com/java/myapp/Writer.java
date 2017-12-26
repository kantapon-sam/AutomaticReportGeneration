package com.java.myapp;

import java.io.FileWriter;
import java.io.IOException;


public class Writer {
 public static void Column(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3,int Num_Column) {
        try {
            CPU.write(str_arr3 + ",\"[%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\",");
            for (int i = 0; i < Num_Column-1; i++) {
                CPU.write(max[i] + ",");
            }
            CPU.write("\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
    
}
