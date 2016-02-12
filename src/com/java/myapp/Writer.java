package com.java.myapp;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.round;

public class Writer {

    public static void Nolinebreaks(FileWriter Max, FileWriter Most, PathFolder Folder, int index, float[] max, float most, String str_arr3) {
        try {
            Max.write(str_arr3 + ",\"[IN]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            Max.write(str_arr3 + ",\"[OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            Max.close();
            Most.write(str_arr3 + ",\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n");

            Most.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks7(FileWriter IPPool7, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool7.write(str_arr3 + ",\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool7.write(str_arr3 + ",\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool7.write(str_arr3 + ",\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool7.write(str_arr3 + ",\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool7.write(str_arr3 + ",\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool7.write(str_arr3 + ",\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n");
            IPPool7.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing7(FileWriter IPPool_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool_space.write(str_arr3 + ",\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n\n");
            IPPool_space.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks7(FileWriter IPPool7, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool7.write(str_arr3 + ",\"[PNC1-UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "," + max[2] + "," + max[3] + "," + max[4] + "," + max[5] + "\n");
            IPPool7.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter Max_space, FileWriter Most_space, PathFolder Folder, int index, float[] max, float most, String str_arr3) {
        try {
            Max_space.write(str_arr3 + ",\"[IN]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            Max_space.write(str_arr3 + ",\"[OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            Max_space.close();
            Most_space.write(str_arr3 + ",\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n\n");
            Most_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {

            ex.printStackTrace();
        }

    }

    public static void CPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {

            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {

            CPU_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");

            CPU_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {

            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks8(FileWriter IPPool8, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool8.write(str_arr3 + ",\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool8.write(str_arr3 + ",\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool8.write(str_arr3 + ",\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool8.write(str_arr3 + ",\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool8.write(str_arr3 + ",\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool8.write(str_arr3 + ",\"[MTG2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n");
            IPPool8.write(str_arr3 + ",\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[6] + "\n");
            IPPool8.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing8(FileWriter IPPool8_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool8_space.write(str_arr3 + ",\"[PNC1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[PNC2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[TSG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[LTY]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[MTG]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[MTG2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[5] + "\n\n");
            IPPool8_space.write(str_arr3 + ",\"[UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[6] + "\n\n");
            IPPool8_space.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks8(FileWriter IPPool8, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool8.write(str_arr3 + ",\"[PNC1-UPC]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "," + max[2] + "," + max[3] + "," + max[4] + "," + max[5] + "," + max[6] + "\n");
            IPPool8.close();

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks(FileWriter NULL, FileWriter Most) {
        try {
            Most.write("0,\"[null]\",\n");
            Most.close();
            NULL.write("0,\"[null]\",\n");
            NULL.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter NULL_space, FileWriter Most_space) {
        try {
            Most_space.write("0,\"[null]\",\n\n");
            Most_space.close();
            NULL_space.write("0,\"[null]\",\n\n");
            NULL_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ControlCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ControlCPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            CPU_space.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowControlCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DataCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DataCPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPU_space.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowDataCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DOCSISNolinebreaks(FileWriter IPPool, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool.write(str_arr3 + ",\"[Platinum]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool.write(str_arr3 + ",\"[Gold]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool.write(str_arr3 + ",\"[Silver1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool.write(str_arr3 + ",\"[Silver2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool.write(str_arr3 + ",\"[Bronze]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DOCSISLinespacing(FileWriter IPPool_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IPPool_space.write(str_arr3 + ",\"[Platinum]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[Gold]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[Silver1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[Silver2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool_space.write(str_arr3 + ",\"[Bronze]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot3Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot3Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUSlot3Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1,2,3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "," + round(max[1]) + "," + round(max[2]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot2Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot2Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUSlot2Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1,2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "," + round(max[1]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot8Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot4]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[3]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot5]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[4]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot6]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[5]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot7]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[6]) + "\n");
            CPUSlot.write(str_arr3 + ",\"[CPUSlot8]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[7]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot8Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot4]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[3]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot5]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[4]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot6]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[5]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot7]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[6]) + "\n\n");
            CPUSlot_space.write(str_arr3 + ",\"[CPUSlot8]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[7]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUSlot8Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUSlot.write(str_arr3 + ",\"[CPUSlot1,2,3,4,5,6,7,8]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "," + round(max[1]) + "," + round(max[2]) + "," + round(max[3]) + "," + round(max[4]) + "," + round(max[5]) + "," + round(max[6]) + "," + round(max[7]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUnewNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUnewLinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            CPU_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUnewNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPU.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowIN_OUTNolinebreaks(FileWriter IN_OUTsingle_row, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            IN_OUTsingle_row.write(str_arr3 + ",\"[IN-OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "\n");
            IN_OUTsingle_row.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUPoolNolinebreaks(FileWriter CPUPool, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUPool.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPUPool.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUPoolLinespacing(FileWriter CPUPool_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUPool_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            CPUPool_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowCPUPoolNolinebreaks(FileWriter CPUPool, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            CPUPool.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPUPool.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void HTTPNolinebreaks(FileWriter HTTP, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            HTTP.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            HTTP.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void HTTPLinespacing(FileWriter HTTP_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            HTTP_space.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            HTTP_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowHTTPNolinebreaks(FileWriter HTTP, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            HTTP.write(str_arr3 + ",\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            HTTP.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks4(FileWriter column4, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column4.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            column4.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            column4.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            column4.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing4(FileWriter column4_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column4_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            column4_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            column4_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            column4_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks4(FileWriter column4, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column4.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "," + max[2] + "\n");
            column4.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks5(FileWriter column5, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column5.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            column5.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            column5.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            column5.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            column5.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing5(FileWriter column5_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column5_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            column5_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            column5_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            column5_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            column5_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks5(FileWriter column5, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column5.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "," + max[2] + "," + max[3] + "\n");
            column5.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Nolinebreaks6(FileWriter column6, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            column6.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void Linespacing6(FileWriter column6_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column6_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            column6_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            column6_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            column6_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            column6_space.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            column6_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks6(FileWriter column6, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            column6.write(str_arr3 + ",\"[CPU]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "," + max[2] + "," + max[3] + "," + max[4] + "\n");
            column6.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ConnectionRateNolinebreaks(FileWriter ConnectionRate, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            ConnectionRate.write(str_arr3 + ",\"[Common-Pool]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            ConnectionRate.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ConnectionRateLinespacing(FileWriter ConnectionRate_space, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            ConnectionRate_space.write(str_arr3 + ",\"[Common-Pool]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            ConnectionRate_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowConnectionRateNolinebreaks(FileWriter ConnectionRate, PathFolder Folder, int index, float[] max, String str_arr3) {
        try {
            ConnectionRate.write(str_arr3 + ",\"[Common-Pool]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            ConnectionRate.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks(FileWriter IN_OUTsingle_row, float[] max) {
        try {
            IN_OUTsingle_row.write("0,\"[null]\",\n");
            IN_OUTsingle_row.close();
            IN_OUTsingle_row.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
