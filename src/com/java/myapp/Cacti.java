package com.java.myapp;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;

public class Cacti extends Frame {

    private static int[] Num_Cacti = new int[30];
    private static String Result = null;
    int cactiNum = 0;
    int[] Cacti01_29 = new int[30];
    String Str = "";
    String cacti = "";
    String ReplaceCacti = "";

    public Cacti() {

        // Create Form Frame
        super("Select number cacti");
        setSize(385, 285);
        setLocation(500, 280);
        setLayout(null);

        // Label
        final Label label = new Label();
        label.setAlignment(java.awt.Label.CENTER);
        label.setText("Please select cacti");
        label.setBounds(230, 240, 150, 20);
        add(label);
        // Checkbox
        int L = 0;
        int M = 0;
        int R = 0;
        final Checkbox[] chk = new Checkbox[29];
        for (int i = 0; i < chk.length; i++) {

            if (i >= 0 && i <= 9) {

                chk[i] = new Checkbox("Cacti " + String.format("%02d", i + 1));
                chk[i].setBounds(30, 40 + L, 90, 20);
                L += 20;
                add(chk[i]);
            } else if (i >= 10 && i <= 19) {
                chk[i] = new Checkbox("Cacti " + String.format("%02d", i + 1));
                chk[i].setBounds(150, 40 + M, 90, 20);
                M += 20;
                add(chk[i]);
            } else {
                chk[i] = new Checkbox("Cacti " + String.format("%02d", i + 1));
                chk[i].setBounds(270, 40 + R, 90, 20);
                R += 20;
                add(chk[i]);
            }
            chk[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == 1) {
                        cactiNum = Integer.valueOf(e.getItem().toString().split(" ")[1]);
                        Cacti01_29[cactiNum] = cactiNum;
                        for (int j = 0; j < Cacti01_29.length; j++) {
                            if (Cacti01_29[j] != 0) {
                                Str += String.valueOf(Cacti01_29[j]) + ",";
                            }
                        }
                        cacti = Str;
                        label.setText(cacti.substring(0, cacti.length() - 1));
                        Str = "";
                    } else {
                        try {
                            Str = "";
                            ReplaceCacti = cacti.replace(Integer.valueOf(e.getItem().toString().split(" ")[1]).toString().concat(","), "");
                            int f = ReplaceCacti.length();
                            label.setText(ReplaceCacti.substring(0, f - 1));
                            cacti = ReplaceCacti;
                            Cacti01_29[Integer.valueOf(e.getItem().toString().split(" ")[1])] = 0;
                        } catch (StringIndexOutOfBoundsException ex) {
                            label.setText("Please select cacti");
                        }
                    }

                }
            });
        }
        // Button
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (int i = 0; i < chk.length; i++) {
                    if (chk[i].getState()) {
                        Num_Cacti[i] = i + 1;
                    }
                }

            }
        });
        button.setBounds(130, 240, 90, 24);
        button.setLabel("Submit");
        add(button);

        // Close
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }

    public static int[] getNum_Cacti() {
        return Num_Cacti;
    }

    public static String getResult() {
        return Result;
    }

}
