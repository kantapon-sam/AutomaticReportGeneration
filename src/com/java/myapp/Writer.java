package com.java.myapp;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.round;

public class Writer {

    public static void Nolinebreaks(FileWriter Max, FileWriter Most, PathFolder Folder, int index, float[] max, float most) {
        try {
            Max.write("\"[IN]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            Max.write("\"[OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            Most.write("\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n");
            Max.close();
            Most.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks7(FileWriter IPPool7, PathFolder Folder, int index, float[] max) {
        try {
            IPPool7.write("\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool7.write("\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool7.write("\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool7.write("\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool7.write("\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool7.write("\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n");
            IPPool7.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter Max_space, FileWriter Most_space, PathFolder Folder, int index, float[] max, float most) {
        try {
            Max_space.write("\"[IN]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            Max_space.write("\"[OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            Most_space.write("\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n\n");
            Max_space.close();
            Most_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void Linespacing7(FileWriter IPPool_space, PathFolder Folder, int index, float[] max) {
        try {
            IPPool_space.write("\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool_space.write("\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool_space.write("\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool_space.write("\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool_space.write("\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool_space.write("\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n\n");
            IPPool_space.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, int Checkline) {
        try {
            if (Checkline == 346) {
                CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            } else if (Checkline == 348) {
                CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            }
            CPU.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, int Checkline) {
        try {
            if (Checkline == 346) {
                CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            } else if (Checkline == 348) {
                CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            }
            CPU_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks8(FileWriter IPPool8, PathFolder Folder, int index, float[] max) {
        try {
            IPPool8.write("\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool8.write("\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool8.write("\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool8.write("\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool8.write("\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool8.write("\"[MTG2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n");
            IPPool8.write("\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[6] + "\n");
            IPPool8.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing8(FileWriter IPPool8_space, PathFolder Folder, int index, float[] max) {
        try {
            IPPool8_space.write("\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool8_space.write("\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool8_space.write("\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool8_space.write("\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool8_space.write("\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool8_space.write("\"[MTG2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n\n");
            IPPool8_space.write("\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[6] + "\n\n");
            IPPool8_space.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks(FileWriter NULL, PathFolder Folder, int index) {
        try {
            NULL.write("\"[null]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\",NULL\n");
            NULL.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter NULL_space, PathFolder Folder, int index) {
        try {
            NULL_space.write("\"[null]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\",NULL\n\n");
            NULL_space.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
