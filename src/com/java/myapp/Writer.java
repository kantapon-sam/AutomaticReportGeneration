package com.java.myapp;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.round;

public class Writer {

    public static void Nolinebreaks(FileWriter Max, FileWriter Most, PathFolder Folder, int index, float[] max, float most) {
        try {
            Max.write("\"[IN]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            Max.write("\"[OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            Max.close();
            Most.write("\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n");

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
            Max_space.close();
            Most_space.write("\"[MOST]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + most + "\n\n");
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

    public static void CPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max, int Checkline) {
        try {
            if (Checkline == 346) {
                CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
                CPU.close();
            } else if (Checkline == 348) {
                CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
                CPU.close();
            }

            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max, int Checkline) {
        try {

            CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");

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

    public static void Nolinebreaks(FileWriter NULL, FileWriter Most) {
        try {
            Most.write("\"[null]\",\n");
            Most.close();
            NULL.write("\"[null]\",\n");
            NULL.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            System.out.println("bb");
            ex.printStackTrace();
        }
    }

    public static void Linespacing(FileWriter NULL_space, FileWriter Most_space) {
        try {
            Most_space.write("\"[null]\",\n\n");
            Most_space.close();
            NULL_space.write("\"[null]\",\n\n");
            NULL_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ControlCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max) {
        try {
            CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ControlCPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max) {
        try {
            CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            CPU_space.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DataCPUNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max) {
        try {
            CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPU.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DataCPULinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max) {
        try {
            CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPU_space.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DOCSISNolinebreaks(FileWriter IPPool, PathFolder Folder, int index, float[] max) {
        try {
            IPPool.write("\"[Platinum]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            IPPool.write("\"[Gold]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n");
            IPPool.write("\"[Silver1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n");
            IPPool.write("\"[Silver2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n");
            IPPool.write("\"[Bronze]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n");
            IPPool.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void DOCSISLinespacing(FileWriter IPPool_space, PathFolder Folder, int index, float[] max) {
        try {
            IPPool_space.write("\"[Platinum]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            IPPool_space.write("\"[Gold]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[1] + "\n\n");
            IPPool_space.write("\"[Silver1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[2] + "\n\n");
            IPPool_space.write("\"[Silver2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[3] + "\n\n");
            IPPool_space.write("\"[Bronze]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[4] + "\n\n");
            IPPool_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot3Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.write("\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot3Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot_space.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot2Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot2Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot_space.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot8Nolinebreaks(FileWriter CPUSlot, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n");
            CPUSlot.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n");
            CPUSlot.write("\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n");
            CPUSlot.write("\"[CPUSlot4]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[3]) + "\n");
            CPUSlot.write("\"[CPUSlot5]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[4]) + "\n");
            CPUSlot.write("\"[CPUSlot6]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[5]) + "\n");
            CPUSlot.write("\"[CPUSlot7]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[6]) + "\n");
            CPUSlot.write("\"[CPUSlot8]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[7]) + "\n");
            CPUSlot.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUSlot8Linespacing(FileWriter CPUSlot_space, PathFolder Folder, int index, float[] max) {
        try {
            CPUSlot_space.write("\"[CPUSlot1]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[0]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot2]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[1]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot3]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[2]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot4]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[3]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot5]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[4]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot6]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[5]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot7]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[6]) + "\n\n");
            CPUSlot_space.write("\"[CPUSlot8]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + round(max[7]) + "\n\n");
            CPUSlot_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUnewNolinebreaks(FileWriter CPU, PathFolder Folder, int index, float[] max) {
        try {
            CPU.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n");
            CPU.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CPUnewLinespacing(FileWriter CPU_space, PathFolder Folder, int index, float[] max) {
        try {
            CPU_space.write("\"[CPU%]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "\n\n");
            CPU_space.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void single_rowNolinebreaks(FileWriter IN_OUTsingle_row, PathFolder Folder, int index, float[] max) {
        try {
            IN_OUTsingle_row.write("\"[IN-OUT]" + Folder.getFileReport()[index].getName().split(".csv")[0] + "\"," + max[0] + "," + max[1] + "\n");
            IN_OUTsingle_row.close();
            System.out.println("Write success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
